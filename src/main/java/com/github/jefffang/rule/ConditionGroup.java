package com.github.jefffang.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionGroup extends AbstractCondition {
    private List<Condition> conditions = new ArrayList<>();
    private ConditionGroupOperator groupOperator;

    public static ConditionGroup all(Condition...conditions) {
        ConditionGroup group = new ConditionGroup();
        group.and(conditions);
        return group;
    }

    public static ConditionGroup any(Condition...conditions) {
        ConditionGroup group = new ConditionGroup();
        group.or(conditions);
        return group;
    }

    public ConditionGroup and(Condition...conditions) {
        groupOperator = ConditionGroupOperator.AND;
        this.conditions.addAll(Arrays.asList(conditions));
        return this;
    }

    public ConditionGroup or(Condition...conditions) {
        groupOperator = ConditionGroupOperator.OR;
        this.conditions.addAll(Arrays.asList(conditions));
        return this;
    }

    @Override
    protected boolean test(Fact fact) {
        if (groupOperator == ConditionGroupOperator.AND) {
            return conditions.stream().allMatch(cond -> cond.satisfy(fact));
        }
        return conditions.stream().anyMatch(cond -> cond.satisfy(fact));
    }
}

package com.github.jefffang.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ConditionGroup extends AbstractCondition {
    private List<Condition> conditions = new ArrayList<>();

    public static AndConditionGroup all(Condition...conditions) {
        AndConditionGroup group = new AndConditionGroup();
        group.and(conditions);
        return group;
    }

    public static OrConditionGroup any(Condition...conditions) {
        OrConditionGroup group = new OrConditionGroup();
        group.or(conditions);
        return group;
    }

    protected void addConditions(Condition...conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    protected List<Condition> conditions() {
        return conditions;
    }
}

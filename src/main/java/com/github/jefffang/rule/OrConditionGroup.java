package com.github.jefffang.rule;

public class OrConditionGroup extends ConditionGroup {

    public OrConditionGroup or(Condition...conditions) {
        addConditions(conditions);
        return this;
    }

    @Override
    protected boolean test(Fact fact) {
        return conditions().stream().allMatch(cond -> cond.satisfy(fact));
    }
}

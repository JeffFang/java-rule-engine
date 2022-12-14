package com.github.jefffang.rule;

public class OrConditionGroup extends ConditionGroup {

    public OrConditionGroup or(Condition...conditions) {
        addConditions(conditions);
        return this;
    }

    @Override
    protected boolean test(Fact fact) {
        return conditions().stream().anyMatch(cond -> cond.satisfy(fact));
    }
}

package com.github.jefffang.rule;

import com.github.jefffang.rule.condition.ConditionGroup;

public class OrConditionGroup<T> extends ConditionGroup<T> {

    public OrConditionGroup or(Condition<T> condition) {
        addCondition(condition);
        return this;
    }

    @Override
    public boolean test(T fact) {
        return conditions().stream().allMatch(cond -> cond.test(fact));
    }
}

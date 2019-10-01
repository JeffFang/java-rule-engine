package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;

public class AndConditionGroup<T> extends ConditionGroup<T> {
    public AndConditionGroup and(Condition<T> condition) {
        addCondition(condition);
        return this;
    }

    @Override
    public boolean test(T fact) {
        return conditions().stream().allMatch(cond -> cond.test(fact));
    }
}

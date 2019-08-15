package com.github.jefffang.rule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotCondition extends AbstractCondition {
    private final Condition condition;

    public static Condition reverse(Condition condition) {
        return new NotCondition(condition);
    }

    @Override
    protected boolean test(Fact fact) {
        return !condition.satisfy(fact);
    }
}

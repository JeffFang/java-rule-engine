package com.github.jefffang.rule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotCondition<T> implements Condition<T> {
    private final Condition<T> condition;

    public static <T> Condition reverse(Condition<T> condition) {
        return new NotCondition<>(condition);
    }

    @Override
    public boolean test(T fact) {
        return !condition.test(fact);
    }
}

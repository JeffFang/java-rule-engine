package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class SimpleCondition<T> implements Condition<T> {
    private final T value;

    @Override
    public boolean test(T fact) {
        return Objects.equals(fact, value);
    }
}

package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RangeCondition<T extends Comparable<T>> implements Condition<T> {
    private final T lowBoundInclusive;
    private final T hiBoundExclusive;

    @Override
    public boolean test(T fact) {
        return (lowBoundInclusive == null || fact.compareTo(lowBoundInclusive) >= 0) &&
        (hiBoundExclusive == null || fact.compareTo(hiBoundExclusive) < 0);
    }
}

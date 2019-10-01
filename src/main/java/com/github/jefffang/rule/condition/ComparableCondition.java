package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ComparableCondition<T extends Comparable<T>> implements Condition<T> {
    private final T value;
    @NonNull private final ConditionOperator operator;

    @Override
    public boolean test(@NonNull T fact) {
        return operator == ConditionOperator.EQ && fact.compareTo(value) == 0
                || operator == ConditionOperator.GT && fact.compareTo(value) > 0
                || operator == ConditionOperator.GET && fact.compareTo(value) >= 0
                || operator == ConditionOperator.LT && fact.compareTo(value) < 0
                || operator == ConditionOperator.LET && fact.compareTo(value) <= 0;
    }
}

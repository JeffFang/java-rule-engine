package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;
import com.github.jefffang.rule.Fact;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SingleFieldCondition<T> implements Condition<Fact> {
    private final String field;
    private final Condition<T> condition;

    @Override
    public boolean test(Fact fact) {
        return condition.test(fact.getFact(field));
    }
}

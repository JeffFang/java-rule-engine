package com.github.jefffang.rule.condition;

import java.util.Optional;

import com.github.jefffang.rule.Fact;

public class RangeCondition<T extends Comparable> extends SingleFieldCondition {
    private T lowBoundInclusive;
    private T hiBoundExclusive;

    public RangeCondition(String field, T lowBoundInclusive, T hiBoundExclusive) {
        super(field);
        this.lowBoundInclusive = lowBoundInclusive;
        this.hiBoundExclusive = hiBoundExclusive;
    }

    @Override
    public boolean test(Fact fact) {
        Optional<T> f = fact(fact);
        return f.filter(dt -> (lowBoundInclusive == null || dt.compareTo(lowBoundInclusive) >= 0)
                && (hiBoundExclusive == null || dt.compareTo(hiBoundExclusive) < 0))
                .isPresent();
    }
}

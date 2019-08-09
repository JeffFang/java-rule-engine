package com.github.jefffang.rule.condition;

import java.util.Optional;

import com.github.jefffang.rule.Fact;

public class RangeCondition<T extends Comparable> extends SingleFieldCondition {
    private T start;
    private T end;

    public RangeCondition(String field, T start, T end) {
        super(field);
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean test(Fact fact) {
        Optional<T> f = fact(fact);
        return f.filter(dt -> (start == null || dt.compareTo(start) >= 0)
                && (end == null || dt.compareTo(end) < 0))
                .isPresent();
    }
}

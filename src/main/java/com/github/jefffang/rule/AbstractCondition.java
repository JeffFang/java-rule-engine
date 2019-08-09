package com.github.jefffang.rule;

public abstract class AbstractCondition implements Condition {
    private boolean reverse;

    protected abstract boolean test(Fact fact);

    @Override
    public boolean satisfy(Fact fact) {
        return reverse != test(fact);
    }

    @Override
    public Condition reverse() {
        reverse = !reverse;
        return this;
    }
}

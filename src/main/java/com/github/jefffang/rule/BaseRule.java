package com.github.jefffang.rule;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class BaseRule<T extends Fact> implements Rule<T> {
    @Getter @Setter private String name;
    @Getter @Setter private int priority;
    @Getter @Setter private boolean exclusive;
    private Condition<T> condition;
    private Action<T> action;

    @Override
    public Rule<T> given(@NonNull Condition<T> condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public Rule<T> then(Action<T> action) {
        this.action = action;
        return this;
    }

    @Override
    public boolean evaluate(T fact) {
        return condition.test(fact);
    }

    @Override
    public void doAction(T fact) {
        action.doAction(fact);
    }
}

package com.github.jefffang.rule;

import lombok.NonNull;

public interface Rule<T> {
    String getName();

    int getPriority();

    boolean isExclusive();

    Rule<T> given(@NonNull Condition<T> condition);

    Rule<T> then(Action<T> action);

    boolean evaluate(T fact);

    void doAction(T fact);
}

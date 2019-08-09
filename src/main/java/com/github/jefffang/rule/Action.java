package com.github.jefffang.rule;

public interface Action<T extends Fact> {
    void doAction(T fact);
}

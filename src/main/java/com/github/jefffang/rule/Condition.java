package com.github.jefffang.rule;

public interface Condition<T> {
    boolean test(T fact);
}

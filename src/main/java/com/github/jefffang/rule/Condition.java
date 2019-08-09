package com.github.jefffang.rule;

public interface Condition {
    boolean satisfy(Fact fact);

    Condition reverse();
}

package com.github.jefffang.rule;

public interface Fact {
    <T> T getFact(String key);
}

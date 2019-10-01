package com.active.jefffang.rule.condition;

import com.github.jefffang.rule.condition.SimpleCondition;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleConditionTestCase {
    @Test
    public void simpleConditionReturnTrueWhenBothNull() {
        assertThat(new SimpleCondition<>(null).test(null)).isTrue();
    }

    @Test
    public void simpleConditionReturnFalseWhenEitherIsNull() {
        assertThat(new SimpleCondition<>("").test(null)).isFalse();
        assertThat(new SimpleCondition<>(null).test("")).isFalse();
    }
}

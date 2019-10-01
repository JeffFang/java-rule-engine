package com.active.jefffang.rule.condition;

import com.github.jefffang.rule.Fact;
import com.github.jefffang.rule.condition.SimpleCondition;
import com.github.jefffang.rule.condition.SingleFieldCondition;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleFieldConditionTestCase {
    @Test
    public void singleFieldSimpleCondition() {
        SingleFieldCondition<String> cond = new SingleFieldCondition<>("field", new SimpleCondition<>("value"));
        Fact fact = new Fact() {
            @Override
            public <T> T getFact(String key) {
                return (T) "value";
            }
        };

        assertThat(cond.test(fact)).isTrue();
    }
}

package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;
import com.github.jefffang.rule.Fact;

public class DualFieldsCondition<T> implements Condition<Fact> {
    private String field1;
    private String field2;
    private Condition<T> condition;

    @Override
    public boolean test(Fact fact) {
        return condition.test(fact.getFact(field1)) && condition.test(fact.getFact(field2));
    }
}

package com.github.jefffang.rule.fact;

import com.github.jefffang.rule.Fact;

public class DefaultKVFact implements Fact {
    private KVFactPairs kvFacts;

    @Override
    public <T> T getFact(String key) {
        return (T) kvFacts.value(key);
    }
}

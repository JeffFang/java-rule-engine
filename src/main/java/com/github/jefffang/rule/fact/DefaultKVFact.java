package com.github.jefffang.rule.fact;

import com.github.jefffang.rule.Fact;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultKVFact implements Fact {
    private final KVFactPairs kvFacts;

    @Override
    public <T> T getFact(String key) {
        return (T) kvFacts.value(key);
    }
}

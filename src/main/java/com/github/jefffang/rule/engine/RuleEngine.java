package com.github.jefffang.rule.engine;

import com.github.jefffang.rule.Rule;

import java.util.List;

public interface RuleEngine {
    <T> boolean runRules(List<Rule<T>> rules, T fact);
}

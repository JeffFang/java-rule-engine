package com.github.jefffang.rule.engine;

import java.util.List;

import com.github.jefffang.rule.Fact;
import com.github.jefffang.rule.Rule;

public interface RuleEngine {
    boolean runRules(List<Rule> rules, Fact fact);
}

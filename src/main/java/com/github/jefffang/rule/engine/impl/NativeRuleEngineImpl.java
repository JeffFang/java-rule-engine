package com.github.jefffang.rule.engine.impl;

import com.github.jefffang.rule.Rule;
import com.github.jefffang.rule.engine.RuleEngine;

import java.util.Comparator;
import java.util.List;

public class NativeRuleEngineImpl implements RuleEngine {

    @Override
    public <T> boolean runRules(List<Rule<T>> rules, T fact) {
        boolean anyRuleFired = false;

        rules.sort(Comparator.comparingInt(Rule::getPriority));
        for (Rule<T> r : rules) {
            boolean toFire = r.evaluate(fact);
            if (toFire) {
                anyRuleFired = true;
                r.doAction(fact);
                if (r.isExclusive()) {
                    break;
                }
            }
        }

        return anyRuleFired;
    }
}

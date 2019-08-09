package com.github.jefffang.rule.engine.impl;

import java.util.Comparator;
import java.util.List;

import com.github.jefffang.rule.Fact;
import com.github.jefffang.rule.Rule;
import com.github.jefffang.rule.engine.RuleEngine;

public class NativeRuleEngineImpl implements RuleEngine {

    @Override
    public boolean runRules(List<Rule> rules, Fact fact) {
        boolean anyRuleFired = false;

        rules.sort(Comparator.comparingInt(Rule::getPriority));
        for (Rule r : rules) {
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

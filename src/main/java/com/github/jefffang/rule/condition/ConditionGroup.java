package com.github.jefffang.rule.condition;

import com.github.jefffang.rule.Condition;
import com.github.jefffang.rule.OrConditionGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class ConditionGroup<T> implements Condition<T> {
    private List<Condition<T>> conditions = new ArrayList<>();

    public static <T> AndConditionGroup all(List<Condition<T>> conditions) {
        AndConditionGroup<T> group = new AndConditionGroup<>();
        for (Condition<T> c : conditions) {
            group.and(c);
        }
        return group;
    }

    public static <T> OrConditionGroup any(List<Condition<T>> conditions) {
        OrConditionGroup<T> group = new OrConditionGroup<>();
        for (Condition<T> c : conditions) {
            group.or(c);
        }
        return group;
    }

    protected void addCondition(Condition<T> condition) {
        this.conditions.add(condition);
    }

    protected List<Condition<T>> conditions() {
        return conditions;
    }
}

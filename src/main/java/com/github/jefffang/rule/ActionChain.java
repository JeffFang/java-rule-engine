package com.github.jefffang.rule;

import java.util.ArrayList;
import java.util.List;

public class ActionChain<T extends Fact> implements Action<T> {
    private List<Action<T>> actions;

    private ActionChain(List<Action<T>> actions) {
        this.actions = new ArrayList<>();
        this.actions.addAll(actions);
    }

    public static <A extends Fact> ActionChain<A> all(List<Action<A>> actions) {
        return new ActionChain<>(actions);
    }

    public ActionChain<T> then(Action<T> action) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }

        this.actions.add(action);
        return this;
    }

    @Override
    public void doAction(T fact) {
        actions.forEach(act -> act.doAction(fact));
    }
}

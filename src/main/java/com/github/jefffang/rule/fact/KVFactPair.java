package com.github.jefffang.rule.fact;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KVFactPair {
    private String key;
    private Object value;
}

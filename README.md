# java-rule-engine: Rule Engine Libraries for Java
Java-rule-engine is a simple java based rule engine libraries that supports create rule with condition and actions, also comes with a native rule engine to execute all rules.

## Dependencies

## Example

### Define conditions

```java
        Condition male = new SimpleCondition<>("gender", "male");
        Condition female = new SimpleCondition<>("gender", "female");

        Condition adult = new RangeCondition<Integer>("age", 18, 100);

        Condition maleAdult = ConditionGroup.all(male, adult);
        Condition femaleAdult = ConditionGroup.all(female, adult);
        Condition maleNotAdult = ConditionGroup.all(male, adult.reverse());
        Condition adultMaleOrFemale = ConditionGroup.all(ConditionGroup.any(male, female), adult);
```

### Define actions

```java
        Action<Fact> print = f -> System.out.println("rule fired");
        Action<Fact> printprint = ActionChain.all(Arrays.asList(print, print));
```

### Define rules

```java
        RuleEngine ruleEngine = new NativeRuleEngineImpl();

        List<KVFactPair> facts = new ArrayList<>();
        facts.add(new KVFactPair("gender", "male"));
        facts.add(new KVFactPair("age", 20));

        Fact fact = new DefaultKVFact(new KVFactPairs(facts));
        ruleEngine.runRules(Arrays.asList(printWhenMaleNotAdult, printForFemaleAdult), fact);
```
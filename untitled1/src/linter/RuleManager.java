package linter;

import java.util.ArrayList;
import java.util.List;

public class RuleManager {
    private List<Rule> rules;

    public RuleManager() {
        this.rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return new ArrayList<>(rules);
    }
}

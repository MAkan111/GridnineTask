package Filters.FilterChains;

import Filters.FilterRules.FilterRule;
import Flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<FilterRule> rules = new ArrayList<>();

    public List<FilterRule> getRules() {
        return rules;
    }

    public void setRules(List<FilterRule> rules) {
        this.rules = rules;
    }

    public void addRule(FilterRule rule)  {
        rules.add(rule);
    }

    public boolean applyAll(Flight flight) {
        for (FilterRule rule : rules) {
            if (!rule.apply(flight)) {
                return false;
            }
        }
        return true;
    }
}

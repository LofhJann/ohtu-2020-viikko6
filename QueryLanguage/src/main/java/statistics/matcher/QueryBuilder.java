package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {

    private final ArrayList<Matcher> matchers = new ArrayList<>();

    public QueryBuilder() {
        matchers.add(new All());
    }

    public Matcher build() {
        Matcher[] matchersArray = this.matchers.toArray(Matcher[]::new);
        this.matchers.clear();
        return new And(matchersArray);
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
         matchers.add(new HasAtLeast(value, category));
         return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher matcher, Matcher matcher2) {
        matchers.add(new Or(matcher, matcher2));
        return this;
    }
}

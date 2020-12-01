package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {

    private final ArrayList<Matcher> matchers = new ArrayList<>();

    public QueryBuilder() {
        matchers.add(new All());
    }

    public Matcher build() {
        return new And(matchers.toArray(Matcher[]::new));
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
}

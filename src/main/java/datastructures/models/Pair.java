package datastructures.models;

import java.util.Objects;

public class Pair<A, B> {

    public A first;
    public B second;

    public Pair(A fst, B snd) {
        this.first = fst;
        this.second = snd;
    }

    public String toString() {
        return "Pair[" + first + "," + second + "]";
    }

    public boolean equals(Object other) {
        return
                other instanceof Pair<?,?> &&
                        Objects.equals(first, ((Pair<?,?>)other).first) &&
                        Objects.equals(second, ((Pair<?,?>)other).second);
    }

    public int hashCode() {
        if (first == null) return (second == null) ? 0 : second.hashCode() + 1;
        else if (second == null) return first.hashCode() + 2;
        else return first.hashCode() * 17 + second.hashCode();
    }

    public static <A,B> Pair<A,B> of(A a, B b) {
        return new Pair<>(a,b);
    }
}

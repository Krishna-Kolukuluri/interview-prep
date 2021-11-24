package concepts;

public class AccessModifiersExample {
    //'default' is default access modifier when no access modifier is declared. which have access at package level(across
    // entire package where it is defined.
    //'private' variables,method, class are only accessible inside the class where they declared.
    //'protected' variables,method, class are accessible inside all class in the same package and in subclasses outside of package.
    //'public' variables,method, class are accessible everywhere.
    public static void main(String[] args) {
        String str = "000";
    }
}

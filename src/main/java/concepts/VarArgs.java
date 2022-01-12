package concepts;

public class VarArgs {
    public static void main(String[] args) {
        //Can be passed arguments as below variants
        getLearn("One"); //OR
        getLearn("One", "Two");// OR
        getLearn("One", "Two", "Three"); //OR
        getLearn(new String[]{"One", "Two", "Three"});
    }
    /*
    Ability to provide '...' is a feature called varargs (variable arguments) which was introduced as part of Java 5.
    The function having '...' in the below example indicates that it can receive multiple arguments of the datatype String.
    * */
    public static void getLearn(String... variables){
        for(String variable : variables){
            System.out.println(variable);
        }
    }
}

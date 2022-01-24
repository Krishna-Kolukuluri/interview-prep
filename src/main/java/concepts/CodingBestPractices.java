package concepts;

import java.util.*;

public class CodingBestPractices {
    //1. User proper naming convention like above class name

    //2. Class members must be accessed privately
    //public String name; // this is bad instead use private then define setName(String name) to set name like below
    private String name;
    public void setName(String name){
        this.name = name;
    }

    //3. Use underscores in lengthy numeric literals
    //int num = 58356823 instead of this use below approach to make code more readable.
    int num = 58_356_823;

    //4. Never leave catch blocks empty
    public void testException(){
        try{

        }catch (Exception e){
            //Handle exception or rethrow or log exception but never leave it empty
        }finally {

        }


        //5. Use StringBuilder or StringBuffer for String concatenation
        //String str = "test";
        //str += "TestTwo"; instead use StringBuilder
        StringBuilder sb= new StringBuilder();
        sb.append("test");
        sb.append("TestTwo");
    }

    //6. Avoid redundant initializations
    int i = 0; //avoid this as int default value is 0. instead use int i;
    boolean flag;//default value is false so dont initialize again to false;
    class Person {
        private String name = null; // Avoid
        private int age = 0; // Avoid
        private boolean isGenius = false; //Avoid
    }

    public void testForLoop(){
        List<String> words = new ArrayList<>();
        //7. Use enhanced for loops instead of for loops with counter
        for(int i=0; i < words.size(); i++);//do use this instead use below variant
        for(String word: words);//use this whenever possible.
    }

    //8. Proper handling of NullPointerException
    public void npException(String str){
        str.length();//this will throw NPE when null is passed as str. better way to handle this is check null before accessing it.
        if(str == null){
            throw new NullPointerException("str cannot be null");
        }
    }

    //9. Use Double when precision is important, otherwise use float as it take half the space of Double.

    //10. Use Single quotes for getting char integer value, else for concatenation use double quotes for string concat.
    private void  quotes(){
        System.out.println("A" + "B");// --> "AB";
        System.out.println('A' + 'B'); // --> 131 i.e.
        List<String> list = Collections.EMPTY_LIST;
    }

    //11. Avoiding memory leaks
    //Release database connections after use or get it from existing connection pool
    //Use finally blocks to close/release resources like files/IO connections/


    //12. Return Collections.EMPTY_LIST instead of returning null.

    //13. Handle String efficiently.
    /*For instance, if two Strings are concatenated in a loop, a new String object will be created at every iteration.
    If the number of loops is significant, it can cause a lot of memory wastage and will increase the performance time as well.
    Another case would be of instantiating a String Object, a java best practice is to avoid using constructors for
    instantiation and instantiation should be done directly. It is way faster as compared to using a constructor.*/

    //14. Using Enums or Constant class instead of Constant interface.
    //i.e.It’s a very bad idea to create an interface which is solely for declaring some constants without any methods.
    // Here’s such an interface: avoid below implementation instead use Enums or Constant class
    interface color{
        public static final int RED = 0xff0000;
        public static final int BLACK = 0x000000;
        public static final int WHITE = 0xffffff;
    }
    public enum Color{
        BLACK,WHITE,RED;
    }
    class colorConstants{
        public static final int RED = 0xff0000;
        public static final int BLACK = 0x000000;
        public static final int WHITE = 0xffffff;
    }

    //15. Use interface references for Collections type declaration
    private HashSet<Integer> numbers = new HashSet<>(); //Avoid this instead use below
    private Set<Integer> nums = new HashSet<>();//Use this approach to shield any future changes in HashSet.

}

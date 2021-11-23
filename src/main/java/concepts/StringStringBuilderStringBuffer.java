package concepts;

public class StringStringBuilderStringBuffer {
    public static String stringConcat(String str){
        //Here new str object gets created at its referenced in stringConcat method and original str object is not
        // altered from caller
        str += "Krishna";
        return str;
    }

    public static StringBuilder stringBuilderConcat(StringBuilder str){
        //str StringBuilder gets updated with 'Krishna' string appended to it.
        //StringBuilder is not thread safe as its not implemented synchronized methods for thread safety.
        str.append("Krishna");
        return str;
    }

    public static StringBuffer stringBufferConcat(StringBuffer stringBuffer){
        //str StringBuffer gets updated with 'Krishna' string appended to it.
        //StringBuffer is thread safe as its implemented synchronized methods for thread safety.
        stringBuffer.append("Krishna");
        return stringBuffer;
    }

    public static void main(String[] args) {
        // Custom input string
        // String 1
        String s1 = "Kolukuluri ";

        // Calling above defined method
        stringConcat(s1);

        // s1 is not changed
        System.out.println("String: " + s1);

        // String 1
        StringBuilder s2 = new StringBuilder("Kolukuluri ");

        // Calling above defined method
        stringBuilderConcat(s2);

        // s2 is changed
        System.out.println("StringBuilder: " + s2);

        // String 3
        StringBuffer s3 = new StringBuffer("Kolukuluri ");

        // Calling above defined method
        stringBufferConcat(s3);

        // s3 is changed
        System.out.println("StringBuffer: " + s3);
    }
}

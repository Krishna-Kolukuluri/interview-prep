package datastructures.dstype.stringType;

public class BasicCompareOperations {
    public static void main(String[] args) {
        String str= "Test";
        String strTwo = str;
        if(strTwo == str){
            System.out.println(true);
        }
        String strThree = new String(strTwo);
        System.out.println(strTwo == strThree);
        System.out.println(strTwo.compareTo(strThree));
        System.out.println(strThree.equals(str));


        String strIm = "Hello World";
    }
}

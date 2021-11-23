package concepts;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {
    final String nameOne = "Kolukuluri";
    final List<String> stringList = new ArrayList<>();
    public static void main(String[] args) {
        System.gc();
        Runtime.getRuntime().gc();
        String name = "Krishna";
        String newName = name.replace("na", "--");

    }

    public void testMethod(){
        //Note that final only forbids us from changing the reference the variable holds, it doesn't protect us
        // from changing the internal state of the object it refers to by using its public API:
        //nameOne = "Krishna"; --> Not allowed to change reference of the variable which declared with final keyword.
        stringList.add("Krishna"); // --> Allowed
        //stringList = new ArrayList<>(); // --> Not allowed to change reference of the variable which declared with final keyword.
    }
}

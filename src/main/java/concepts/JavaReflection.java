package concepts;

import java.lang.reflect.*;

public class JavaReflection {
    public static void main(String[] args) {
        GoatEntryPoint goatEntryPoint = new GoatEntryPoint();
        BirdEntryPoint birdEntryPoint = new BirdEntryPoint();
        try {
            birdEntryPoint.inspectObject();
            //goatEntryPoint.inspectObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.inspectObject();
    }
}
class EntryPoint{
    Immutability immutability = new Immutability(9.0,"Buy", new CurrencyPair("USD", "INR"));

    public void inspectObject(){
        Field[] fields  = immutability.getClass().getDeclaredFields();
        for (Field field: fields){
            System.out.println(field.getName());
        }
    }
}

class GoatEntryPoint{

    public void inspectObject() throws ClassNotFoundException {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());

        clazz = Class.forName("concepts.Goat");
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getInterfaces());
        System.out.println(clazz.getConstructors()[0].getName());
        int goatModifier = clazz.getModifiers();
        System.out.println(Modifier.isPublic(goatModifier));

    }
}

class BirdEntryPoint{
    public void inspectObject() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("concepts.Bird");
        Constructor<?>[] constructors = birdClass.getConstructors();
        System.out.println(constructors.length);

        try {
            Constructor<?> cons1 = birdClass.getConstructor();
            Constructor<?> cons2 = birdClass.getConstructor(String.class);
            Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);

            Bird bird1 = (Bird) cons1.newInstance();
            Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
            Bird bird3 = (Bird) cons3.newInstance("dove", true);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

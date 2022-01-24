package designpatterns.creational.prototype;

import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeExample emps = new ProtoTypeExample();
        emps.loadData();

        //Use the clone method to get the Employee object
        ProtoTypeExample empsNew = (ProtoTypeExample) emps.clone();
        ProtoTypeExample empsNew1 = (ProtoTypeExample) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }
}

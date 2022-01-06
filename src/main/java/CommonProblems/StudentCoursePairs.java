package CommonProblems;

import java.util.*;
import java.util.stream.Collectors;

/*
*
You are a developer for a university. Your current project is to develop a system for students to find courses they
share with friends. The university has a system for querying courses students are enrolled in, returned as a
list of (ID, course) pairs. Write a function that takes in a list of (student ID number, course name) pairs and returns,
for every pair of students, a list of all courses they share
*
Sample Input:
student_course_pairs_1 = [
["58", "Software Design"],
["58", "Linear Algebra"],
["94", "Art History"],
["94", "Operating Systems"],
["17", "Software Design"],
["58", "Mechanics"],
["58", "Economics"],
["17", "Linear Algebra"],
["17", "Political Science"],
["94", "Economics"],
["25", "Economics"],
]
* */
public class StudentCoursePairs {
    public static void main(String[] args) {
        String[][] studentCourses = {
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"}
        };
        HashMap<String, List<String>> pairs = getCommonCourses(studentCourses);
        System.out.println(pairs);
    }
    public static HashMap<String, List<String>> getCommonCourses(String[][] studentCourses){
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, List<String>> result =  new HashMap<>();
        for(String[] studentCourse: studentCourses){
            HashSet<String> set;
            if(map.containsKey(studentCourse[0])){
                set = map.get(studentCourse[0]);
            }else{
                set = new HashSet<>();
            }
            set.add(studentCourse[1]);
            map.put(studentCourse[0], set);
        }
        List<String> studentIds =  map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        for(int i=0;i<studentIds.size();i++){
            HashSet<String> stdOne = map.get(studentIds.get(i));
            for(int j=i+1; j<studentIds.size(); j++){
                HashSet<String> stdTwo = map.get(studentIds.get(j));
                stdTwo.retainAll(stdOne);
                List<String> common = new ArrayList<>();
                common.addAll(stdTwo);
                result.put(studentIds.get(i) + "-"+studentIds.get(j), common);
            }
        }
        return result;
    }
}

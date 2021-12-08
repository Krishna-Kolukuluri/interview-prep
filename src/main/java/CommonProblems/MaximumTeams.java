package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
*
                               * Amazon OA Question *
Given an skill array example - [3,4,3,1,6,5] and teamSize = 3 and maxDiff =2.
Find max number of teams can be formed with skills difference(maxLevel - minLevel) not greater than maxDiff
*
* */
public class MaximumTeams {
    public static void main(String[] args) {
        List<Integer> skills = new ArrayList<>(Arrays.asList(3,4,3,1,6,5));
        int maxDiff = 2;
        int teamSize = 3;
        System.out.println(countMaximumTeams(skills, teamSize, maxDiff));
    }

    private static int countMaximumTeams(List<Integer> skills, int teamSize, int maxDiff){
        Collections.sort(skills);
        int index = 0;
        int teamsCount = 0;
        while (index<=skills.size() - teamSize){
            if(skills.get(index + teamSize - 1) - skills.get(index) <= maxDiff){
                teamsCount +=1;
                index += teamSize;
            }
            else {
                index++;
            }
        }
        return teamsCount;
    }
}


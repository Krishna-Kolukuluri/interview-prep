package CommonProblems;

public class NumOfSundays {
    static int[] learYearMonths = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
    static int[] nonLeapYearMonths = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
    //Number of sundays b/w 1901 to 2000 given 1900 Jan 1st is monday
    public static void main(String[] args) {
        int startYear  = 1901;
        int endYear  = 2000;
        int numOfSundays = numOfSundays(startYear, endYear);
        System.out.println(numOfSundays);
    }

    public static int numOfSundays(int startYear, int endYear){
        int numOfSundays = 0;
        int presentDay = 1 + (isLeapYear(endYear)? 366: 365);
        for(int year=startYear;year<=endYear; year++){
            int[] months = getMonthsForYear(year);
            for(int month: months){
                presentDay += month;
                if(presentDay % 7 == 0){
                    numOfSundays += 1;
                }
            }
        }

        return numOfSundays;

    }
    public static boolean isLeapYear(int year){
        boolean leapYear = false;
        if(year % 4 == 0){
             leapYear = true;
        }
        if(year % 100 == 0){
            leapYear = false;
        }
        if(year % 400 == 0){
            leapYear = true;
        }
        return leapYear;
    }

    public static int[] getMonthsForYear(int year){
        return isLeapYear(year)? learYearMonths: nonLeapYearMonths;
    }
}

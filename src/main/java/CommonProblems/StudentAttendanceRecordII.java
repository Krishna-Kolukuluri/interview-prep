package CommonProblems;
/*
* https://leetcode.com/problems/student-attendance-record-ii/
* https://leetcode.com/problems/student-attendance-record-ii/discuss/101638/Simple-Java-O(n)-solution
*An attendance record for a student can be represented as a string where each character signifies whether the student was
*absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an
attendance award. The answer may be very large, so return it modulo 109 + 7.
*
* Example 1:
Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
* */
public class StudentAttendanceRecordII {
    static final int mod = (int) (1e9+7);
    public static int checkRecord(int n){
        long[] P = new long[n+1]; //end with P w/o A
        long[] L = new long[n+1]; //end with L w/o A
        P[0] = P[1] = L[1] = 1;
        for(int i = 2; i <= n; i++){
            P[i] = (P[i-1] + L[i-1]) % mod;
            L[i] = (P[i-1] + P[i-2]) % mod;
        }
        long res = (P[n] + L[n]) % mod;
        //insert A
        for(int i = 0; i < n; i++){
            long s = ((P[i] + L[i])%mod * (P[n-i-1] + L[n-i-1])%mod )% mod;
            res = (res + s) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(2));
    }
}

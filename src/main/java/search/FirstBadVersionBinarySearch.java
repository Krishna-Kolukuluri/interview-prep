package search;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
your product fails the quality check. Since each version is developed based on the previous version, all the versions
after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the
first bad version. You should minimize the number of calls to the API.
* */
public class FirstBadVersionBinarySearch {
    static int firstBadVersion = 10;
    public static void main(String[] args) {
        int result = findFirstBadVersion(50);
        System.out.println(result);
    }

    public static int findFirstBadVersion(int version){

        int left = 1;
        int right = version;
        while (left<right){
            int pivot = left + (right - left)/2;
            if(!isBadVersion(pivot)){
                left = pivot + 1;
            }
            else{
                right = pivot;
            }
        }
        return left;
    }
    public static boolean isBadVersion(int version){
        if(version>=firstBadVersion){
            return true;
        }
        else{
            return false;
        }
    }
}
/*
Complexity Analysis:
Time complexity : O(logN).
Let's compute time complexity with the help of master theorem.
The equation represents dividing the problem up into aa subproblems of size time. Here at step there is only one
subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0.
That means that  and hence we're dealing with case 2 that results in O(logN) time complexity.

Space complexity : O(1) since it's a constant space solution.
* */

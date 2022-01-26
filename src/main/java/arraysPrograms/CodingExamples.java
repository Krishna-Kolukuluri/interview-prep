package arraysPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CodingExamples {
    static final int ASCII_SIZE = 256;
    public static void main(String args[]) {
        // Highest and Lowest numbers of array
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 6, 2, 3, 1, 9, 5));
        Collections.sort(numbers);
        System.out.println(numbers.get(0) + "  :  " + numbers.get(numbers.size() - 1));
        
        // Most Frequent Character
        String word = "This is to test highest characters";
        getMaxOccuringChar(word).forEach(c -> System.out.println(c));
        
        //Check if string is Palindrome
        System.out.println("Palindrome 12321 "+palindrome("12321"));
        
        //Fibonacci Sequence
        fibonacci(20);
        
        List<Integer> nums=example(5);
        nums.forEach(n->{System.out.println(n);});
        
        //Missing Number in Array
        System.out.println(missingNumber_opt());
        
        //Amazon Product weights
        arrays();
        product(new ArrayList<>(Arrays.asList(1,2,3,4)));
        product(new ArrayList<>(Arrays.asList(8,9,7,0)));
        
        minVal(new ArrayList<>(Arrays.asList(10,21,3,4)));
        
        firstNonRepeatingVal(new ArrayList<>(Arrays.asList(10,21,3,10,3,4)));
        
        System.out.println(simplifyPath("/ab/cd/./ef"));
        System.out.println(simplifyPath("/ab/cd/../ef"));
        System.out.println(simplifyPath("/ab/./cd/./ef"));
        System.out.println(simplifyPath("/ab/cd/../../ef"));
        
        secondMax(new ArrayList<>(Arrays.asList(10,21,3,4)));
        
        reArrange(new ArrayList<>(Arrays.asList(10,21,-2,4,3,-4)));
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        int n = arr.length;
        
        int[] intersect_nums=intersect(new int[]{ 1,2,3,4,5,6,7,8,9,10 },new int[]{ 1,8,4,5,6,7,8,4,7 });
        for(int i=0;i<intersect_nums.length;i++){
            System.out.print(intersect_nums[i]+" ");
        }
        
        longestPalindrome("fsdtabcdcbae");
        maxSubArray(new int[]{ 1,2,3,3,4,5,6,7,8,9,10 });
    }
    
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    
    public int[] intersect_hashmap(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    static List<String> getMaxOccuringChar(String str) {
        HashMap map = new HashMap<String, Integer>();
        String[] charArr;
        List<String> resultArr = new ArrayList<>();
        charArr = str.split(" ");
        for (String character : charArr) {
            char[] characters = character.toCharArray();
            for (char c : characters) {
                if (map.get(c) == null)
                    map.put(c, 1);
                else {
                    int n = (int) map.get(c);
                    map.put(c, n + 1);
                }
            }

        }
        int maxValueInMap = (int) (Collections.max(map.values()));
        map.forEach(
                (key, value) -> {
                    if ((int) value == maxValueInMap) {
                        resultArr.add(key.toString());
                    }
                });

        return resultArr;
    }
    //Rearrange Positive and Negative Values
    public static void reArrange(List<Integer> arr) {
        int[] newArray = new int[arr.size()];
        int newArray_index = 0;
        // Fill newArray with Negative Values first.
        // Then Fill it with Postive Values.
        // In the end, insert every element of newArray back into original arr.
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0)
                newArray[newArray_index++] = arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0)
                newArray[newArray_index++] = arr.get(i);
        }
        for (int j = 0; j < newArray.length; j++) {
            arr.add( newArray[j]);
            System.out.println(newArray[j]);
        }
    } // end of reArrange()
    
    //minimum value in array
    static int minVal(List<Integer> numbers){
        int min=numbers.get(0);
        for(int i=1;i<numbers.size();i++){
            if(numbers.get(i)<min){
                min=numbers.get(i);
            }
        }
        System.out.println(min);
        return min;
    }
    
    //secondmax
    static void secondMax(List<Integer> numbers){
        int max = numbers.get(0);
        int secondmax = numbers.get(0);
        for(int i=1;i<numbers.size();i++){
            if(numbers.get(i)>max){
                secondmax=max;
                max=numbers.get(i);
            }else if(numbers.get(i)>secondmax){
                secondmax=numbers.get(i);
            }
        }
        System.out.println(secondmax);
    }
    
    //First non repeating val
    static int firstNonRepeatingVal(List<Integer> numbers){
        int num=numbers.get(0);
        for(int i=1;i<numbers.size();i++){
           if(numbers.subList(i, numbers.size()-1).contains(num)){
               num=numbers.get(i);
           }
        }
        System.out.println(num);
        return num;
    }
    
    //Product of all elements except itself
    static List<Integer> product(List<Integer> numbers ){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<numbers.size();i++){
            int product = 1;
            for(int j=0;j<numbers.size();j++){
               if(i!=j){
                   product*=numbers.get(j);
               }
            }
            System.out.println(product);
            result.add(product);
        }
        return null;
    }
    
    static boolean palindrome(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    
    static String longestPalindrome(String str){
        int maxLength = 1, start = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
     
        StringBuilder sb= new StringBuilder();
        for (int i = start; i <= start + maxLength - 1; ++i)
            sb.append(str.charAt(i));
        System.out.print("Longest palindrome subString is: "+sb.toString());
     
        return sb.toString();
    }
    
    static void fibonacci(int num){
        int i=0,j=1;
        System.out.print(i+"  :  ");
        System.out.print(j);
        while(j<num){
            int k=i+j;
            System.out.print("  :  "+k);
            i=j;
            j=k;
        }
    }
    //Dell
    private static List<Integer> example(int target){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 6, 2, 3, 1, 9, 5));
        List<Integer> result=new ArrayList<>();
        int len=numbers.size();
        for(int i=0;i<numbers.size();i++){
            for(int j=numbers.size()-1;j>0;j--){
                if(numbers.get(i)+numbers.get(j)==target){
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }
    private static List<Integer> twonumberaddtotarget(int target){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 6, 2, 3, 1, 9, 5));
        List<Integer> result=new ArrayList<>();
        Collections.sort(numbers);   //Sort the array in Ascending Order
        int Pointer1 = 0;    //Pointer 1 -> At Start
        int Pointer2 = numbers.size() - 1;   //Pointer 2 -> At End
        int sum = 0;
        while (Pointer1 != Pointer2) {
            if(Pointer1>0 && Pointer2>0){
                sum = numbers.get(Pointer1) + numbers.get(Pointer2);  //Calulate Sum of Pointer 1 and 2
                if (sum < target) 
                  Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
                else if (sum > target) 
                  Pointer2--; 
                else {
                  result.add(numbers.get(Pointer1));
                  result.add(numbers.get(Pointer2));
                }
            }
        }
        return result;
    }
  //Find missing number Optimal Solution
    private static int missingNumber_opt(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 6, 2, 3, 1, 9, 7,5));
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        int n = numbers.size()+1;
        int actualsum = (n*(n+1))/2;
        return actualsum-sum;
    }
    //Amazon Product delivery weights program
    private static void arrays(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3,3,2,3));
        List<Integer> subarray = new ArrayList<>();
        int result=0;
        for(int i=0;i<=numbers.size();i++){
            System.out.println(i);
            int k=i;
            for(int j=0;j<=numbers.size();j++){
                System.out.println(k+"  :  "+j);
                if(k>j && k<=numbers.size()){
                    subarray = numbers.subList(j, k);
                    Collections.sort(subarray);
                    if(subarray.size()>1){
                         result += subarray.get(subarray.size()-1)-subarray.get(0);
                        
                     System.out.println(k+"  :  "+subarray.get(subarray.size()-1)+"  :  "+j+"  :  "+subarray.get(0)+"  :  "+result);  
                     k+=1;
                    }
                }
            }
        }
    }
    
    
    //Longest common sequence
    public static List<List<String>> longestCommonSequenceOfStrings(String[] str1, String[] str2){
        if(str1 == null || str2 == null){
            return new ArrayList<>();
        }
        if(str1.length == 0 || str2.length == 0){
            return new ArrayList<>();
        }
        int[][] numOfCommonCounts = new int[str1.length+1][str2.length+1];
        int maxSequence = 0;
        for(int fIdx=1;fIdx<=str1.length;fIdx++){
            for(int sIdx=1;sIdx<=str2.length;sIdx++){
                if(str1[fIdx-1].equals(str2[sIdx-1])){
                    numOfCommonCounts[fIdx][sIdx] = numOfCommonCounts[fIdx -1][sIdx - 1] + 1;
                    maxSequence = Math.max(maxSequence, numOfCommonCounts[fIdx][sIdx]);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(int fIdx=numOfCommonCounts.length-1;fIdx>=0;fIdx--){
            for(int sIdx=numOfCommonCounts[0].length -1;sIdx>=0;sIdx--){
                if(numOfCommonCounts[fIdx][sIdx] == maxSequence){
                    List<String> listOne = new ArrayList<>();
                    while (numOfCommonCounts[fIdx][sIdx] >=1 && fIdx>=0 && sIdx>=0){
                        listOne.add(str1[fIdx-1]);
                        numOfCommonCounts[fIdx][sIdx] = 0;
                        sIdx--;
                        fIdx--;
                    }
                    result.add(listOne);
                }
            }
        }
        return result;
    }
    
    //Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
    public int countElements(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (integerInArray(arr, x + 1)) {
                count++;
            }
        }
        return count;
    }

    public boolean integerInArray(int[] arr, int target) {
        for (int x : arr) {
            if (x == target) {
                return true;
            }
        }
        return false;
    }
    
    //max subarray
    public static int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        System.out.println();
        System.out.println(maxSubarray);
        return maxSubarray;
    }
    
    static String simplifyPath(String input){
        if(input.contains("/./")){
          input=input.replace("/./","/");
        }
        while(input.contains("/../")){
          input=input.replace("/../","1");
          char[] str = input.toCharArray();
          
          for(int i=0;i<str.length;i++){
            if(str[i] == '1'){
              if(i-1>0 && i-2>0){
                str[i]='1';str[i-1]='1';str[i-2]='1';
            }
          }
          }
          input ="";
          for(int i=0;i<str.length;i++){
            input=input+str[i];
          }
          input=input.replace("111","");
            
        }
        return input;   
      }
    
    //Spiral Matrix
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int rows = matrix.length;
            int columns = matrix[0].length;
            int up = 0;
            int left = 0;
            int right = columns - 1;
            int down = rows - 1;

            while (result.size() < rows * columns) {
                // Traverse from left to right.
                for (int col = left; col <= right; col++) {
                    result.add(matrix[up][col]);
                }
                // Traverse downwards.
                for (int row = up + 1; row <= down; row++) {
                    result.add(matrix[row][right]);
                }
                // Make sure we are now on a different row.
                if (up != down) {
                    // Traverse from right to left.
                    for (int col = right - 1; col >= left; col--) {
                        result.add(matrix[down][col]);
                    }
                }
                // Make sure we are now on a different column.
                if (left != right) {
                    // Traverse upwards.
                    for (int row = down - 1; row > up; row--) {
                        result.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                up++;
                down--;
            }

            return result;
        }
}

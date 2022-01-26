package amazon.arrayandstrings;

public class ContainerWithMostWater {
    public static void main(String args[]) {
        int[] nums={1,2,1};
        System.out.println(containerArea(nums));
    }
    
    static int containerArea(int[] numbers){
        int maxarea=0;
        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                maxarea = Math.max(maxarea, Math.min(numbers[i], numbers[j]) * (j - i));
        return maxarea;
    }
}

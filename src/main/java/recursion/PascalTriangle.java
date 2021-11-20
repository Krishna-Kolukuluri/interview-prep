package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
    public List<Integer> getRowRec(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        calc(rowIndex, res);
        return res;
    }
    private void calc(int rowIndex, List<Integer> res) {
        if (rowIndex == 0) {
            res.add(0, 1);
        } else {
            calc(rowIndex - 1, res);
            res.add(1);
            for (int i = rowIndex - 1; i > 0; i--) {
                res.set(i, res.get(i) + res.get(i - 1));
            }
        }
    }
}

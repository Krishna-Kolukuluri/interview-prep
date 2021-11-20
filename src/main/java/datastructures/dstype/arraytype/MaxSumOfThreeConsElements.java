package datastructures.dstype.arraytype;

public class MaxSumOfThreeConsElements {
    public static void main(String[] args) {

    }
    //Elements are positive numbers
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = A[i] + preSum[i];
        }
        int lMax = preSum[L], mMax = preSum[M];
        int res = preSum[L + M];
        for (int i = L + M; i <= n; i++) {
            //case 1: L subarray is always before M subarray
            lMax = Math.max(lMax, preSum[i - M] - preSum[i - M - L]);
            //case 2: M subarray is always before L subarray
            mMax = Math.max(mMax, preSum[i - L] - preSum[i - M - L]);
            //compare two cases and update res
            res = Math.max(res, Math.max(lMax + preSum[i] - preSum[i - M], mMax + preSum[i] - preSum[i - L]));
        }
        return res;
    }

}

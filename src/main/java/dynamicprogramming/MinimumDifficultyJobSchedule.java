package dynamicprogramming;
/*
*
You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all
* the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day
* of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.

Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
*
* */
public class MinimumDifficultyJobSchedule {
    public static void main(String[] args) {
        JobSchedule jobSchedule = new JobSchedule();
        int[] jobs = new int[]{6,5,4,3,2,1};
        int days = 2;
        int result = jobSchedule.minDifficulty(jobs, days);
        System.out.println(result);

    }
}
class JobSchedule{
    private int n, d;
    private int[][] memo;
    private int[] jobDifficulty;
    private int[] hardestJobRemaining;

    private int dp(int i, int day) {
        // Base case, it's the last day so we need to finish all the jobs
        if (day == d) {
            return hardestJobRemaining[i];
        }

        if (memo[i][day] == 0) {
            int best = Integer.MAX_VALUE;
            int hardest = 0;
            // Iterate through the options and choose the best
            for (int j = i; j < n - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                // Recurrence relation
                best = Math.min(best, hardest + dp(j + 1, day + 1));
            }
            memo[i][day] = best;
        }

        return memo[i][day];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        // If we cannot schedule at least one job per day,
        // it is impossible to create a schedule
        if (n < d) {
            return -1;
        }

        hardestJobRemaining = new int[n];
        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }

        this.d = d;
        this.jobDifficulty = jobDifficulty;
        memo = new int[n][d + 1];
        return dp(0, 1);
    }
}
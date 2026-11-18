import java.util.Arrays;

public class MaximumGap {

    public static int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int maxGap = 0;

        for (int i = 1; i < nums.length; i++) {

            int difference = nums[i] - nums[i - 1];

            if (difference > maxGap) {
                maxGap = difference;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {

        int[] nums = {3, 6, 9, 1};

        System.out.println(
            "Maximum gap: " + maximumGap(nums)
        );
    }
}
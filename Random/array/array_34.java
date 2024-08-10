public class array_34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        for(int i=0; nums[i] <= target; i++) {
            if(nums[i] == target) {
                if(result[0] == -1) {
                    result[0] = i;
                    result[1] = i;
                }
                else
                    result[1] = i;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.print(result[0] + " " + result[1]);
    }
}

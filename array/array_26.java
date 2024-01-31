public class array_26 {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[count] != nums[i])
                nums[++count] = nums[i];
        }
        return count+1;
    }
    public static void main(String[] args) {
        int[] a = {1,1,2};
        System.out.println(removeDuplicates(a));
    }
}

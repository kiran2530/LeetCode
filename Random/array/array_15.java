import java.util.ArrayList;
import java.util.Arrays;

public class array_15 {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if(!list.contains(temp))
                            list.add(temp);
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
}

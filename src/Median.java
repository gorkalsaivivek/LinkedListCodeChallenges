package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Median {
    public static int distinctAverages(int[] nums) {
        Set<Double> set=new HashSet<>();
        Arrays.sort(nums);
        int start=0, end=nums.length-1;
        while(start<end){
            double aver=((double)nums[start]+ (double)nums[end])/2;
            start++;
            end--;
            set.add(aver);
        }
        return set.size();
    }

    public static void main(String[] args) {
        distinctAverages(new int[] {4,1,4,0,3,5});
    }
}



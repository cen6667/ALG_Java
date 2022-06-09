package demo.LT_81;

public class Solution {
    public static boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target?true:false;
        int n = nums.length;
        int l =0, r = nums.length-1, mid;
        while(l<=r){
            mid = (l+r)>>1;
            if(nums[mid] == target) return true;
            // 先确定哪边是有序数列
            if(nums[0] == nums[mid] && mid != 0){
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                } else{
                    r = mid - 1;
                }

            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;
        if(nums[r] > nums[l]) return nums[0];
        //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
        //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
        while (l < r) {
            int mid = (l + r) / 2;

            if(nums[r] == nums[mid] && nums[l] == nums[mid]){
                r -= 1;
            }else if (nums[r] <= nums[mid]) {
                // 如果mid在左半段
                l = mid+1;
            } else {
                // mid在右半段
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,1,3,3,3,3};
        int k = 0;
//        System.out.println(search(nums,k));
        System.out.println(findMin(nums));

    }
}

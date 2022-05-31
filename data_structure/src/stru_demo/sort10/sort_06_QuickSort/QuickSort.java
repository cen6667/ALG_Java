package stru_demo.sort10.sort_06_QuickSort;


import java.util.Random;

public class QuickSort {

    public void quickSort(int[] nums, int left,int right){
        if(left>=right) return;
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex-1);
        quickSort(nums, pivotIndex+1,right);
        return;
    }
    // 随机种子为当时时间戳
    private final static Random random = new Random(System.currentTimeMillis());

    private int partition(int[] nums, int left,int right){
        int randomIndex = left + random.nextInt(right-left+1);
        swap(nums,left,randomIndex);
        int pivot = nums[left];
        //循环不变量（定义不变），初始化保证区间为空
        // <= pivot [left,j]
        // > pivot (j,right]
        int j = left;
        for(int i = left+1; i<=right;i++){
            if(nums[i] <= pivot){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {20, 38, 36, 21, 23, 22, 13};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}

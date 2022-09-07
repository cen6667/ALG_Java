package stru_demo.sort10.sort_07_HeapSort;

import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }

        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从最后一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构,交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            swap(arr, 0, j);
            //重新对堆进行调整
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整大顶堆
     */
//    public static void adjustHeap(int[] arr, int i, int length) {
//        // 从左节点开始2*i+1，如果交换则继续向下比较
//        int left = 2*i+1, right = left+1;
//        int k = left;
//        if(length-1 >= right && arr[left] < arr[right]) k =right;
//        if(length > k && arr[k] > arr[i]){
//            swap(arr, k, i);
//            adjustHeap(arr, k, length);
//        }
//    }
    public static void adjustHeap(int[] arr, int i, int length) {
        if (arr == null || arr.length == 0){
            return;
        }

        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    /**
     * 交换元素
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findKthLargest(arr,2));
    }

    public static int findKthLargest(int[] nums, int k) {

        // 构建大顶堆，从最后一个非叶子节点开始
        for(int i = nums.length/2-1; i>=0; i--){
            adjustHeap(nums, i, nums.length);
        }
        // 将根与最后一个节点交换
        for(int j = nums.length-1; j>=nums.length-k; j--){
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
        return nums[nums.length-k];
    }
}


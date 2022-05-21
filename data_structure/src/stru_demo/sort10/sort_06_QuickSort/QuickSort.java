package stru_demo.sort10.sort_06_QuickSort;


public class QuickSort {

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 迭代对基准前和基准后的数组进行相同操作
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准元素
        int tmp = arr[low];
        // low指向队首元素，high指向队尾元素，首尾一起扫描
        while (low < high) {
            // 当队尾元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 队尾元素小于tmp,则将其赋值给low
            arr[low] = arr[high];

            // 队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 队首元素大于tmp时,则将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        arr[low] = tmp;
        // 返回tmp的正确位置
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {20, 38, 36, 21, 23, 22, 13};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}

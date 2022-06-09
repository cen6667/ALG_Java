package stru_demo.sort10.sort_05_MergeSort;

public class MergeSort {
    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 递归
            sort(a, low, mid);
            sort(a, mid + 1, high);
            // 合并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        if (a == null || a.length == 0) {
            return;
        }

        // 临时数组用来记录每次迭代排序后的数组
        int[] temp = new int[high - low + 1];
        // 临时数组中的索引
        int k = 0;
        // 从中间值开始比较前后两个数组
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 当中间值后的数组全部存入到临时数组中，则直接将前半部分的数据存入到临时数组中
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        // 当中间值前的数组全部存入到临时数组中，则直接将后半部分的数据存入到临时数组中
        while (j <= high) {
            temp[k++] = a[j++];
        }

        // 将临时数组中的数据替换到源数组对应索引的位置
        for (int l = 0; l < temp.length; l++) {
            a[low + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 9, 4, 1};
        int[] sort = sort(arr, 0, 6);
        for (int i : sort) {
            System.out.print(i + " ");
        }

    }
}

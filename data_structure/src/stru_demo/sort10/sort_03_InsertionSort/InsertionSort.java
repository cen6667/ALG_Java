package stru_demo.sort10.sort_03_InsertionSort;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        for (int i = 1; i < arr.length; i++) {
            // 取出要插入排序的元素
            int current = arr[i];
            // 记录此元素的索引
            int index = i;

            for (int j = i - 1; j >= 0; j--) {
                // 如果比较的元素大于要插入的元素，则将比较的元素向后移动一位
                if (current < arr[j]) {
                    arr[j + 1] = arr[j];
                    // 记录插入元素要放置的位置
                    index = j;
                } else {
                    // 已排序列是有序的，故当从后向前比较时遇到第一个小于等于待插入元素时即可跳出循环比较
                    break;
                }
            }

            // 将要插入排序的元素放到对应的位置
            if (index != i) {
                arr[index] = current;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 8, 1, 0};
        int[] ints = insertionSort(arr);
        for (int param : ints) {
            System.out.println(param);
        }
    }
}


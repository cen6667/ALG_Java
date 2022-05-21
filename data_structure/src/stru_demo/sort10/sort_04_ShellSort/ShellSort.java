package stru_demo.sort10.sort_04_ShellSort;

public class ShellSort {
    public static int[] shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        // gap为增量序列，依次以gap为增量进行分组
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            // 每一分组按照直接插入法进行排序
            for (int i = gap; i < array.length; i++) {
                // current记录当前要进行比较的元素
                int current = array[i];
                // j记录当前要进行比较的元素同一分组中的前一个元素
                int j = i - gap;

                // 前一个元素大于要进行比较的元素，则前面一个元素在同一分组中向后移一位，对于整个序列来说需要后移gap个位置
                while (j >= 0 && array[j] > current) {
                    array[j + gap] = array[j];
                    // 继续向前找组内元素进行比较
                    j -= gap;
                }

                // 当向前找gap个位置发现不满足while条件时，则j+gap即为当前元素要插入的位置
                array[j + gap] = current;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {8, 9, 1, 3, 7, 6, 5, 2, 4, 0, 2};
        int[] ints = shellSort(array);
        for (int param : ints) {
            System.out.println(param);
        }
    }
}

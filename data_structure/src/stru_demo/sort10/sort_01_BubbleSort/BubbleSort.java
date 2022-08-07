package stru_demo.sort10.sort_01_BubbleSort;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        // 计算循环次数
        int step = 0;

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                /*
                 j比较的次数为数组长度减去i的原因是：
                 每遍历一次后总会确定此次遍历中的最大的数并放在数组尾部，
                 故j每次只需遍历这些已确定数据前面的一部分数据
                 */
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
                step++;
            }
            if(flag) break;
        }
        System.out.println("循环次数"+step);
        return array;
    }

    public static void main(String[] args){
        int[] array = {5,7,9,1,2,3};
//        int[] array = {1,2,3,4,5,6};
        int[] sort = bubbleSort(array);
        for (int value : sort) {
            System.out.println(value);
        }
    }

}


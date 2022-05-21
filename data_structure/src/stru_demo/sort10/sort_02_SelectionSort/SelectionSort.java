package stru_demo.sort10.sort_02_SelectionSort;

public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        for(int i=0; i<arr.length; i++){
            int maxIndex = i;
            for(int j = i+1; j<arr.length; j++){
                // 该循环的目的在于找到最大元素(也可以找最小元素)所在位置，记录其索引值
                if (arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            // 将找到的目标元素替换到已排序列末尾
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void main(String[] args){
        int[] arr = {7,2,0,8,5,1};
        int[] sort = selectionSort(arr);
        for(int ele : sort){
            System.out.println(ele);
        }
    }

}

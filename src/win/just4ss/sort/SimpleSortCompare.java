package win.just4ss.sort;

import java.util.Arrays;

public class SimpleSortCompare {

    /**
     * 冒泡排序
     * @param a int数组
     */
    public static void bubbleSort(int[] a) {
        int len = a.length;
        for(int i = 0; i < len; i++) {
            // 大的放在后面
            // 每一轮最后都排完一个
            boolean flag = false;
            for(int j = 0; j < len - i -1; j++) {
                if(a[j] > a[j+1]) {
                    swap(a,j+1,j);
                }
                flag = true;
            }
            if(!flag) return;
        }
    }


    /**
     * 插入排序
     * @param a int数组
     */
    public static void insertSort(int[] a ) {
        // 4 5 6 3 2 1
        // 4 5 6 3 2 1
        // 4 5 6 3 2 1
        // 4 5 3 6 2 1
        // 4 3 5 6 2 1
        // 3 4 5 6 2 1
        int len = a.length;
        for(int i = 1; i < len; i++) {
            int curr = a[i];
            int j = i - 1;
            while(j >= 0) {
                if(a[j] > curr) {
                    //大的往后移动
                    a[j+1] = a[j];
                }else {
                    break;
                }
                j--;
            }
            a[j+1] = curr;

        }

    }


    /**
     * 选择排序
     * @param a int数组
     */
    public static void selectSort(int[] a) {
        // 4 5 6 4 2 1
        // 最大的放在最前面
        int len = a.length;
        for(int i = 0; i < len; i++) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if(a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            // 找到最大的角标，交换
            swap(a,index,i);
        }
    }

    /**
     * 元素交换
     * @param a int数组
     * @param i 角标
     * @param j 角标
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 归并排序
     * @param a int数组
     */
    private static void mergeSort(int[] a) {
        // 和快排一样，利用分治的思想，将数组一次一次的对半分，分到不能分为止
        // 通过merge函数将2个数组合并
        // 4 5 6 1 3 2
        //r1 = sort(4,5,6);
        //r2 = sort(1,3,2);
        //merge(r1,r2);
        //递归
        int[] temp = new int[a.length];
        mergeSort(a,0,a.length-1,temp);



    }

    /**
     * 归并排序
     * @param a int数组
     * @param start 起点
     * @param end 终点
     * @param temp 临时数组
     */
    private static void mergeSort(int[] a, int start, int end, int[] temp) {
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(a,start,mid,temp);
        mergeSort(a,mid+1,end,temp);
        merge(a,start,mid,end,temp);
    }

    private static void merge(int[] a, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int t = 0;
        while (i<=mid && j<=end){
            if(a[i] > a[j]) {
                temp[t++] = a[j++];
            }else {
                temp[t++] = a[i++];
            }
        }

        while(i <= mid) {
            temp[t++] = a[i++];
        }
        while(j <= end) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (start<=end) {
            a[start++] = temp[t++];
        }
    }


    /**
     * 快排
     * @param a int数组
     */
    private static void quickSort(int[] a) {
        // 还是分治
        // 4 5 6 1 3 2
        // 取出最后一个点比他小的都放他左边，比他大的都放他右边
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int start, int end) {
        if(start<end) {
            int partitionIndex = partition(a,start,end);
            quickSort(a,start,partitionIndex -1);
            quickSort(a,partitionIndex + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int partionNum = a[end];
        int i = start;
        int j = start;
        while(j<=end) {
            if(a[j] < partionNum) {
                swap(a,i++,j);
            }
            j++;
            if(j==end) {swap(a,i,end);}
        }

        return i;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,1};
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
//        bubbleSort(a);
//        selectSort(a);
//        insertSort(a);
//        mergeSort(a);
        quickSort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Spend time:" + (endTime-startTime));
        System.out.println(Arrays.toString(a));

    }

}

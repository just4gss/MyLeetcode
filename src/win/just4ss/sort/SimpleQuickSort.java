package win.just4ss.sort;

import java.util.Arrays;

public class SimpleQuickSort {
    // 4 5 6 1 3 2
    // 2 左右分界线
    //2是ok的，再排左右两边的
    public static void quickSort(int[] a) {
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int start, int end) {
        if(start<end) {
            int partitionIndex = partition(a,start,end);
            quickSort(a,start,partitionIndex-1);
            quickSort(a,partitionIndex+1,end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int compareNum = a[end];
        int i = start;
        int j = start;
        while(j<end) {
            if(a[j]< compareNum) {
                swap(a,i,j);
                i++;
            }
            j++;
        }
        if(j==end) {
            swap(a,i,end);
        }
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = {4,5,6,1,3,11,9,7,2};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

}

package win.just4ss.sort;

import java.util.Arrays;

public class SimpleMergeSort {
    // 分治
    // 4 5 6 1 3 2
    //r1=sort(4,5,6)
    //r2=sort(1,3,2)
    //merge(r1,r2)
    //递归终结条件，start>=end
    public static void mergeSort(int[] a) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int [] temp = new int[a.length];
        mergeSort(a,0,a.length-1,temp);
    }

    private static void mergeSort(int[] a, int start, int end, int[] temp) {
        if(start>=end) return;
        int mid = (end + start) / 2;
        //左序列排序
        mergeSort(a,start,mid,temp);
        //右序列排序
        mergeSort(a,mid+1,end,temp);
        merge(a,start,mid,end,temp);
    }

    private static void merge(int[] a, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int t = 0;
        while(i<=mid && j<=end) {
            if(a[i] > a[j]) {
                temp[t++] = a[j++];
            }else {
                temp[t++] = a[i++];
            }
        }
        //剩下的补进去
        while(i<=mid) {
            temp[t++] = a[i++];
        }
        while(j<=end) {
            temp[t++] = a[j++];
        }
        //把temp里面的放回原数组
        t = 0;
        while(start<=end) {
            a[start++] = temp[t++];
        }
    }


    public static void main(String[] args) {
        int[] a = {4,5,6,1,3,11,9,7,2};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

}

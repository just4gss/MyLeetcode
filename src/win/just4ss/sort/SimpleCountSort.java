package win.just4ss.sort;

import java.util.Arrays;

public class SimpleCountSort {

    //2，5，3，0，2，3，0，3

    public static void countSort(int[] a) {
        int len = a.length;
        if(len <= 1) return;
        int max = a[0];
        for(int i=1; i < len; i++) {
            if(max <a[i]) max = a[i];
        }
        int c[] = new int[max + 1];
        // 计算每个元素有多少个
        for(int i = 0; i < len; i++) {
            c[a[i]]++;
        }
        // 累加
        for(int i=1; i<=max; i++) {
            c[i] = c[i-1] + c[i];
        }
        // 原数组从后往前遍历
        int res[] = new int[len];
        for(int i=len-1; i>=0;i--) {
            //c中减一，值作为结果的角标，
//            int index = c[a[i]]-1;
//            res[index] = a[i];
//            c[a[i]]--;
            res[--c[a[i]]] = a[i];
        }
//        a = Arrays.copyOf(res,len);
        for(int i=0; i<len; i++) {
            a[i] = res[i];
        }
    }


    public static void main(String[] args) {
//        int[] a = {4,5,6,3,2,1};
        int[] a = {2,5,3,0,2,3,0,3,4};
        countSort(a);
        System.out.println(Arrays.toString(a));
    }

}

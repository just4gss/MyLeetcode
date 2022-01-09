package win.just4ss.sort;

public class SimpleSelectSort {
    public static void selectSort(int[] a) {
        //遍历找到最小的，和最前面的交换，再重复
        int length = a.length;
        for(int i = 0; i < length; i++) {
            int min = a[i];
            int index = i;
            for(int j = i+1; j < length; j++) {
                if(a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }

    }

    public static void main(String[] args) {
        int[] a = {4,5,6,1,3,2};
        selectSort(a);
        for(int i: a) {
            System.out.println(i);
        }
    }

}

package win.just4ss.sort;

public class SimpleBubbleSort {

    //简单冒泡排序
    //4 5 6 3 2 1
    //4 5 3 2 1 6
    public static void bubbleSort(int[] a) {
        int length = a.length;
        for(int i=0; i<length; i++) {
            for(int j=0; j<length-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,1};
        bubbleSort(a);
        for(int i: a) {
            System.out.println(i);
        }
    }

}

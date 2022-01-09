package win.just4ss.sort;

public class SimpleInsertSort {

    //4 5 6 1 3 2
    //4 5 6 1 3 2
    //1 4 5 6 3 2
    //1 3 4 5 6 2
    //1 2 3 4 5 6
    public static void insertSort(int[] a) {
        //左边的都是比好的，以此和左边的比，直到找到比他小的
        int length = a.length;
        for(int i = 1; i < length; i++) {
            int curr = a[i];
            int j = i - 1 ;
            while(j >= 0) {
                if(a[j] > curr) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
                j--;
            }
            a[j+1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,1,3,2};
        insertSort(a);
        for(int i: a) {
            System.out.println(i);
        }
    }

}

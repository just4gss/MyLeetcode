package win.just4ss.binarysearch;

public class SimpleBinarySearch {


    /**
     * 简单二分查找
     * @param a 源数组(有序的)
     * @param value 要找的数
     * @return 要查找的角标
     */
    public static int binarySearch(int[] a, int value) {
        int low  = 0;
        int high = a.length - 1;
        while(low <= high) {
//            int mid = (low + high) / 2;
            int mid = low + ((high - low) >>1);
            if(a[mid] == value) {
                return mid;
            }else if(a[mid] > value) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式二分查找
     * @param a 有序数组
     * @param value 查找值
     * @return  对应在a中序列
     */
    public static int bSearch(int[] a, int value) {
       return bSearch(a,value,0,a.length - 1);
    }

    private static int bSearch(int[] a,int value, int low, int high) {
        if(low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if(a[mid] == value) {
            return mid;
        }else if(a[mid] > value) {
            return bSearch(a, value, low, mid - 1);
        }else {
            return bSearch(a, value, mid + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,5,7,8,9,11,22};
//        System.out.println(binarySearch(a,5));
        System.out.println(bSearch(a,5));
    }
}

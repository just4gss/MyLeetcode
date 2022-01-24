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

    //

    /*
     *  四种二分法的变体
     *  一个有序数组（可能有重复）
     *  1.查找第一个给定值的元素
     *  2.查找最后一个给定值的元素
     *  3.查找第一个大于等于给定值的元素
     *  4.查找最后一个小宇等于给定值的元素
     */
    //1 2 2 3 4 5 5 6 7 7 7 7 7 7 7 8
    //l             m                h
    //              l        m       h

    public static int searchFirstIndex(int[] a,int value) {
        int low = 0;
        int high = a.length - 1;

        // 先找到一个对应的
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value) {
                high = mid - 1;
            }else if(a[mid] < value) {
                low = mid + 1;
            }else {
                //相等
                //前一个不是要找的值，就是第一个给定的值，否则high继续缩小
                if(mid == 0 || a[mid - 1] != value) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int searchLastIndex(int[] a,int value) {
        int low = 0;
        int high = a.length - 1;

        // 先找到一个对应的
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value) {
                high = mid - 1;
            }else if(a[mid] < value) {
                low = mid + 1;
            }else {
                //相等
                //下一不是要找的值，就是最后一个给定的值，否则low继续涨
                if(mid == 0 || a[mid + 1] != value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     * @param a 有序数组
     * @param value 要找的值
     * @return 角标
     */
    public static int searchFirstNotSmallerIndex(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] >= value) {
                if(mid == 0 || a[mid -1] < value) return mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }





    /**
     *查找最后一个小宇等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int searchLastNotLagerIndex(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value) {
                high = mid - 1;
            }else {
                if(mid == a.length -1  || a[mid + 1] > value) return  mid ;
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,5,7,8,9,11,22};
        int[] b = {1,2,2,3,4,5,5,6,7,7,7,7,7,7,7,8};
        System.out.println(binarySearch(a,5));
        System.out.println(bSearch(a,5));
        System.out.println(searchFirstIndex(b,7));
        System.out.println(searchLastIndex(b,7));
        System.out.println(searchFirstNotSmallerIndex(b,3));
        System.out.println(searchLastNotLagerIndex(b,7));
    }
}

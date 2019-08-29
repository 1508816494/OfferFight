package offer;

public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        //在区间[l, r]内查找target
        //时刻维护l和r的含义
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
//            int mid = (l + r)/2;
            int mid = l + (r - l)/2;

            if(arr[mid] == target) {
                return mid;
            }
            if(target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 24, 45, 89};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr, 89));
    }
}

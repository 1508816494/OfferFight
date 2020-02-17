package offerSpring;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSorted {

    /**
     * 归并方式
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //采用归并排序法

        List<Integer> list = new ArrayList<>();

        //存储nums1,nums2的索引
        int i, j;

        for(i = 0, j = 0; i < m && j < n;) {
            if(nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }

        //考虑跳出循环后存在未排完的数据
        if(i < m) {
            for(int k = i; k < m; k++) {
                list.add(nums1[k]);
            }
        }

        if(j < n) {
            for(int k = j; k < n; k++) {
                list.add(nums2[k]);
            }
        }

        for(int t = 0; t < list.size(); t++) {
            nums1[t] = list.get(t);
        }

    }

    /**
     * 合并后排序
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0 , nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     *双指针（由后往前）
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2>= 0) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--]: nums1[p1--];
        }

        //将nums2中多余的数据加入
        System.arraycopy(nums2, 0 , nums1, 0, p2 + 1);
    }
}

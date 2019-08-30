package leetcode;

import java.util.HashMap;
import java.util.Map;

//外部一重循环，内部两重循环（一重建查找表，另一重设res
public class NumberOfBoomerangs447 {
    private int res = 0;
    public int numberOfBoomerangs(int[][] points) {

        //以每个点为中心点建立到该点距离的查找表：key为距离，value为该距离的点数
        for(int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < points.length; j++) {
                if( j != i) {
                    int key = distance(points[i], points[j]);
                    if(!map.containsKey(key)) {
                        map.put(key, 1);
                    } else {
                        int val = map.get(key);
                        val++;
                        map.put(key, val);
                    }
                }
            }

            map.forEach((key, value) -> {
                if(value > 1) {
                    this.res = this.res + value * (value - 1);
                }
            });
        }
        return this.res;
    }

    private int distance(int[] a, int[] b) {
        return (a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]);
    }

    public static void main(String[] args) {
        NumberOfBoomerangs447 nb = new NumberOfBoomerangs447();
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(nb.numberOfBoomerangs(points));
    }
}

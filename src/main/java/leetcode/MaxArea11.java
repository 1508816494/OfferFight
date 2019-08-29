package leetcode;

public class MaxArea11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            if(height[l] <= height[r]) {
                if(height[l]*(r - l) > maxArea) {
                    maxArea = height[l]*(r - l);
                }
                l++;
            }
            if(height[l] > height[r]) {
                if(height[r]*(r - l) > maxArea) {
                    maxArea = height[r]*(r - l);
                }
                r--;
            }
        }
        return maxArea;
    }
}

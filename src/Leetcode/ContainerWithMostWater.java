package Leetcode;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] height = {1,8,6,2,5,4,8,3,7};
    System.out.println(maxArea(height));
  }
  public static int maxArea(int[] height) {
    int left = 0, right = height.length-1, maxArea=0;

    while(left != right) {
      if (height[left] > height[right]) {
        if (((right-left)*height[right]) > maxArea) {
          maxArea = ((right-left)*height[right]);
        }
        right--;
      }else if (height[right] > height[left]) {
        if (((right-left)*height[left]) > maxArea) {
          maxArea = ((right-left)*height[left]);
        }
        left++;
      }else {
        if (((right-left)*height[left]) > maxArea) {
          maxArea = ((right-left)*height[left]);
        }
        left++;
      }
    }
    return maxArea;
  }
}

package recursion;

import java.util.Arrays;

public class Array {
  public static boolean exists(int[] arr, int val) {
    if (arr[0] == val || arr[arr.length - 1] == val) return true;
    if (arr.length <= 2) return false;
    return exists(Arrays.copyOfRange(arr, 1, arr.length - 1), val);
  }
  
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 5, 6, 7, 7, 8, 9};
    System.out.println(exists(arr, 5));
    System.out.println(exists(arr, 4));
  }
}

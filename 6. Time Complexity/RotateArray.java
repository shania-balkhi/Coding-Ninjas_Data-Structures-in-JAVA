public class Solution {
    public static void rotate(int[] arr, int d) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            temp[i] = arr[i];
         }
        int j = 0;
        for (int i = d; i < arr.length; ++i) {
            arr[j] = arr[i];
            ++j;
        }
        for (int i = 0; i <= d - 1; ++i) {
            arr[j] = temp[i];
            ++j;
        }
    }
}

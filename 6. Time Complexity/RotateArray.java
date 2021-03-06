//1st approach (optimized)
//Space Complexity : O(1)
//Time Complexity : O(N)
public class Solution {  
    public static void rotate(int[] arr, int d) {
        if(d > arr.length){
            d = d % arr.length;
        }else if(d < 0){ //if d is negative
            d = arr.length + d;
        }
        
    	reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int si, int ei){  //si = startIndex, ei = endIndex
        while(si < ei){
            swap(arr, si, ei);
            
            ++si;
            --ei;
        }
    }
    
    private static void swap(int[] arr, int si, int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }
    
}


/****************************************************************************************************************************************************************************/
/****************************************************************************************************************************************************************************/


//2nd approach 
//Space Complexity : O(N)
//Time Complexity : O(N)
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

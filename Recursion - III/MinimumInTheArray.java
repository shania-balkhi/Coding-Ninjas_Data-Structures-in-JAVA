class Solution{
    public static void printMinimumInTheArray(int[] arr, int si, int minSoFar){
        //base case
        if (si == arr.length){ //the case where array is empty
            System.out.println(minSoFar); //minSoFar is +ve infinity in case of empty array
            return;
        }

        int newMin = minSoFar; //newMin is the variable that stores the element which is smaller amongst arr[0] (or, arr[si]) and minSoFar (returned by recursion). so initially, newMin is initailised with minSoFar only so that in case !(arr[0] < minSoFar), newMin remains same as minSoFar.
        if(arr[si] < minSoFar){
            newMin = arr[si];
        }

        printMinimumInTheArray(arr, si + 1, newMin);
    }
}

public class PrintMinimumInTheArray {
    public static void main(String[] args) {
        int[] arr = {2,4,3,4,5,23,1,34,23,24,4,-457};
        Solution.printMinimumInTheArray(arr, 0, Integer.MAX_VALUE);
    }
}

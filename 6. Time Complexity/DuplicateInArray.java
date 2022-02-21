class Solution {
	public static int findDuplicate(int[] arr) {
        int sumOfAllElements = 0;
        for (int i = 0; i < arr.length; ++i){
            sumOfAllElements += arr[i];
        }

        int lengthOfEntireArray = arr.length;
        int sumUptoNMinusTwoNaturalNum = ((lengthOfEntireArray - 2) * (lengthOfEntireArray - 1))/2;
        return sumOfAllElements - sumUptoNMinusTwoNaturalNum;
	}
}

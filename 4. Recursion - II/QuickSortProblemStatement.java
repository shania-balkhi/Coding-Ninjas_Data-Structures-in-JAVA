class Solution{
    public static void quickSort(int[] input, int startIndex, int endIndex){
        //base case
        if (startIndex >= endIndex)
            return;

        int pivotIndex = partition(input, startIndex, endIndex);
        quickSort(input, startIndex, (pivotIndex - 1));
        quickSort(input, (pivotIndex + 1), endIndex);
    }

    public static int partition (int[] input, int startIndex, int endIndex){
        int pivotElement = input[startIndex]; 
        int smallerNumCount = 0;
        for (int i = startIndex + 1; i <= endIndex; ++i){
            if (input[i] < pivotElement)
                smallerNumCount++;
        }
        int pivotIndex = startIndex + smallerNumCount;

        int temp = input[pivotIndex];
        input[pivotIndex] = pivotElement;
        input[startIndex] = temp;

        int i = startIndex, j = endIndex;

        while(i < j){
            if (input[i] < pivotElement)
                ++i;
            else if (input[j] >= pivotElement)
                --j;
            else {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                ++i;
                --j;
            }
        }
        return pivotIndex;
    }
}

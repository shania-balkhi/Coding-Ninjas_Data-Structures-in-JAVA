class Solution{
    public static int arrayEquilibriumIndex(int[] arr){
        int i = 0;
        int LSum = 0, RSum = 0, TSum = 0; //L == left, R == right, T == total

        while(i < arr.length){
            TSum += arr[i];
            ++i;
        }
        
		i = 0;
        while(i < arr.length){
            RSum = TSum - LSum - arr[i];

            if (LSum == RSum)
                return i;

            LSum += arr[i];
            ++i;
        }

        return -1;

    }
}

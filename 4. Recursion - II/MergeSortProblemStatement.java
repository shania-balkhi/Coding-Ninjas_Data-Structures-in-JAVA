class solution{
    public static void mergeSort(int[] input){

        if (input.length <= 1)
            return;

        int[] arr1 = new int[(input.length)/2];
        int[] arr2 = new int[(input.length) - (arr1.length)];

        for(int i =0; i < (input.length)/2; ++i)
            arr1[i] = input[i];

        for(int i = (input.length)/2; i < input.length; ++i)
            arr2[i - (input.length)/2] = input[i];

        mergeSort(arr1);
        mergeSort(arr2);
        merge(arr1, arr2, input);
    }

    public static void merge(int[] sourceArray1, int[] sourceArray2, int[] destinationArray){
        int i = 0, j = 0, k = 0;
        while(i < sourceArray1.length && j < sourceArray2.length){
            if (sourceArray1[i] <= sourceArray2[j]){
                destinationArray[k] = sourceArray1[i];
                ++i;
                ++k;
            }
            else{
                destinationArray[k] = sourceArray2[j];
                ++j;
                ++k;
            }
        }

        if (i < sourceArray1.length){
            while(i < sourceArray1.length){
                 destinationArray[k] = sourceArray1[i];
                ++i;
                ++k;
            }
        }

        if (j < sourceArray2.length){
            while(j < sourceArray2.length){
                 destinationArray[k] = sourceArray2[j];
                ++j;
                ++k;
            }
        }

    }

}

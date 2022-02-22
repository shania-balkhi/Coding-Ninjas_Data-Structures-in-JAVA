import java.util.Arrays;

class Solution {	

	public static int pairSum(int[] arr, int num) {
		Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int count = 0, count_i = 1, count_j = 1;
        while(i < j){
            if(arr[i] + arr[j] == num){
                if(arr[i]==arr[j]){
                    count += ((j-i)*(j+1-i))/2;
                    return count;
                }
                else{
                    for(int k = i + 1; k < j; ++k){
                        if(arr[i] == arr[k]){
                            count_i++;
                            i=k;
                        }
                    }
                    for(int k = j-1; k > i; k--){
                        if(arr[j] == arr[k]){
                            count_j++;
                            j=k;
                        }
                    }
                    count += count_i * count_j;
                    count_i =1;
                    count_j=1;
                }
                i++;
                j--;
            }

            else if(arr[i] + arr[j] > num){
                --j;
            }

            else{
                ++i;
            }
        }
        return count;
	}
}

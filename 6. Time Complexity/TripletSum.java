import java.util.Arrays;
public class Solution {	
	public static int tripletSum(int[] arr, int num) {
		Arrays.sort(arr);
        int numOfPairsOfTargetSum = 0;   
        int numOfTripletsOfActualSum = 0;
        for(int k = 0; k < arr.length - 2; ++k){
            int targetSum = num - arr[k];
            numOfPairsOfTargetSum = numOfPairsOfTargetSum(arr, k + 1,arr.length - 1, targetSum); 
            numOfTripletsOfActualSum += numOfPairsOfTargetSum;
        }
        return numOfTripletsOfActualSum;
	}
    private static int numOfPairsOfTargetSum(int[] arr, int si, int ei, int targetSum){ //si = startIndex, ei = endIndex
        int numOfPairsOfTargetSum = 0;
        while(si < ei){ 
            if (arr[si] + arr[ei] < targetSum){
                ++si;
            }else if(arr[si] + arr[ei] > targetSum){
                --ei;
            }else{
                /* for edge cases like 2 2 2 2 2 */
                if (arr[si] == arr[ei]){
                    int totalNumOfElementsFromStartToEnd = (ei -si) + 1;
                    numOfPairsOfTargetSum += (totalNumOfElementsFromStartToEnd * (totalNumOfElementsFromStartToEnd - 1))/2;
                    return numOfPairsOfTargetSum;
                } 
                
                /* for edge cases like 1 2 3 3 5 6 9 9 9 10*/
                int tempSI = si + 1; //tempSI = temporaryStartIndex
                int tempEI = ei - 1; //tempEI = temporaryEndIndex
                
                while(tempSI <= tempEI && arr[tempSI] == arr[si]){
                    ++tempSI;
                }
                
                while(tempEI >= tempSI && arr[tempEI] == arr[ei]){
                    --tempEI;
                }
                
                int totalNumOfDuplicateElementsFromStart = (tempSI - si);    
                int totalNumOfDuplicateElementsFromEnd = (ei - tempEI);      
                
                numOfPairsOfTargetSum += (totalNumOfDuplicateElementsFromStart) * (totalNumOfDuplicateElementsFromEnd);
                
                si = tempSI;
                ei = tempEI;
                
            }
        }
        return numOfPairsOfTargetSum;
    }
}

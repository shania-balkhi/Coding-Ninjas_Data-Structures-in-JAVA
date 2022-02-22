import java.util.Arrays;
public class Solution {	
	public static int pairSum(int[] arr, int num) {
        Arrays.sort(arr);
	int numOfPairs = 0;
        int si = 0, ei = arr.length - 1;
        while(si < ei){ 
            if (arr[si] + arr[ei] < num){
                ++si;
            }else if(arr[si] + arr[ei] > num){
                --ei;
            }else{
                /* for edge cases like 2 2 2 2 2 */
                if (arr[si] == arr[ei]){
                    int totalNumOfElementsFromStartToEnd = (ei -si) + 1;
                    numOfPairs += (totalNumOfElementsFromStartToEnd * (totalNumOfElementsFromStartToEnd - 1))/2;
                    return numOfPairs;
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
                
                numOfPairs += (totalNumOfDuplicateElementsFromStart) * (totalNumOfDuplicateElementsFromEnd);
                
                si = tempSI;
                ei = tempEI;
                
            }
		}
        return numOfPairs;
	}
}

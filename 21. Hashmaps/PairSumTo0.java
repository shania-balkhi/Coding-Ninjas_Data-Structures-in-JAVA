/*Pair Sum to 0

Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well. 

Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.

Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0. 

Constraints :
0 <= N <= 10^4
Time Limit: 1 sec

Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
*/



/*algo (approach 1 - using 2 loops) -
1. put the input array elements into the hashmap (line 53 to 63)
2. initialise a count variable(line 64) and iterate over the range of arraySize. (line 66)
3. for 'count' to compute, the frequency of the ith arrayElement should be > 0 in the HashMap. so that's always the 
   first thing we check in any of the conditional statements.
4. if the ith element is 0 : since 0 does not have any +ve or -ve counterparts, we simply count the pairCount of 0 using the 
   formula : pairCount = (frequencyOfZero * (freuencyOfZero - 1)) / 2;  
5. for numbers other than zero : we look for it's -ve counterpart. if it's -ve counterpart is present, we take frequencies of both
   and multiply them to obtain their cartesian product.
   after this step, since we have got the total count of their pairCounts, we have to reset their frequencies to zero, so that they aren't
   recounted as the loop iteration goes on. and this is also why we get the check of 'step 3'.
6. after this we simply return the 'count' variable and we get the desired output.


note -
count should always be succeeded by the operator "+=" and not just "=", in order to get the correct total count of the pairCounts. 

*/



// approach 1 (using 2 loops)
//code - 1
// import java.util.*;

// class Solution {
// 	public static int PairSum(int[] input, int size) {
//         HashMap<Integer, Integer> map = new HashMap<>();
        
// 		for(int i = 0; i < size; ++i){
//             if(map.containsKey(input[i])){
//                 int oldFrequency = map.get(input[i]);
//                 int updatedFrequency = oldFrequency + 1;
//                 map.put(input[i], updatedFrequency);
//             }else{
//                 map.put(input[i], 1);
//             }
//         }

//         int count = 0;
//         for(int i = 0; i < size; ++i){
//             int freq_ith = map.get(input[i]);
//             if(freq_ith > 0 && input[i] == 0){
//                 count += (freq_ith * (freq_ith - 1)) / 2;
//                 map.put(input[i], 0);
//             }
            
//             else if(map.containsKey(-input[i])){
//                 int freq_minus_ith = map.get(-input[i]);
//                 if(freq_ith > 0 && freq_minus_ith > 0){
//                 	count += freq_ith * freq_minus_ith;
//                 	map.put(input[i], 0);
//                 	map.put(-input[i], 0);
//             	}
//             }
//         }
//         return count;
//     }
// }















/*
algo 2 (for approach 2 - optimized) - using single for loop
1. in this approach, we count the number of Pairs while we go traversing (once) the arrayElements.
2. initialise two variables 'count' and 'freq_of_minus_ith_element' with 0
3. iterate over the range of arraySize
4. check if the map contains the ith_element :
   4.1 if it does not contain then, check whether the map contains minus_ith_element
        4.1.1 if it does then, count will be 'count += freq_minus_ith_element'
        4.1.2 then, insert the ith_element in the map i.e., 'map.put(input[i], 1)'
   4.2 if the map contains the ith element, then repeat steps 4.1 and 4.1.1 (not 4.1.2)
   		4.2.1 evaluate the updatedFrequency_of_ith_element and put it in the map.
5. return count
6.note that this approach also takes care of 'all zeros case' as well!


note -
in line 39, note that the line will be :
			count += freq_of_minus_ith_element 
            and not,
            count += oldFrequency_of_ith_element * freq_of_minus_ith_element (this will give WA) 
*/



//approach 2 - using single for loop - optimized
//code - 2
import java.util.*;

public class Solution {
	public static int PairSum(int[] input, int size) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int freq_of_minus_ith_element = 0;
        for(int i = 0; i < size; ++i){
            if(map.containsKey(input[i])){
                if(map.containsKey(-input[i])){
                    freq_of_minus_ith_element = map.get(-input[i]);
                    count += freq_of_minus_ith_element;
                }
                int oldFrequency_of_ith_element = map.get(input[i]);
                int updatedFrequency_of_ith_element = oldFrequency_of_ith_element + 1;
                map.put(input[i], updatedFrequency_of_ith_element);
            }else{
                if(map.containsKey(-input[i])){
                    freq_of_minus_ith_element = map.get(-input[i]);
                    count += freq_of_minus_ith_element;
                }
                map.put(input[i], 1);
            }
        }
        return count;
	}
}

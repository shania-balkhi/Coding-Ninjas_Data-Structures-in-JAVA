/*algo -
1. put the elements of the first array & their frequencies (no. of occurences) as key : value pairs in a HashMap (this is done between lines 17 to line 27)
3. iterate over a loop as many times as the length of the 2nd array (line 29)
2. check if the map contains elements of the 2nd array (line 30)
   2.1 and if it does contain that element, make sure to check whether it's fequency is > 0. (it has to be greater than 0 for it to become eligible for printing!!)
   2.2 now if it's frequency is > 0, print that element and then make sure to decrease it's frequency by 1 in the map. (this is done between lines 33 and 35)
3. method is complete.

note -
here, frequency > 0 indicates that the frequency of alike elements is now zero in the map. so that intersection point, now ceases to exist & hence that element now does not get printed.
*/

//code
import java.util.HashMap;
public class Solution {
	public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0; i < arr1.length; ++i){
            if(map1.containsKey(arr1[i])){
                int oldFrequency = map1.get(arr1[i]);
                int updatedFrequency = oldFrequency + 1;
                map1.put(arr1[i], updatedFrequency);
            }else{
                map1.put(arr1[i], 1);
            }
        }
        
        for(int i = 0; i < arr2.length; ++i){
            if(map1.containsKey(arr2[i]) && /*imp->*/ map1.get(arr2[i]) > 0){
                System.out.println(arr2[i]);
                
                int oldFrequency = map1.get(arr2[i]);
                int updatedFrequency = oldFrequency - 1;
                map1.put(arr2[i], updatedFrequency);
            }
        }
        
	}
}

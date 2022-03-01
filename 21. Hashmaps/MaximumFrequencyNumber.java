import java.util.HashMap;
public class Solution {
    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; ++i){
            if(map.containsKey(arr[i])){
                int oldFrequency = map.get(arr[i]);
                int updatedFrequency = oldFrequency + 1;
                map.put(arr[i], updatedFrequency);
            }else{
                map.put(arr[i], 1);
            }
        }
        
        int maxFrequencyKey = arr[0];
        for(int i : arr){ //imp!! 
            if (map.get(i) > map.get(maxFrequencyKey)){
                maxFrequencyKey = i;
            }
        }
    	return maxFrequencyKey; 
    }

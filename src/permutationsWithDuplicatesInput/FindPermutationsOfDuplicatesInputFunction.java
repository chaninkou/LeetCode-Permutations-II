package permutationsWithDuplicatesInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPermutationsOfDuplicatesInputFunction {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        
        // Need to be sorted or else checking if statement boolean will not work
        Arrays.sort(nums);
        
        // boolean array will be size of nums
        backtrack(finalList, new ArrayList<>(), nums, new boolean[nums.length]);
        
        return finalList;
    }
    
    private void backtrack(List<List<Integer>> finalList, List<Integer> tempList, int[] nums, boolean[] used){
        // Permutation solution will have the same length as input
        if(tempList.size() == nums.length){
        	
        	// Make sure to add a new arraylist or else its not going to add anything
            finalList.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                // used[i] is too check if the element of that index is already inserted to tempList, 
            	// !used[i-1] means the previous element was already done, thats why it got resetted back to false
                if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])){
                    continue; 
                }
                
                // Means this element already inserted
                used[i] = true;
                
                // Add it to temp list
                tempList.add(nums[i]);
                
                // backtrack
                backtrack(finalList, tempList, nums, used);
                
                // Means this element can be use again
                used[i] = false;
                
                // Remove the last element of temp list since its backtracking
                tempList.remove(tempList.size() - 1);
            }
        }
    }	
}

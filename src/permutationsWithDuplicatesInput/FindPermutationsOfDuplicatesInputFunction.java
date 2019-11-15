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
            finalList.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                // used[i] is too check if the element of that index is already inserted to tempList, i > 0 && nums[i] == nums[i - 1] && !used[i - 1] happen when the two element are the same of each others 
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

package permutationsWithDuplicatesInput;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		System.out.println("Input: " + Arrays.toString(nums));
		
		FindPermutationsOfDuplicatesInputFunction solution = new FindPermutationsOfDuplicatesInputFunction();
		
		System.out.println("Solution: " + solution.permuteUnique(nums));
	}
}

package bossCoderProblems.hashing;

import java.util.HashMap;

public class p117_findTheLengthOfLargestSubarrayWith0Sum {
    public static void main(String[] args) {
    // Given an array arr[] of length N, find the length of the longest sub-array with a sum equal to 0.
    int[] input = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = input.length, ans = 0, rs = 0;
        HashMap<Integer, Integer> idx = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            rs += input[i]; // Running sum
            System.out.println("line 14 - "+rs);
            
            // Case 1: First occurrence of this running sum, store the index
            System.out.println("line 17 - "+idx.get(rs));
            if (idx.get(rs) == null) {
                idx.put(rs, i);
                System.out.println("line 20 - "+idx);
            } else {
                // Case 2: Found a subarray with sum 0, calculate its length
                int length = i - idx.get(rs);
                System.out.println("line 24 "+length);
                if (length > ans) {
                    ans = length; // Update answer if this length is larger
                    System.out.println("answer "+ans);
                }
            }
            
            // Case 3: Special case when the running sum is 0 from index 0 to i
            if (rs == 0) {
                ans = i + 1; // The subarray length is i + 1
            }
        }
        System.out.println(idx);
        System.out.println(ans); // Return the maximum length of subarray with sum 0
    }
}
/**
 * Leetcode problem 796. Rotae String
 * https://leetcode.com/problems/rotate-string/description/
 */
public class Solution {
    public boolean rotateString(String A, String B) {
        return (A + A).contains(B);
    }
}

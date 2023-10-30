import java.util.stream.Stream;

/**
 * You are given an array of integers, where positive numbers represent revenues and negative numbers
 * represent expenses, all in chronological order. In one move you can relocate any expense (negative number) to the
 * end of the array. What is the minimum number of such relocations to make sure that the company never falls into debt?
 * Given A = [10, -10, -1, 1, 10] (expect 1)
 * Given A = [-1, -1, -1, 1, 1, 1, 1] (expect 3)
 * Given A = [5, -2, -3, 1] (expect 0)
 * <p>
 * RULES
 * - Company balance is ALWAYS positive
 * - N is an integer within the range [1..100,000]
 * - Each element of the array A is an integer within the range [-1,000,000,000... 1,000,000,000]
 * - Sum of all elements in A is greater than or equal to zero
 */
public class Solution {
    // *** Note - I made this static to avoid writing a unit test - this is lazy ***
    // This solution is O(n) - it iterates through every element in the array once, therefore it will be linear time complexity.
    // The solution makes use of the assumption that the sum of all elements in A is always greater or equal to zero.
    public static int solution(int[] input) {
        int numberOfMovesCount = 0;
        int runningTotal = 0;

        for (int numberAtPosition : input) {
            int newTotalToTest = runningTotal + numberAtPosition;
            if (newTotalToTest < 0) {
                numberOfMovesCount++;
            } else {
                runningTotal = newTotalToTest;
            }
        }
        return numberOfMovesCount;
    }

    /* This is lazy - it should be a @ParameterizedTest unit test */
    public static void main(String[] args) {
        Stream.of(
                        new int[]{10, -10, -1, 10},
                        new int[]{-1, -1, -1, 1, 1, 1, 1},
                        new int[]{5, -2, -3, 1})
                .forEach(o -> System.out.println(solution(o)));
    }
}

package cn.tsplaycool;

import java.util.Arrays;

public class LeetCode {

	public static void main(String[] args) {
		LeetCode leetCode = new LeetCode();
		int[] array = new int[] { 1, 2 };
		System.out.println("hello world!");
		leetCode.rotate(array, 1);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i] + " ");
	}

	/**
	 * Rotate an array of n elements to the right by k steps.
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		if (nums.length == 1) {
			return;
		}
		int n = k % (nums.length - 1);
		if (n == 0) {
			return;
		}
		revert(nums, 0, n);
		revert(nums, n + 1, nums.length - 1);
		revert(nums, 0, nums.length - 1);
	}

	private void revert(int[] nums, int start, int end) {
		if (start == end)
			return;
		for (int i = 0; i <= (end - start) / 2; i++) {
			int temp = nums[start + i];
			nums[start + i] = nums[end - i];
			nums[end - i] = temp;
		}
	}

	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		boolean isNeedAddRoom = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				isNeedAddRoom = false;
				break;
			}
		}
		int digitsLength = digits.length;
		int[] result;
		if (isNeedAddRoom) {
			result = new int[digitsLength + 1];
			result[0] = 1;
		} else {
			result = digits;
			for (int i = digitsLength - 1; i >= 0; i--) {
				if (result[i] == 9) {
					result[i] = 0;
				} else {
					result[i]++;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,
	 * Given input array A = [1,1,2],
	 * Your function should return length = 2, and A is now [1,2]
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A) {
		int header = 0;
		int tail = 0;
		for (int i = 0; i < A.length; i++) { // 设置两个指针
			if (A[header] != A[tail]) {
				header++;
				A[header] = A[tail];
			}
			tail++;
		}

		if (A.length > 0)
			A = Arrays.copyOf(A, ++header);
		return A.length;
	}

}

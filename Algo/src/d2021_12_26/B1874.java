package d2021_12_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/1874
 * 
 * 8
 * 
 * 4, 3, 6, 8, 7, 5, 2, 1
 */
public class B1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for(int i=0; i< n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int arrPointer = 0;
		StringBuilder sb = new StringBuilder();
		for(int i =1; i<=n; i++) {
			stack.push(i);
			sb.append("+").append(System.getProperty("line.separator"));
			while(stack.peek() == nums[arrPointer]) {
				stack.pop();
				sb.append("-").append(System.getProperty("line.separator"));
				arrPointer++;
				if(stack.isEmpty()||arrPointer>=n) {
					break;
				}
			}
			
			
		}
		if(!stack.isEmpty()) {
			System.out.println("NO");
		}else {
			System.out.println(sb.toString());
		}
		
		
	}
}

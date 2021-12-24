package d2020_02_24;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] answer= new int[n];
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		Arrays.fill(answer, -1);
		stk.push(0);
		
		for(int i=0; i<n; i++) {
			while(!stk.isEmpty()) {
//				System.out.println("i: "+ i+",idx "+stk.peek());
				if(arr[i]>arr[stk.peek()]) {
					answer[stk.pop()]=arr[i];
				}else {
					stk.add(i);
					break;
				}
			}
			if(stk.isEmpty()) {
				stk.add(i);
			}
		}
		

		
		
//		System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb.toString());
	}
}

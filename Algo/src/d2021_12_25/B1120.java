package d2021_12_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String first = st.nextToken();
		String last = st.nextToken();
		
		int t =last.length() - first.length();		
		int answer = 1000;
		for(int i =0; i<=t; i++) {
			String strToCompare = last.substring(i, i+first.length());
//			System.out.println(strToCompare);
			int cnt = countDiff(first,strToCompare);
			answer = Math.min(answer, cnt);
		}
		System.out.println(answer);
	}

	private static int countDiff(String first, String strToCompare) {
		int cnt = 0;
		for(int i=0; i<first.length(); i++) {
			if(first.charAt(i) != strToCompare.charAt(i)) {
				cnt++;
			}
		}
		return cnt;
	}
}

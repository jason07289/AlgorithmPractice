package d2021_12_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B1342 {
	static String str="";
	static int choice[];
	static int check[];
	static Set<String> strSet;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		choice = new int[str.length()];
		check = new int[str.length()];
		max = str.length();
		strSet = new HashSet<>();
		dfs(0);
		System.out.println(strSet.size());
	}
	private static void dfs(int depth) {
		if(depth == max) {
			//System.out.println(Arrays.toString(choice));
			checkLuckyString();	
		}
		for(int i=0; i<max; i++) {
			if(check[i]==0) {
				check[i]=1;
				choice[depth] = i;
				System.out.println(Arrays.toString(choice));
				dfs(depth+1);
				check[i] =0;
			}
		}
	}
	private static void checkLuckyString() {
		StringBuilder newStringB = new StringBuilder();
		for(int i=0; i<max; i++)
			newStringB.append(str.charAt(choice[i]));
		
		String newString = newStringB.toString();
		//System.out.println(newString);
		boolean isLucky =true;
		for(int i=0; i<max; i++) {
			boolean beforeDiff =false;
			boolean afterDiff =false;
			int beforeI = i-1;
			int afterI = i+1;
			if(beforeI >=0) {
				if(newString.charAt(i) != newString.charAt(beforeI)) {
					beforeDiff =true;
				}
			}else {
				beforeDiff = true;
			}
			
			if(afterI <max) {
				if(newString.charAt(i) != newString.charAt(afterI)) {
					afterDiff =true;
				}
			}else {
				afterDiff = true;
			}
			if(!beforeDiff&&afterDiff) {
				isLucky =false;
			}
		}
		if(isLucky) {
			strSet.add(newString);
		}
		
	}
}

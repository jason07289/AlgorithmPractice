package d2020_02_18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B18310 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int middle1 = list.get(n/2-1);
		int middle2 = list.get(n/2);
//		System.out.println(middle1);
//		System.out.println(middle2);
		int sum1=0;
		int sum2=0;
		for(int i=0; i<n; i++) {
			sum1+=Math.abs(middle1-list.get(i));
			sum2+=Math.abs(middle2-list.get(i));
		}
		if(sum1>sum2) {
			System.out.println(middle2);
		}else {
			System.out.println(middle1);
		}
	}
}

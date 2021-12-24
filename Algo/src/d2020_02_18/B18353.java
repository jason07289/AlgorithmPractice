package d2020_02_18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18353 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		long k=Long.parseLong(st.nextToken());
		int arr[]= new int[n];
		long maxval=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int x=Integer.parseInt(st.nextToken());
			maxval+=(long)x;
			arr[i]=x;
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(maxval);
		if(maxval<k) {
			k=k-maxval;
			for(int i=n-1; i>=0; i--) {
				if(k<=0) {
					System.out.println(i+1);
					break;
				}
				if(k<arr[i]) {
					System.out.println(i+1);
					break;
				}
				k-=arr[i];
			}
			
		}else if(maxval==k) {
			System.out.println(n);
//			return;
		}else {
//			System.out.println("???");
			for(int i=0; i<n; i++) {
				if(k<=0) {
					System.out.println(i+1);
					break;
				}
							
				if(k<arr[i]) {
					System.out.println(i+1);
					break;
				}
				k-=arr[i];
//				System.out.println(k);
			}
		}
	}
}

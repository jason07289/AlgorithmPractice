package d2020_02_11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18405 {
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int n;
	static int k;
	static int targetX;
	static int targetY;
	static int s;
	static int map[][];
	static int min;
	static int minTime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		map= new int[n][n];
		min=0;
		minTime = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		targetX=Integer.parseInt(st.nextToken())-1;
		targetY=Integer.parseInt(st.nextToken())-1;
		
		for(int vir=1; vir<=k; vir++ ) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==vir) {
//						System.out.println("findtime: "+findtime(i,j));
						
						if(findtime(i,j)<minTime&&findtime(i,j)<=s) {
							min=vir;
							minTime=findtime(i, j);
						}
						break;
					}
				}
			}
		}
		System.out.println(min);
		
	}
	private static int findtime(int i, int j) {
//		System.out.println(i+", "+j);
//		System.out.println(targetX+", "+targetY);
//		System.out.println("dis"+Math.abs(i-targetX));
//		System.out.println("dis"+Math.abs(j-targetY));
		double x=Math.abs(i-targetX)+Math.abs(j-targetY);
		return (int) x;
		
	}
	

}

package d2020_02_18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18428 {
	static int[][] map;
	static int n;
	static int[] wall=new int[3];
	static int[][] origin;
	static int walln;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		map= new int[n][n];
		origin=new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				String c=st.nextToken();
				if(c.charAt(0)=='S') {
					//-1 = student
					map[i][j]= -1;
					origin[i][j]=-1;
				}else if(c.charAt(0)=='T') {
					//-2=teacher
					map[i][j]= -2;
					origin[i][j]=-2;
					
				}
			}
		}
		
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("0000000000000000000000000000000000000000000000000000");
		walln=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==0) {
					map[i][j]=walln++;
					origin[i][j]=map[i][j];
				}
			}
		}
//		System.out.println(walln);
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		recur(0);
		if(result) {
			
			System.out.println("YES");
		}else {
			
			System.out.println("NO");
		}
	}
	static boolean result=false;
	private static void backUp() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=origin[i][j];
			}
		}
	}
	
	static void recur(int depth) {
		if(depth==3) {
			backUp();
//			System.out.println(Arrays.toString(wall));
			if(search()) {
				result=true;
			}
			
			return;
		}
		for(int i=0; i<walln; i++) {
			wall[depth]=i;
			recur(depth+1);
		}
	}

	private static boolean search() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(wall[i]==map[j][k]) {
						map[j][k]=-3;
					}
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		return canSee();
	}
	private static boolean canSee() {
		int can=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==-2) {
					if(findStu(i,j))
						can++;
				}
			}
		}
		
		if(can!=0)
			return false;
		else
			return true;
	}
	private static boolean findStu(int x, int y) {
		boolean flag=false;
		for(int i=0; i<4; i++) {
			int len=1;
			while(true) {
				int nx =x +dx[i]*len;
				int ny=y+dy[i]*len;
				
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(map[nx][ny]==-1) {
						flag=true;
						break;
					}else if(map[nx][ny]==-3) {
						break;
					}
					len++;
				}else {
					break;
				}
				
				
				
			}
		}
		return flag;
	}
}

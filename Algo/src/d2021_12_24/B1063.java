package d2021_12_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 8*8 size map
 * 
 */
public class B1063 {
	static int map[][] = new int[8][8];
	static Map<String, int[]> cmdMap = new HashMap<>();
	static int kx;
	static int ky;
	static int sx;
	static int sy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		makeCMD();
		Iterator<String> mapIter = cmdMap.keySet().iterator();
//		while(mapIter.hasNext()){
//			 
//            String key = mapIter.next();
//            int[] value = cmdMap.get( key );
// 
//            System.out.println(key+" : "+Arrays.toString(value));
// 
//        }
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String locationData = br.readLine();
		StringTokenizer st = new StringTokenizer(locationData);
		String kingLocation = st.nextToken();
		String stoneLocation = st.nextToken();
		putPiece(kingLocation, "k");
		putPiece(stoneLocation, "s");
//		for(int i=0; i<8; i++) {
//			System.out.println(Arrays.toString(map[i]) );
//		}
//		for(int i=0; i<8; i++) {
//			System.out.println(Arrays.toString(kingMap[i]) );
//		}
//		System.out.println();
//		for(int i=0; i<8; i++) {
//			System.out.println(Arrays.toString(stoneMap[i]) );
//		}
		
		int tc = Integer.parseInt(st.nextToken());
		for(int i=0; i< tc; i ++) {
			String cmdToMove = br.readLine();
			movePiece(cmdToMove);
		}
//		for(int i=0; i<8; i++) {
//			System.out.println(Arrays.toString(map[i]) );
//		}
		
		printAnswer();
		
	}
	private static void printAnswer() {
		char k1 = (char) (ky+65);
		char k2 = (char) ((8-kx)+48);
		System.out.println(k1+""+k2);
		char s1 = (char) (sy+65);
		char s2 = (char) ((8-sx)+48);
		System.out.println(s1+""+s2);
	}
	private static void putPiece(String location, String option) {
		int firstY = location.charAt(0) -65;
		int firstX = location.charAt(1) -48;
		int x = 8-firstX;
		int y = firstY;
		
		if("k".equals(option)) {
			map[x][y] = 1;
			kx=x;
			ky=y;		
		}else {
			map[x][y] = 2;
			sx=x;
			sy=y;
		}
	}
	private static void movePiece(String cmdToMove) {
		int[] nextPoint = cmdMap.get(cmdToMove);
		int nextKx = kx + nextPoint[0];
		int nextKy = ky + nextPoint[1];
		if(nextKx>=0 && nextKy>=0 && nextKx<8 && nextKy<8) {
			if(map[nextKx][nextKy] == 2) {
				int nextSx = sx + nextPoint[0];
				int nextSy = sy + nextPoint[1];
				if(nextSx>=0 && nextSy>=0 && nextSx<8 && nextSy<8) {
					map[kx][ky] = 0;
					map[sx][sy] = 0;
					kx = nextKx;
					ky = nextKy;
					sx = nextSx;
					sy = nextSy;
					
					map[kx][ky] = 1;
					map[sx][sy] = 2;
				}
			}else {
				map[kx][ky] = 0;
				kx = nextKx;
				ky = nextKy;
				map[kx][ky] = 1;
			}
			
			
		}
	}
	private static void makeCMD() {
		int[] idx = {0,1};
		cmdMap.put("R", idx);

		int[] idx2 = {0,-1};
		cmdMap.put("L", idx2);
		
		int[] idx3 = {1,0};
		cmdMap.put("B", idx3);

		int[] idx4 = {-1,0};
		cmdMap.put("T", idx4);
		
		int[] idx5 = {-1,1};
		cmdMap.put("RT", idx5);
		
		int[] idx6 = {-1,-1};
		cmdMap.put("LT", idx6);

		int[] idx7 = {1,1};
		cmdMap.put("RB", idx7);
		
		int[] idx8 = {1,-1};
		cmdMap.put("LB", idx8);
	
	}

}

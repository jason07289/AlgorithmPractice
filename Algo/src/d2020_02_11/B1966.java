package d2020_02_11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc= Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m =	Integer.parseInt(st.nextToken());
			Queue<Pri> q = new LinkedList<Pri>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.add(new Pri(i,priority));
				pq.add(priority);
			}
			
			int cnt=0;
			while(!pq.isEmpty()) {
				int priority=pq.poll();
				Pri p = q.poll();
				if(priority==p.priority) {
					cnt++;
					if(p.idx==m) {
						System.out.println(cnt);
						break;
					}
				}else {
					q.add(p);
					pq.add(priority);
				}
				
			}
			
		}
		
	}
	static class Pri{
		int idx;
		int priority;
		public Pri(int idx, int priority) {
			super();
			this.idx = idx;
			this.priority = priority;
		}
		
	}
}

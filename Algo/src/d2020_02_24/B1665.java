package d2020_02_24;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1665 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=0; j<i/2; j++) {
				list.add(pq.poll());
			}
			System.out.println(pq.peek());
			
			for(int j=0; j<list.size(); j++) {
				pq.add(list.get(j));
			}
		}
	}
}

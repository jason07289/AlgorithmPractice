package d2020_02_11;
import java.util.*;
public class ramen {
    public static void main(String[] args) {
    
//    	int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//    	int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20,2}};
    	int stock=4;
    	int[] dates= {4,10,15};
    	int[] supplies= {20,5,10};
    	int k=30;
    			
    	
    	int answer =solution(stock,dates,supplies, k);
    	System.out.println(answer);
	}
    
    
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
    	int n=dates.length;
    	int[][] jobs=new int[dates.length][2];
    	
    	for(int i=0; i<n;i++) {
    		jobs[i][0]=dates[i];
    		jobs[i][1]=supplies[i];
    	}
    	
        int answer = 0;
        int sum=0;
        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        //우선순위 큐에 먼저 삽입
        ArrayList<Job> list = new ArrayList<Job>();
        
         
        for(int i=0; i<n; i++) {
        	list.add(new Job(jobs[i][0], jobs[i][1]));
        }
        System.out.println(list);
        Collections.sort(list,new Comparator<Job>() {

			@Override 
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});
        
        int time=stock;
        for(int i=0; i<list.size(); i++) {
    		if(list.get(i).start<=time) {
    			pq.add(list.get(i));
    			System.out.println("--insert--");
    			list.remove(i);
    			i--;
    		}
    	}
        while(!list.isEmpty()||!pq.isEmpty()) {
        	
        	System.out.println("time"+time);
        	for(int i=0; i<list.size(); i++) {
        		if(list.get(i).start<=time) {
        			pq.add(list.get(i));
        			System.out.println("--insert--");
        			list.remove(i);
        			i--;
        		}
        	}
        	
        	if(pq.size()!=0) {
        		Job j = pq.poll();
        		
        	
        		time+=j.len;
        		System.out.println("time: "+time);
        		System.out.println(j);
        		answer++;
        	}
        	if(time>=k) {
        		break;
        	}
        }
        
        return answer;
    }
    
    static class Job implements Comparable<Job>{
        int start;
        int len;
        public Job(int start, int len){
            this.start=start;
            this.len=len;
        }
        
        @Override
        public int compareTo(Job o){
            return o.len-this.len;
        }

		@Override
		public String toString() {
			return "Job [start=" + start + ", len=" + len + "]";
		}
        
    }
}
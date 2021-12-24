package d2020_02_11;
import java.util.*;
public class DiskScheduler {
    static int nowtime;
    public static void main(String[] args) {
    
    	int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//    	int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20,2}};
    	
    	
    	int answer =solution(jobs);
    	System.out.println(answer);
	}
    
    
    public static int solution(int[][] jobs) {
        int answer = 0;
        int n=jobs.length;
        nowtime=0;
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
        
        int time=list.get(0).start;
        pq.add(list.get(0));
        list.remove(0);
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
        		
        		sum+=(time-j.start);
        		System.out.println("sum: "+sum);
        	}else {
        		time++;
        		
        	}
        }
        
        answer=sum/n;
        System.out.println("n? "+n);
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
            return this.len-o.len;
        }

		@Override
		public String toString() {
			return "Job [start=" + start + ", len=" + len + "]";
		}
        
    }
}
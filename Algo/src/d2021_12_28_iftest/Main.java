package d2021_12_28_iftest;

import java.util.ArrayList;

public class Main {
	int a;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Main other = (Main) obj;
		if (a != other.a)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Main [a=" + a + "]";
	}

	public Main(int a) {
		super();
		this.a = a;
	}

	public static void main(String[] args) {
		Service s = new ServiceImpl();
		s.getData();
		String sss = "1223";
		if(sss.equals(sss)) {
			
		}
		
		AbstractTest a = new AbstractTestChild();
		a.getData();
		ArrayList<Integer> list;
		System.out.println(sss);
		System.out.println(sss.getClass());
	}
}

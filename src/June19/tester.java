package June19;

import java.util.Comparator;

import June19.CustomPriorityQueue;

public class tester {

	public static class sorter implements Comparator<student> {

		public int compare(student s1, student s2) {
			if (s1.extra == s2.extra) {
				return s1.marks - s2.marks;
			}

			return s1.extra - s2.extra;
		}
	}

	public static class student implements Comparable<student> {
		int marks;
		int extra;

		student(int m, int e) {
			this.marks = m;
			this.extra = e;
		}

		void display() {
			System.out.println("m = " + marks + ", e = " + extra);
		}

		public int compareTo(student o) {
			if (this.marks == o.marks) {
				return this.extra - o.extra;
			}
			return this.marks - o.marks;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// CustomPriorityQueue<student> pq = new CustomPriorityQueue<>();

		// pq.add(new student(10, 10));
		// pq.add(new student(8, 6));
		// pq.add(new student(6, 6));
		// pq.add(new student(9, 5));
		// pq.add(new student(5, 7));
		// pq.add(new student(9, 8));
		// pq.add(new student(10, 8));
		//
		// while (pq.size() > 0) {
		// student s = pq.remove();
		// s.display();
		// }
		
		Integer[] arr = {5,2,8,7,6,9,0,1,8,4};
		CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>(arr);
		while(pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
	}

}

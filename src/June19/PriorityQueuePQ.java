package June19;

import java.util.*;

public class PriorityQueuePQ {

	public static class PriorityQueue {
		
		private ArrayList<Integer> strg;
		private boolean min;

		private void swap(int i, int j) {
			int ith = strg.get(i);
			int jth = strg.get(j);
			
			strg.set(i, jth);
			strg.set(j, ith);
		}
		
		private boolean isHP(int ci, int pi) {
			if(min == true) {
				if(strg.get(pi) > strg.get(ci)) {
					return true;
				} else {
					return false;
				}
			} else {
				if(strg.get(pi) > strg.get(ci)) {
					return false;
				} else {
					return true;
				}
			}
		}

		private void upheapify(int ci) {
			if(ci == 0) {
				return;
			}
			
			int pi = (ci - 1) / 2;
			if(isHP(ci, pi)) {
				swap(ci, pi);
				upheapify(pi);
			}
		}

		private void downheapify(int pi) {
			
			int hpi = pi;
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;
			
			if(lci < strg.size() && isHP(lci, hpi) == true) {
				hpi = lci;
			}
			
			if(rci < strg.size() && isHP(rci, hpi) == true) {
				hpi = rci;
			}
			
			if(hpi != pi) {
				swap(hpi, pi);
				downheapify(hpi);
			}
			
		}
		
		PriorityQueue(boolean min) {
			strg = new ArrayList<>();
			this.min = min;
		}

		public int peek() {
			if (strg.size() == 0) {
				return -1;
			} else {
				return strg.get(0);
			}
		}

		public void add(int data) {
			strg.add(data);
			upheapify(strg.size() - 1);
		}

		public int remove() {
			if (strg.size() == 0) {
				return -1;
			} else {
				swap(0, strg.size() - 1);
				int temp = strg.get(strg.size() - 1);
				strg.remove(strg.size() - 1);
				downheapify(0);
				return temp;
			}
		}
		
		public int size() {
			return strg.size();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean min = false;
		PriorityQueue pq = new PriorityQueue(min);
		pq.add(10);
		pq.add(50);
		pq.add(90);
		pq.add(40);
		pq.add(70);
		pq.add(30);
		
		while(pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();
	}

}

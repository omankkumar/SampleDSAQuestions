package June19;

import java.util.*;

public class CustomPriorityQueue<T> {

	private ArrayList<T> arr;
	private Comparator<T> camptor;

	private void swap(int i, int j) {
		T ith = arr.get(i);
		T jth = arr.get(j);

		arr.set(i, jth);
		arr.set(j, ith);
	}

	private boolean isHP(int i, int j) {
		if (camptor != null) {
			T ith = arr.get(i);
			T jth = arr.get(j);
			boolean val = camptor.compare(ith, jth) < 0;
			return val;
		} else {
			Comparable<T> ith = (Comparable<T>) arr.get(i);
			T jth = arr.get(j);
			boolean val = ith.compareTo(jth) < 0;
			return val;
		}

	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;
		if (isHP(ci, pi)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int hpi = pi;

		if (lci < arr.size() && isHP(lci, hpi) == true) {
			hpi = lci;
		}

		if (rci < arr.size() && isHP(rci, hpi) == true) {
			hpi = rci;
		}

		if (hpi != pi) {
			swap(pi, hpi);
			downheapify(hpi);
		}
	}

	public CustomPriorityQueue() {
		this.camptor = null;
		this.arr = new ArrayList<>();
	}

	public CustomPriorityQueue(Comparator<T> camptor) {
		this.camptor = camptor;
		this.arr = new ArrayList<>();
	}

	public CustomPriorityQueue(T[] array) {
		this.camptor = null;
		this.arr = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			arr.add(array[i]);
		}
		
		for(int i = arr.size() - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	public T peek() {
		if (arr.size() > 0) {
			return arr.get(0);
		} else {
			return null;
		}
	}

	public void add(T data) {
		arr.add(data);
		upheapify(arr.size() - 1);
	}

	public T remove() {
		if (arr.size() == 0) {
			return null;
		} else {
			swap(0, arr.size() - 1);
			T ret = arr.remove(arr.size() - 1);
			downheapify(0);
			return ret;
		}
	}

	public int size() {
		return arr.size();
	}

}

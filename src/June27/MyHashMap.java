package June27;

import java.util.*;

public class MyHashMap<key, value> {

	private class hmnode {
		key k;
		value v;

		hmnode(key k, value v) {
			this.k = k;
			
			this.v = v;
		}
	}

	private int N;
	private int n;
	private LinkedList<hmnode>[] arr;

	private void rehash() {
		LinkedList<hmnode>[] arl = new LinkedList[2 * N];
		for(int i = 0; i < arl.length; i++) {
			arl[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < arr.length; i++) {
			while(arr[i].size() > 0) {
				hmnode node = arr[i].removeFirst();
				int hc = Math.abs(node.k.hashCode());
				int bno = hc % (2 * N);
				
				arl[bno].add(node);
			}
		}
		this.arr = arl;
		N = 2 * N;
	}

	private int getBucketIndex(key k) {
		int hc = Math.abs(k.hashCode());
		int bno = hc % N;

		return bno;
	}

	private int getDataIndex(int bi, key k) {
		LinkedList<hmnode> ll = arr[bi];
		for (int i = 0; i < ll.size(); i++) {
			hmnode node = ll.get(i);
			if (node.k.equals(k)) {
				return i;
			}
		}

		return -1;
	}

	MyHashMap() {
		N = 4;
		n = 0;
		arr = new LinkedList[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new LinkedList<>();
		}
	}

	public boolean containsKey(key k) {
		int bi = getBucketIndex(k);
		int di = getDataIndex(bi, k);

		if (di == -1) {
			return false;
		} else {
			return true;
		}
	}

	public value get(key k) {
		int bi = getBucketIndex(k);
		int di = getDataIndex(bi, k);

		if (di == -1) {
			return null;
		} else {
			return arr[bi].get(di).v;
		}
	}

	public void put(key k, value v) {
		int bi = getBucketIndex(k);
		int di = getDataIndex(bi, k);

		if (di == -1) {
			hmnode node = new hmnode(k, v);
			arr[bi].add(node);
			n++;

			double lambda = n * 1.0 / N;
			if (lambda > 2) {
				rehash();
			}
		} else {
			arr[bi].get(di).v = v;
		}
	}

	public value remove(key k) {
		int bi = getBucketIndex(k);
		int di = getDataIndex(bi, k);

		if (di == -1) {
			return null;
		} else {
			value val = arr[bi].get(di).v;
			arr[bi].remove(di);
			n--;
			return val;
		}
	}

	public int size() {
		return n;
	}

	public void display() {
		
		System.out.println("-----------------------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + ". ");
			for (int j = 0; j < arr[i].size(); j++) {
				System.out.print(arr[i].get(j).k + "->" + arr[i].get(j).v + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
		
	}

	public HashSet<key> keySet() {
		HashSet<key> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].size(); j++) {
				set.add(arr[i].get(j).k);
			}
		}
		return set;
	}

	public static void main(String[] args) {

		MyHashMap<String, Integer> map = new MyHashMap<>();
		map.put("India", 125);
		map.put("Pakistan", 80);
		map.put("China", 200);
		map.put("Bangladesh", 50);
		map.put("Afganistan", 30);
		map.put("Myanmar", 40);
		map.put("Nepal", 20);
		map.put("Bhutan", 10);
		map.display();
		map.put("Sri Lanka", 20);
		map.display();
		map.put("Maldives", 5);
		map.display();
	}
}

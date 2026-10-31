package May24;

import java.util.ArrayList;

public class MinStackNoSpace {

	private int[] data;
	private int cap;
	private int tos;
	private int msf;

	public MinStackNoSpace(int cap) {
		this.data = new int[cap];
		this.cap = cap;
		this.tos = -1;
		this.msf = Integer.MAX_VALUE;
	}

	public void push(int val) {
		if (tos == cap - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		if (val > msf) {
			tos++;
			data[tos] = val;
		} else {
			tos++;
			data[tos] = (2 * val) - msf;
			msf = val;
		}
	}

	public int pop() {
		if (tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		if (data[tos] > msf) {
			int temp = data[tos];
			data[tos] = 0;
			tos--;
			return temp;
		} else {
			int temp = msf;
			msf = (2 * msf) - data[tos];
			data[tos] = 0;
			tos--;
			return temp;
		}
	}

	public int top() {
		if (tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		if (data[tos] >= msf) {
			return data[tos];
		} else {
			return msf;
		}

	}

	public int size() {
		return tos + 1;
	}

	public boolean IsEmpty() {
		if (tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public int MinSoFar() {
		return msf;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStackNoSpace ms = new MinStackNoSpace(10);
//		System.out.println(ms.MinSoFar());
		ms.push(10);
		System.out.println(ms.MinSoFar());
		ms.push(5);
		ms.push(3);
		ms.push(6);
		ms.push(9);
		ms.push(-1);
		ms.push(45);
		ms.push(-5);
		ms.push(56);
		ms.push(32);
		
		ArrayList<Integer> arr = new ArrayList<>();

//		while (ms.size() > 0) {
//			System.out.print(ms.MinSoFar() + " ");
//			ms.pop();
//		}
	}

}

package May24;

public class TwoStacks {
	
	private int[] data;
	private int tos1;
	private int tos2;
	private int cap;
	
	public TwoStacks(int cap) {
		this.data = new int[cap];
		this.tos1 = -1;
		this.tos2 = cap;
		this.cap = cap;
	}
	
	public void push1(int val) {
		if(tos1 == tos2 - 1) {
			System.out.println("Stack is Full");
			return;
		}
		
		tos1++;
		data[tos1] = val;
	}
	
	public void push2(int val) {
		if(tos2 == tos1 + 1) {
			System.out.println("Stack is Full");
			return;
		}
		
		tos2--;
		data[tos2] = val;
	}
	
	public int pop1() {
		if(tos1 == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int temp = data[tos1];
		data[tos1] = 0;
		tos1--;
		return temp;
	}
	
	public int pop2() {
		if(tos2 == this.cap) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int temp = data[tos2];
		data[tos2] = 0;
		tos2++;
		return temp;
	}
	
	public int top1() {
		if(tos1 == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		return data[tos1];
	}
	
	public int top2() {
		if(tos2 == this.cap) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		return data[tos2];
	}
	
	public boolean IsEmpty1() {
		if(tos1 == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsEmpty2() {
		if(tos2 == this.cap) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsFull() {
		if(tos1 == tos2 - 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TwoStacks ts = new TwoStacks(5);
		ts.push1(10);
		ts.push1(20);
		ts.push1(30);
		
		ts.push2(40);
		ts.push2(50);
		
		ts.push1(60);
		
		System.out.println(ts.IsFull());
		
		System.out.println(ts.pop1());
		System.out.println(ts.pop1());
		System.out.println(ts.pop1());
		System.out.println(ts.pop1());
		System.out.println(ts.IsEmpty1());
		System.out.println(ts.IsEmpty2());
		
		System.out.println(ts.pop2());
		System.out.println(ts.pop2());
		System.out.println(ts.pop2());
		System.out.println(ts.IsEmpty1());
		System.out.println(ts.IsEmpty2());

	}

}

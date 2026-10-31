package May24;

public class MyStack {
	
	private int[] data;
	private int cap;
	private int tos;
	
	public MyStack(int cap) {
		this.data = new int[cap];
		this.cap = cap;
		this.tos = -1;
	}
	
	public void push(int val) {
		if(tos == cap - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		tos++;
		data[tos] = val;
	}
	
	public int pop() {
		if(tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
	}
	
	public int top() {
		if(tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return data[tos];
	}
	
	public int size() {
		return tos + 1;
	} 
	
	public boolean IsEmpty() {
		if(tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack ms = new MyStack(5);
		
		ms.push(10);
		ms.push(20);
		ms.push(30);
		ms.push(40);
		ms.push(50);
		ms.push(60);
		
		while(ms.size() > 0) {
			System.out.println(ms.pop());
		}
		
		ms.pop();
	}

}

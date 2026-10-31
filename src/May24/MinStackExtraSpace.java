package May24;

public class MinStackExtraSpace {
	
	private int[] data;
	private int[] msf;
	private int cap;
	private int tos;
	
	public MinStackExtraSpace(int cap) {
		this.data = new int[cap];
		this.msf = new int[cap];
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
		if(tos == 0) {
			msf[tos] = val;
		} else {
			if(val < msf[tos - 1]) {
				msf[tos] = val;
			} else {
				msf[tos] = msf[tos - 1];
			}
		}
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
		MinStackExtraSpace ms = new MinStackExtraSpace(10);
		ms.push(10);
		ms.push(5);
		ms.push(3);
		ms.push(6);
		ms.push(9);
		ms.push(-1);
		ms.push(45);
		ms.push(-3);
		ms.push(56);
		ms.push(32);
		
		while(ms.IsEmpty() == false) {
			System.out.println(ms.msf[ms.size() - 1]);
			ms.pop();
		}
	}

}

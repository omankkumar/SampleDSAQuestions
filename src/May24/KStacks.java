package May24;

public class KStacks {

	private int cap;
	private int[] da;
	private int[] pa;
	private int[] sha;
	private int fh;

	public KStacks(int k, int cap) {
		this.cap = cap;
		this.da = new int[this.cap];
		this.pa = new int[this.cap];
		this.sha = new int[k];
		this.fh = 0;

		for (int i = 0; i < this.da.length; i++) {
			this.da[i] = 0;
			this.pa[i] = i + 1;
		}
		this.pa[this.pa.length - 1] = -1;

		for (int i = 0; i < this.sha.length; i++) {
			this.sha[i] = -1;
		}
	}

	public boolean IsFull() {
		if (fh == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean IsEmpty(int k) {
		if (this.sha[k] == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int val, int k) {
		if (fh == -1) {
			System.out.println("Stack Overflow");
			return;
		} else {
			int ei = fh;
			
			fh = pa[fh];
			pa[ei] = sha[k];
			sha[k] = ei;
			
			da[ei] = val;
		}
	}

	public int top(int k) {
		if (this.sha[k] == -1) {
			System.out.println("Stack is Empty");
			return -1;
		} else {
			return da[sha[k]];
		}
	}

	public int pop(int k) {
		if (this.sha[k] == -1) {
			System.out.println("Stack is Empty");
			return -1;
		} else {
			int ei = sha[k];
			int val = da[ei];
			
			sha[k] = pa[ei];
			pa[ei] = fh;
			fh = ei;
			
			da[ei] = 0;
			return val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KStacks ks = new KStacks(3, 10);
		ks.push(10, 0);
		ks.push(20, 0);
		ks.push(30, 1);
		ks.push(40, 2);
		ks.push(50, 2);
		ks.push(60, 1);
		ks.push(70, 1);
		ks.push(80, 2);
		ks.push(90, 0);
		ks.push(100, 0);
		ks.push(110, 1);
		
		for(int i = 0; i < 3; i++) {
			while(ks.IsEmpty(i) == false) {
				System.out.print(ks.pop(i) + " ");
			}
			System.out.println();
		}
	}

}

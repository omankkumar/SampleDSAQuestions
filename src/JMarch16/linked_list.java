package JMarch16;

import java.util.*;

public class linked_list {

	private class Node {
		public int data;
		public Node next;
	}

	private Node head; // ek data type banega heap mein, jiska type of node,
	private Node tail; // uska address hoga head and tail mein, which stores
	private int size; // addresses and are created in stack.
	private Node rdrOnleft;
	private Node ltIsPal;

	public linked_list() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
		} else {
			return false;
		}
	}

	public int get_size() {
		return size;
	}

	public void display() {
		Node nxt = head;
		while (nxt != null) {

			System.out.print(nxt.data + " ");
			nxt = nxt.next;
		}
		System.out.println();

	}

	private Node getAt(int idx) {

		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int getfirst() {
		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}
	}

	public int getlast() {
		if (size == 0) {
			return -1;
		} else {
			return tail.data;
		}
	}

	private void handle_zero_size(int data) {

		// allocate new space
		Node nn = new Node();

		// set data and next
		nn.data = data;
		nn.next = null;

		// summerise
		head = nn;
		tail = nn;
		size++;
	}

	public void addfirst(int data) {

		if (size == 0) {
			handle_zero_size(data);
		} else {
			Node nn = new Node();
			nn.data = data;
			nn.next = head;
			head = nn;
			size++;
		}
	}

	public void addAt(int idx, int data) {

		if (idx < 0 && idx > size) {
			return;
		} else if (idx == size) {
			addlast(data);
		} else if (idx == 0) {
			addfirst(data);
		} else {
			Node nm1 = getAt(idx - 1);
			Node n = getAt(idx);
			Node nn = new Node();
			nn.data = data;
			nm1.next = nn;
			nn.next = n;
			size++;
		}

	}

	public void addlast(int data) {

		if (size == 0) {
			handle_zero_size(data);

		} else {

			// allocate new space
			Node nn = new Node();

			// set data and next
			nn.data = data;
			nn.next = null;

			// connect
			tail.next = nn;

			// summarise
			tail = nn;
			size++;
		}

	}

	private void handle_size_one() {
		head = tail = null;
		size--;
	}

	public int removefirst() {

		if (size == 0) {
			return -1;
		} else if (size == 1) {
			int temp = head.data;
			handle_size_one();
			return temp;
		} else {
			int temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
	}

	public int removeAt(int idx) {

		if (idx < 0 && idx >= size) {
			return -1;
		} else if (idx == size - 1) {
			return removelast();
		} else {
			Node nm1 = getAt(idx - 1);
			Node n = getAt(idx);
			Node np1 = getAt(idx + 1);
			int val = n.data;
			nm1.next = np1;
			size--;
			return val;
		}
	}

	public int removelast() {

		if (size == 0) {
			return -1;
		} else if (size == 1) {
			int temp = head.data;
			handle_size_one();
			return temp;
		} else {
			Node sl = getAt(size - 2);
			Node l = getAt(size - 1);
			sl.next = null;
			int val = l.data;
			tail = sl;
			size--;
			return val;
		}
	}

	public void rdi() {

		int l = 0;
		int r = size - 1;

		while (l <= r) {
			Node ln = getAt(l);
			Node rn = getAt(r);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			l++;
			r--;
		}
	}

	public void rpi() {

		Node pn = null;
		Node cn = head;
		Node nn = head.next;
		while (cn != null) {
			cn.next = pn;
			pn = cn;
			cn = nn;
			if (nn == null) {
				break;
			}
			nn = nn.next;
		}

		Node temp = head;
		head = tail;
		tail = temp;

	}

	private void DisplayReverse(Node n) {
		if (n == null) {
			return;
		}
		DisplayReverse(n.next);
		System.out.print(n.data + "<-");
	}

	public void DisplayReverse() {
		DisplayReverse(head);
		System.out.println();
	}

	private void rpr(Node pn) {

		if (pn.next == null) {
			return;
		}
		rpr(pn.next);
		pn.next.next = pn;
	}

	public void rpr() {

		rpr(head);
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private void rdrOn2(Node n, int cnt) {
		if (cnt == size / 2) {
			return;
		}
		Node r = getAt(size - 1 - cnt);
		int temp = n.data;
		n.data = r.data;
		r.data = temp;
		rdrOn2(n.next, cnt + 1);
	}

	public void rdrOn2() {
		rdrOn2(head, 0);
	}

	private void rdrOn(Node right, int floor) {
		if (right == null) {
			return;
		}
		rdrOn(right.next, floor + 1);

		if (floor >= size / 2) {
			int temp = right.data;
			right.data = rdrOnleft.data;
			rdrOnleft.data = temp;
		}
		rdrOnleft = rdrOnleft.next;
	}

	public void rdrOn() {
		rdrOnleft = head;
		rdrOn(head, 0);
	}

	private boolean IsPal(Node rt, int floor) {
		if (rt == null) {
			return true;
		}
		boolean check = IsPal(rt.next, floor + 1);
		if(floor >= size/2) {
			if (check == true) {
				if (rt.data != ltIsPal.data) {
					return false;
				} else {
					ltIsPal = ltIsPal.next;
					return true;
				}
			} else {
				return false;
			}
		} else {
			return check;
		}
		
	}

	public boolean IsPal() {
		ltIsPal = head;
		boolean check = IsPal(head, 0);
		return check;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		linked_list l1;
		l1 = new linked_list();

		l1.addlast(30);
		l1.addlast(20);
		l1.addlast(10);
		// l1.display();

		l1.addfirst(20);
		l1.addfirst(10);
		l1.display();

		 l1.addAt(3, 100);
		 l1.display();

		 l1.removefirst();
		 l1.removefirst();
		 l1.display();
		
		 l1.removelast();
		 l1.display();
		
		 l1.addlast(200);
		 l1.display();
		
		 l1.removeAt(2);
		 l1.display();

		// l1.rdi();
		// l1.display();
		// l1.rpi();
		// l1.display();

		// l1.DisplayReverse();

		// l1.rpr();
		// l1.display();
		//
		// l1.rdrOn();
		// l1.display();

		System.out.println(l1.IsPal());

	}
}

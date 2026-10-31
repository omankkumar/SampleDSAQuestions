package JMarch18practice;

import java.util.ArrayList;

import JMarch16.linked_list;

public class LinkedList {

	public class Node {
		public int data;
		public Node next;
	}

	private Node head;
	private Node tail;
	private int size;
	private Node templt;

	public boolean IsEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return size;
	}

	public void Display() {

		Node nn = head;
		while (nn != null) {
			System.out.print(nn.data + " ");
			nn = nn.next;
		}
		System.out.println();
	}

	private Node getNodeAt(int idx) {

		Node nn = head;
		for (int i = 0; i < idx; i++) {
			nn = nn.next;
		}
		return nn;
	}

	public int getFirst() {

		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}
	}

	public int getLast() {

		if (size == 0) {
			return -1;
		} else {
			return tail.data;
		}
	}

	private void handle_add_when_size_zero(int data) {

		Node nn = new Node();
		nn.data = data;
		nn.next = null;
		head = nn;
		tail = nn;
		size++;
	}

	public void addLast(int data) {
		if (size == 0) {
			handle_add_when_size_zero(data);
		} else {
			Node nn = new Node();
			nn.data = data;
			nn.next = null;
			tail.next = nn;
			tail = nn;
			size++;
		}
	}

	public void addFirst(int data) {
		if (size == 0) {
			handle_add_when_size_zero(data);
		} else {
			Node nn = new Node();
			nn.data = data;
			nn.next = head;
			head = nn;
			size++;
		}
	}

	public void addAt(int idx, int data) {
		if (idx < 0 || idx > size) {
			System.out.println("Invalid Node Index");
			return;
		} else if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = getNodeAt(idx);

			Node nn = new Node();
			nn.data = data;
			nn.next = n;
			nm1.next = nn;
			size++;
		}
	}

	private void handle_remove_when_size_one() {
		head = null;
		tail = null;
		size--;
	}

	public int removeFirst() {
		if (size == 0) {
			System.out.println("Invalid Operation, List is already Empty");
			return -1;
		} else if (size == 1) {
			int val = head.data;
			handle_remove_when_size_one();
			return val;
		} else {
			int val = head.data;
			head = head.next;
			size--;
			return val;
		}
	}

	public int removeLast() {
		if (size == 0) {
			System.out.println("Invalid Operation, List is already Empty");
			return -1;
		} else if (size == 1) {
			int val = head.data;
			handle_remove_when_size_one();
			return val;
		} else {
			Node sl = getNodeAt(size - 2);
			int val = sl.next.data;
			sl.next = null;
			tail = sl;
			size--;
			return val;
		}
	}

	public int removeAt(int idx) {
		if (idx < 0 && idx >= size) {
			System.out.println("Invalid List Index");
			return -1;
		} else if (idx == 0) {
			int val = removeFirst();
			return val;
		} else if (idx == size - 1) {
			int val = removeLast();
			return val;
		} else {
			Node nm1 = getNodeAt(idx - 1);
			int val = nm1.next.data;
			nm1.next = nm1.next.next;
			size--;
			return val;
		}
	}

	public void rdi() {

		int l = 0;
		int r = size - 1;
		while (l <= r) {
			Node ln = getNodeAt(l);
			Node rn = getNodeAt(r);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			l++;
			r--;
		}
	}

	public void rpi() {

		Node p = null;
		Node c = head;
		Node n = head.next;
		while (c != null) {
			c.next = p;
			p = c;
			c = n;
			if (n == null) {
				break;
			}
			n = n.next;
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private void DisRev(Node n) {
		if (n == null) {
			return;
		}
		DisRev(n.next);
		System.out.print(n.data + " ");
	}

	public void DisplayReverse() {
		DisRev(head);
		System.out.println();
	}

	private void rpr(Node n) {
		if (n.next == null) {
			return;
		}
		rpr(n.next);
		n.next.next = n;
	}

	public void rpr() {
		rpr(head);
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private void rdr(Node rt, int floor) {
		if (rt == null) {
			return;
		}
		rdr(rt.next, floor + 1);

		if (floor >= size / 2) {
			int temp = rt.data;
			rt.data = templt.data;
			templt.data = temp;

			templt = templt.next;
		}

	}

	public void rdr() {
		templt = head;
		rdr(head, 0);
	}

	private boolean IsPal(Node rt, int floor) {
		if (rt == null) {
			return true;
		}

		boolean check = IsPal(rt.next, floor + 1);
		// if (floor >= size / 2) {
		if (check == false) {
			return false;
		} else {
			if (rt.data != templt.data) {
				return false;
			} else {
				templt = templt.next;
				return true;
			}
		}
		// } else {
		// return check;
		// }

	}

	public boolean IsPal() {
		templt = head;
		boolean check = IsPal(head, 0);
		return check;
	}

	private void fold(Node rt, int floor) {
		if (rt == null) {
			return;
		}

		fold(rt.next, floor + 1);
		if (floor > size / 2) {
			rt.next = templt.next;
			templt.next = rt;
			templt = templt.next.next;
		} else if (floor == size / 2) {
			tail = rt;
			tail.next = null;
		}
	}

	public void fold() {
		templt = head;
		fold(head, 0);
	}

	private void unfold(Node left) {
		if (left.next == null) {
			head = left;
			tail = left;
			return;
		} else if (left.next.next == null) {
			head = left;
			tail = left.next;
			return;
		}

		Node right = left.next;
		unfold(left.next.next);

		left.next = head;
		tail.next = right;
		head = left;
		tail = right;
		tail.next = null;
	}

	public void unfold() {
		unfold(head);
	}

	private void addFirstNode(Node nn) {
		if (size == 0) {
			head = tail = nn;
			size++;
		} else {
			nn.next = head;
			head = nn;
			size++;
		}
	}

	private Node removeFirstNode() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node temp = head;
			head = tail = null;
			size--;
			return temp;
		} else {
			Node temp = head;
			head = head.next;
			size--;
			temp.next = null;
			return temp;
		}
	}

	public void kreverse(int k) {

		LinkedList prev = new LinkedList();

		while (this.size != 0) {

			LinkedList curr = new LinkedList();

			for (int i = 0; i < k && this.size > 0; i++) {
				// curr.addFirst(this.removeFirst());
				curr.addFirstNode(this.removeFirstNode());
			}

			if (prev.size == 0) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size = prev.size + curr.size;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	public void addLastNode(Node nn) {
		if (size == 0) {
			head = tail = nn;
			size++;
		} else {
			tail.next = nn;
			tail = nn;
			nn.next = null;
			size++;
		}
	}

	public void oddeven() {
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();

		while (this.size != 0) {
			Node temp = this.removeFirstNode();
			if (temp.data % 2 == 0) {
				even.addLastNode(temp);
			} else {
				odd.addLastNode(temp);
			}
		}

		if (odd.size == 0) {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		} else if (even.size == 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			even.tail.next = odd.head;
			this.head = even.head;
			this.tail = odd.tail;
			this.size = even.size + odd.size;
		}
	}

	public void removeDuplicates() {

		LinkedList nl = new LinkedList();
		while (this.size != 0) {
			Node temp = removeFirstNode();
			if (nl.size == 0 || nl.tail.data != temp.data) {
				nl.addLastNode(temp);
			}
		}
		head = nl.head;
		tail = nl.tail;
		size = nl.size;
	}

	public void merge_two_lists(LinkedList l1, LinkedList l2) {

		while (l1.head != null && l2.head != null) {
			if (l1.head.data >= l2.head.data) {
				Node temp = l2.removeFirstNode();
				this.addLastNode(temp);
			} else {
				Node temp = l1.removeFirstNode();
				this.addLastNode(temp);
			}
		}
		while (l1.head != null) {
			Node temp = l1.removeFirstNode();
			this.addLastNode(temp);
		}
		while (l2.head != null) {
			Node temp = l2.removeFirstNode();
			this.addLastNode(temp);
		}
	}

	public int kthfromlast(int k) {
		Node f = head;
		Node s = head;
		while (k != 0) {
			f = f.next;
			k--;
		}

		while (f != null) {
			f = f.next;
			s = s.next;
		}

		return s.data;
	}

	private Node midNode(Node sp, Node ep) {
		Node fast = sp;
		Node slow = sp;
		while (fast != ep && fast.next != ep) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public int midElement() {
		Node mid = midNode(head, tail);
		return mid.data;
	}

	public void MergeTwoLists(LinkedList l1, LinkedList l2) {

		Node n1 = l1.head;
		Node n2 = l2.head;
		while (n1 != null && n2 != null) {
			if (n1.data >= n2.data) {
				this.addLast(n2.data);
				n2 = n2.next;
			} else {
				this.addLast(n1.data);
				n1 = n1.next;
			}
		}
		while (n1 != null) {
			this.addLast(n1.data);
			n1 = n1.next;
		}
		while (n2 != null) {
			this.addLast(n2.data);
			n2 = n2.next;
		}
	}

	private LinkedList MergeSort(Node sp, Node ep) {

		if (sp == ep) {
			LinkedList bl = new LinkedList();
			bl.addFirst(sp.data);
			return bl;
		}

		Node mid = this.midNode(sp, ep);
		Node midp1 = mid.next;
		mid.next = null;

		LinkedList sl1 = MergeSort(sp, mid);
		LinkedList sl2 = MergeSort(midp1, ep);

		LinkedList sl = new LinkedList();
		sl.MergeTwoLists(sl1, sl2);
		return sl;
	}

	public LinkedList MergeSort() {
		LinkedList sl = MergeSort(this.head, this.tail);
		return sl;
	}

	private int add(Node n1, Node n2, int s1, int s2, LinkedList res) {

		if (s1 == 0 && s2 == 0) {
			return 0;
		}

		int num1 = 0;
		int num2 = 0;

		if (s1 == s2) {
			num1 = n1.data;
			num2 = n2.data;
			int pcarry = add(n1.next, n2.next, s1 - 1, s2 - 1, res);
			int sum = num1 + num2 + pcarry;
			int val = sum % 10;
			int carry = sum / 10;
			res.addFirst(val);
			return carry;
		} else if (s1 > s2) {
			num1 = n1.data;
			int pcarry = add(n1.next, n2, s1 - 1, s2, res);
			int sum = num1 + num2 + pcarry;
			int val = sum % 10;
			int carry = sum / 10;
			res.addFirst(val);
			return carry;
		} else {
			num2 = n2.data;
			int pcarry = add(n1, n2.next, s1, s2 - 1, res);
			int sum = num1 + num2 + pcarry;
			int val = sum % 10;
			int carry = sum / 10;
			res.addFirst(val);
			return carry;
		}
	}

	public LinkedList add(LinkedList l1, LinkedList l2) {
		LinkedList sum = new LinkedList();
		int carry = add(l1.head, l2.head, l1.size, l2.size, sum);
		if (carry > 0) {
			sum.addFirst(carry);
		}
		return sum;
	}

	private int mult(Node n1, Node n2, Node n1h, LinkedList temp, LinkedList res, int size, int floor) {

		if ((n1 != null) && (n2 != null) && (n1.next == null) && (n2.next == null)) {
			int prod = (n1.data * n2.data);
			int val = prod % 10;
			int carry = prod / 10;
			temp.addFirst(val);
			return carry;
		}

		int pcarry = 0; // previous carry

		if (n1 == null) { // if 1st list reaches end

			pcarry = mult(n1h, n2.next, n1h, temp, res, size, floor + 1);

			if (pcarry > 0) {
				temp.addFirst(pcarry);
			}

			int n = size - floor - 1;
			while (n > 0) { // accomodate zeroes
				temp.addLast(0);
				n--;
			}

			LinkedList nl = new LinkedList();
			nl = nl.add(res, temp); // add temp and res
			res.head = nl.head; // update res
			res.tail = nl.tail;
			res.size = nl.size;
			temp.head = null; // update temp
			temp.tail = null;
			temp.size = 0;
			return 0;
		}
		// if neither of the list is at end
		pcarry = mult(n1.next, n2, n1h, temp, res, size, floor);

		int prod = (n1.data * n2.data) + pcarry;
		int val = prod % 10;
		int carry = prod / 10;
		temp.addFirst(val);
		return carry;
	}

	public void multiply(LinkedList l1, LinkedList l2) {
		LinkedList product = new LinkedList();
		LinkedList temp = new LinkedList();
		// performing lowest level operations
		// floor = 1 in start as lowest level operations are performed here
		int carry = mult(l1.head, l2.head, l1.head, temp, product, l2.size, 1);
		if (carry > 0) {
			temp.addFirst(carry);
		}
		int n = (l2.size - 1);
		while (n != 0) {
			temp.addLast(0);
			n--;
		}
		LinkedList nl = new LinkedList();
		nl = nl.add(temp, product);
		this.head = nl.head; // updating this
		this.tail = nl.tail;
		this.size = nl.size;

	}

	public static void main(String[] args) {

		LinkedList l1;
		l1 = new LinkedList();

//		LinkedList l2 = new LinkedList();
//
//		l1.addLast(1);
//		l1.addLast(2);
//		l1.addLast(3);
//
//		l2.addLast(9);
//		l2.addLast(1);
//		l2.addLast(0);
//
//		LinkedList l4 = new LinkedList();
//		l4.multiply(l1, l2);
//
//		l1.Display();
//		l2.Display();
//		l4.Display();
		
		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		l1.addLast(40);
		l1.addLast(50);
		l1.addLast(60);
		l1.addLast(70);
		l1.Display();
		
		l1.fold();
		l1.Display();
	
	}

}

package JMarch23;

public class Node {
	
	public int data;
	public Node next;

	public static Node darloop(Node n) {
		Node slow = n;
		Node fast = n;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return fast;
			}
		}
		return null;
	}
	
	public static void rloop(Node slow, Node fast) {
		Node prev = fast;
		while(fast != slow) {
			prev = fast;
			fast = fast.next;
			slow = slow.next;
		}
//		if(slow == fast) {
//			fast.next = null;
//		}
		System.out.println("Intersecting point data is " + fast.data);
		prev.next = null;
	}
	
	public static void Display(Node nn) {

		while (nn != null) {
			System.out.print(nn.data + " ");
			nn = nn.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();
		Node n8 = new Node();
		Node n9 = new Node();
		Node n10 = new Node();
		
		n1.data = 1;
		n2.data = 2;
		n3.data = 3;
		n4.data = 4;
		n5.data = 5;
		n6.data = 6;
		n7.data = 7;
		n8.data = 8;
		n9.data = 9;
		n10.data = 10;
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n1;
		
//		int s1 = 0;
//		int s2 = 0;
		
//		while(n1 != null) {
//			n1 = n1.next;
//			s1++;
//		}
		
		Node knode = darloop(n1);
//		System.out.println(knode);
		rloop(n1, knode);
		Display(n1);
	}

}

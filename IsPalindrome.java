class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
		int length = 0;
		ListNode tail = null;
		for(ListNode q = head;q != null;q = q.next){						// finds length + tail of ListNode
			length++;
			tail = q;
		}
		int count = 0;
		for(ListNode p = head; p != null;p = p.next,++count){				// reverses half of the list
			if(count == (length/2)) reverseList(p);
		}
		return areListsEqual(head,tail);									// check if both lists are =
	}
	public ListNode reverseList(ListNode head) {							// reversing a singly-linked list
		if (head == null) return head;
		ListNode curr = head, after = null, before = null;
		while(curr != null){
			after     = curr.next;
			curr.next = before;
			before    = curr;
			curr      = after;
		}
		return before;
	}
	public boolean areListsEqual(ListNode head, ListNode tail){				// check if both lists are =
		for(ListNode p =  head, q = tail; p != null && q != null; p = p.next,q = q.next){
			if(p.val != q.val) return false;
		}
		return true;
	}
	public class ListNode {													// Definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; prev.next = this; }
	}

	// ----------- TESTING ------------
	public ListNode makeList(int vals[]){									// ListNode = [1 2 3 4 5 6] 
		ListNode head = null, tail = null;
		for(int i : vals) if(head == null) head = tail =  new ListNode(i);
			else tail = tail.next = new ListNode(i,head);
		return head;
	}
	
	public String print(final ListNode head){								// printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
	public static void test0(){												// empty ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = null;
		assert(s.isPalindrome(head));
	}
	public static void test1(){												// one ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1});
		assert(s.isPalindrome(head));
	}
	public static void test2a(){											// two ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,1});
		assert(s.isPalindrome(head));
	}
	public static void test2b(){											// two ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2});
		assert(!s.isPalindrome(head));
	}
	public static void test3a(){											// three ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,3});
		assert(!s.isPalindrome(head));
	}
	public static void test3b(){											// three ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,1});
		assert(s.isPalindrome(head));
	}
	public static void test4a(){											// four ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,2,1});
		assert(s.isPalindrome(head));
	}
	public static void test4b(){											// four ListNode test
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,1,2});
		assert(!s.isPalindrome(head));
	}
	public static void main(String[] args){									// main test for linked list
		test0();
		test1();
		test2a();
		test2b();
		test3a();
		test3b();
		test4a();
		test4b();
	}
}

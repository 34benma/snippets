class CircularList {
	
	public int circularListLength(CLLNode headNode) {
		int length = 0;
		CLLNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
			if (currentNode == headNode) {
				break;
			}
		}
		return length;
	}
	
	public void delLastNodeFromCLL(CLLNode headNode) {
		CLLNode temp = headNode;
		CLLNode currentNode = headNode;
		if (headNode == null) {
			System.out.println("Empty List");
			return;
		}
		while (currentNode.getNext() != headNode) {
			temp = currentNode;
			currentNode = currentNode.getNext();
		}
		temp.setNext(headNode);
		currentNode = null;
		return;
	}
	
	public String toString(ListNode headNode) {
		ListNode currentNode = headNode;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(currentNode != null) {
			sb.append(currentNode.getData()).append("->");
			currentNode = currentNode.getNext();
			if (currentNode == headNode) {
				break;
			}
		}
		sb.replace(sb.length()-2, sb.length(), "]");
		return sb.toString();
	}
	
	class CLLNode {
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
		
		public void setData() {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		
		public void setNext(ListNode next) {
			this.next = next;
		}
		
		public ListNode getNext() {
			return next;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
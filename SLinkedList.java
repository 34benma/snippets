/**
 * 单链表的一种实现
**/
public class SLinkedList {
	/**
	 * 获取单链表长度
	 * @Param headNode 头结点 可以为null  
	 * @Return 链表长度
	 **/
	public int getLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	public ListNode insertNewNode(ListNode headNode, ListNode nodeToInsert, int position) {
		if (headNode == null) {
			return nodeToInsert;
		}
		
		int size = getLength(headNode);
		
		if (position > size+1 || position < 1) {
			System.out.println("链表插入位置不存在,链表长度"+ size + ",待插入位置" + position);
			return headNode;
		}
		
		if (position == 1) {
			//头部插入
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {
			//中间或尾部插入
			ListNode previousNode = headNode;
			int currentPosition = 1;
			while(currentPosition < position - 1) {
				previousNode = previousNode.getNext();
				currentPosition++;
			}
			//找到待插入的位置后
			nodeToInsert.setNext(previousNode.getNext());
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}
	
	public ListNode delNode(ListNode headNode, int position) {
		int size = getLength(headNode);
		if (position > size+1 || position < 1) {
			System.out.println("位置参数错误,链表长度为"+ size + ",待删除的位置为" + position);
			return headNode;
		}
		
		if (position == 1) {
			//删除头结点
			headNode = headNode.getNext();
			return headNode;
		} else {
			//删除中间结点或尾结点
			ListNode currentNode = headNode;
			int currentPosition = 1;
			while(currentPosition < position-1) { 
				currentNode = currentNode.getNext();
				currentPosition++;
			}
			//找到待删除的结点的前一个结点
			currentNode.setNext(currentNode.getNext().getNext());
		}
		return headNode;
	}
	
	public void delSList(ListNode headNode) {
		ListNode needToDelNode = headNode;
		ListNode currentNode = headNode;
		while(currentNode != null) {
			needToDelNode = null;
			currentNode = currentNode.getNext();
			needToDelNode = currentNode;
		}
	}
	
	public ListNode buildLinkedListFromArray(int[] array) {
		ListNode headNode = null;
		if (array.length > 0) {
			headNode = new ListNode(array[0]);
			for (int i = 1; i < array.length; i++) {
				insertNewNode(headNode, new ListNode(array[i]), i+1);
			}
		}
		return headNode;
	}
	
	public String toString(ListNode headNode) {
		ListNode currentNode = headNode;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(currentNode != null) {
			sb.append(currentNode.getData()).append("->");
			currentNode = currentNode.getNext();
		}
		sb.replace(sb.length()-2, sb.length(), "]");
		return sb.toString();
	}
	
	class ListNode {
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
		//创建链表 [1->3->5->10->6->7->2->8]
		SLinkedList list = new SLinkedList();
		SLinkedList.ListNode headNode = list.buildLinkedListFromArray(new int[] {1,3,5,10,6,7,2,8});
		System.out.println(list.toString(headNode));//[1->3->5->10->6->7->2->8]
		//删除头结点
		headNode = list.delNode(headNode, 1);
		System.out.println(list.toString(headNode)); //[3->5->10->6->7->2->8]
		//删除10(index = 3)
		headNode = list.delNode(headNode, 3); //[3->5->6->7->2->8]
		System.out.println(list.toString(headNode));
		headNode = list.insertNewNode(headNode, list.new ListNode(7), 3); //[3->5->7->6->7->2->8]
		System.out.print(list.toString(headNode));
		
	}
}
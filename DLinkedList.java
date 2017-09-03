/**
 * 双向链表的一种实现
 **/
class DLinkedList {
	public int getLength(DLLNode headNode) {
		if (headNode == null) {
			return 0;
		}
		DLLNode currentNode = headNode;
		int length = 0;
		while(currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	
	public DLLNode insertNewNode(DLLNode headNode, DLLNode needToInsert, int position) {
		int size = getLength(headNode);
		
		if (position > size + 1 || position < 1) {
			System.out.println("链表插入位置不存在,链表长度"+ size + ",待插入位置" + position);
			return headNode;
		}
		
		if (headNode == null) {
			return needToInsert;
		}
		
		if (position == 1) {
			//插入头结点
			needToInsert.setNext(headNode);
			headNode.setPrevious(needToInsert);
			return needToInsert;
		} else {
			DLLNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}
			DLLNode currentNode = previousNode.getNext();
			needToInsert.setNext(currentNode);
			needToInsert.setPrevious(previousNode);
			if (currentNode != null) {
				//不是尾结点
				currentNode.setPrevious(needToInsert);
			}
			previousNode.setNext(needToInsert);
		}
		return headNode;
	}
	
	public DLLNode delNode(DLLNode headNode, int position) {
		int size = getLength(headNode);
		
		if (size == 0) {
			return null;
		}
		
		if (position > size + 1 || position < 1) {
			System.out.println("链表删除位置不存在,链表长度"+ size + ",待删除位置" + position);
			return headNode;
		}
		
		if (position == 1) {
			DLLNode currentNode = headNode;
			currentNode = headNode.getNext();
			currentNode.setPrevious(null);
			return currentNode;
		} else {
			DLLNode previous = headNode;
			int count = 1;
			while (count < position - 1) {
				count++;
				previous = previous.getNext();
			}
			DLLNode currentNode = previous.getNext().getNext();
			if (currentNode != null) {
				currentNode.setPrevious(previous);
				previous.setNext(currentNode);
			} else {
				previous.setNext(null);
			}
		}
		return headNode;
	}
	
	public void delList(DLLNode headNode) {
		DLLNode currentNode = headNode;
		DLLNode needToDelNode = headNode;
		while (currentNode != null) {
			needToDelNode = null;
			currentNode = currentNode.getNext();
			needToDelNode = currentNode;
		}
	}
	
	public DLLNode builderDLLinkedListFromArray(int[] array) {
		DLLNode headNode = null;
		if (array.length > 0) {
			headNode = new DLLNode(array[0]);
			for (int i = 1; i < array.length; i++) {
				insertNewNode(headNode, new DLLNode(array[i]), i);
			}
		}
		return headNode;
	} 
	
	public String toString(DLLNode headNode) {
		DLLNode currentNode = headNode;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(currentNode != null) {
			sb.append(currentNode.getData()).append("->");
			currentNode = currentNode.getNext();
		}
		sb.replace(sb.length()-2, sb.length(), "]");
		return sb.toString();
	}
	
	class DLLNode {
		private int data;
		private DLLNode next;
		private DLLNode previous;
		
		public DLLNode(int data) {
			this.data = data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
		
		public int getData() {
			return this.data;
		}
		
		public void setNext(DLLNode next) {
			this.next = next;
		}
		
		public DLLNode getNext() {
			return this.next;
		}
		
		public void setPrevious(DLLNode previous) {
			this.previous = previous;
		}
		
		public DLLNode getPrevious() {
			return previous;
		}
	}

	public static void main(String[] args) {
		//创建链表 [1->3->5->10->6->7->2->8]
		DLinkedList list = new DLinkedList();
		DLinkedList.DLLNode headNode = list.builderDLLinkedListFromArray(new int[] {1,3,5,10,6,7,2,8});
		System.out.println(list.toString(headNode));//[1->3->5->10->6->7->2->8]
		//删除头结点
		headNode = list.delNode(headNode, 1);
		System.out.println(list.toString(headNode)); //[3->5->10->6->7->2->8]
		//删除10(index = 3)
		headNode = list.delNode(headNode, 3); //[3->5->6->7->2->8]
		System.out.println(list.toString(headNode));
		headNode = list.insertNewNode(headNode, list.new DLLNode(7), 3); //[3->5->7->6->7->2->8]
		System.out.print(list.toString(headNode));
		
	}
}
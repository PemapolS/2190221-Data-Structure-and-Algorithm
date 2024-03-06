
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		//fill code 
		if (p == null || !(p instanceof DListIterator)) {
			return;
		}
		else if (size == 0 || size == 1) {
			super.insert(value, p);
		} else {
			super.insert(value, p);
			if (((DListIterator) p).currentNode != header) {
				DListIterator left = (DListIterator) p;
				left.next();
				DListIterator right = new DListIterator(((DListIterator) p).currentNode);
				
				while (left.currentNode.data == right.currentNode.data) {
					if (left.currentNode.data == header.data) {
						left.currentNode = right.currentNode;
					} else {
						right.currentNode = left.currentNode;
					}
					int repeatedValues = -1;
					while (left.currentNode.data == value) {
						left.previous();
						repeatedValues++;
					}
					while (right.currentNode.data == value) {
						right.next();
						repeatedValues++;
					}
					if (repeatedValues >= 3) {
						this.removeBetween(left, right, repeatedValues);
						score += repeatedValues;
						value = left.currentNode.data;
					} else {
						return;
					}
				}
			}
		}
		

	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code
		if (left.currentNode == right.currentNode || left.currentNode.nextNode == right.currentNode) {
			return;
		}
		left.currentNode.nextNode = right.currentNode;
		right.currentNode.previousNode = left.currentNode;
		
		size -= inc;
	}

}

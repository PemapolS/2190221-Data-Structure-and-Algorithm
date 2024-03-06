import java.util.ArrayList;

public class BSTList {
	BSTNodeList root;
	int size;
	
	public BSTList() {
		root = null;
		size = 0;
	}
	
	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}
	
	public BSTNodeList find(Comparable v) { 
		BSTNodeList temp = root;
		Pairdata x = (Pairdata) v;
		while (temp != null && x.compareTo(temp.dataList.get(0)) != 0) {
			if (x.compareTo(temp.dataList.get(0)) < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		
		for (Pairdata i : temp.dataList) {
			if (i.equals(x)) return temp;
		}
		
		return null;
	}
	
	public BSTNodeList insert(Comparable v) {
		Pairdata x = (Pairdata) v;
		if (find(x) != null) {
			BSTNodeList l = find(x);
			for (Pairdata i : l.dataList) {
				if (i.equals(x)) return l;
			}
			l.dataList.add(x);
			return l;
		} else {
			BSTNodeList parent = null;
			BSTNodeList temp = root;

			while (temp != null && x.compareTo(temp.dataList.get(0)) != 0) {
				if (x.compareTo(temp.dataList.get(0)) < 0) {
					parent = temp;
					temp = temp.left;
				} else {
					parent = temp;
					temp = temp.right;
				}
			}
			ArrayList<Pairdata> a = new ArrayList<Pairdata>();
			a.add(x);
			BSTNodeList n = new BSTNodeList(a, null, null, parent);
			if (parent == null) {
				root = n;
			} else if (x.compareTo(parent.dataList.get(0)) < 0) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return n;
			
		}

	}
	
	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	

	
}

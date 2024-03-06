
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		double n = 0;
		for (DeQ i : counters) {
			n += i.size();
		}
		int nql = (int) Math.round(n/(counters.length+1));
		boolean alreadyAllCorrect = true;
		for (int i = 0; i < counters.length; i++) {
			if (counters[i].size() > nql) {
				alreadyAllCorrect = false;
			}
		}
		if (alreadyAllCorrect) {
			special.insertLast(counters[counters.length - 1].removeLast());
			return;
		}
		int quota = nql;
		int arrayControl = nql;
		for (int i = 0; i < quota; i++) {
//			System.out.println("INDEX" + i);
//			System.out.println("Q" + quota);
			int[] tempA = new int[counters[(i % counters.length)].size() - arrayControl];
//			System.out.println(tempA.length);
			if (tempA.length == 0) quota++;
			for (int c = 0; c < tempA.length; c++) {
				tempA[c] = counters[(i % counters.length)].removeLast();
//				System.out.println(tempA[c]);
			}
			if (tempA.length > 0) {
				if (quota - i >= 2 && tempA.length == 2) {
					special.insertLast(tempA[tempA.length-1]);
					special.insertLast(tempA[tempA.length-2]);
					quota--;
				} else {			
					special.insertLast(tempA[tempA.length-1]);
					if (tempA.length == 2) counters[(i % counters.length)].insertLast(tempA[0]);
				}
			}
		}
		
		
	}

}

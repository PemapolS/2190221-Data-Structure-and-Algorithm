
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		MyStack s3 = new StackArray((int) Math.floor(s1.size()/2));
		int size = (int) Math.floor(s1.size()/2);
		for (int i = 0; i < size; i++) {
			int n1 = s1.top();
			s1.pop();
			int n2 = s1.top();
			s1.pop();
			if (s2.top() < 0) {
				s3.push(n1 - n2);
			} else {
				s3.push(n1 + n2);
			}
			s2.pop();
		}
		String result = "";
		for (int i = 0; i < size; i++) {
			result += Character.toString(alphabets.charAt(s3.top()));
			s3.pop();
		}
		
		return result;
	}
}

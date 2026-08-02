class Solution {
	public boolean isBalanced(String s) {
		// code here
		Stack<Character> st = new Stack<>();
		
		for (char ch : s.toCharArray()) {
			
			// Opening bracket
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			}
			
			// Closing bracket
			else {
				
				// Stack khali
				if (st.isEmpty())
					return false;
				
				// Top bracket
				char top = st.peek();
				
				// Matching
				if ((ch == ')' && top == '(') ||
				(ch == '}' && top == '{') ||
				(ch == ']' && top == '[')) {
					st.pop();
				}
				else {
					return false;
				}
			}
		}
		
		// Sab match hue?
		return st.isEmpty();
	}
}

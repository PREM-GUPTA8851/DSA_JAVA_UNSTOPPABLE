class Solution {
	public boolean isBalanced(String s) {
		// [{()}]
		// odd length wale to pehle hi false ho jaenge
		Stack<Character> st = new Stack<>();
		// logic is stack use kiya jae aur usme
		for (int i = 0; i < s.length(); i++) {
			// sb push kiya jae open bracket k case me
			char current = s.charAt(i); // [
			if (!st.isEmpty() && (
			(st.peek() == '[' && current == ']') ||
			(st.peek() == '{' && current == '}') ||
			(st.peek() == '(' && current == ')'))) {
				st.pop();
				
				// aur jb close bracket mila tb aapn
				// stack k top check krenge
				// if stack k top us similar bracket k open
				// side mila tb stack ko pop kr denge
			}
			else {	// sb push kiya jae open bracket k case me
				st.push(current); //
			}
		}
		// at the end stack empty mila to fhr
		// true return krenge
		// otherwise false return krenge
		if (st.isEmpty()) {
			return true;
		}
		return false;
		
	}
	
}

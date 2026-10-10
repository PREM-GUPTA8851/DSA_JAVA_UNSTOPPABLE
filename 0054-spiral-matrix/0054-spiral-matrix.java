class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
		int starting_column = 0;
		int starting_row = 0;
		int ending_column = mat[0].length -1; // 3
		int ending_row = mat.length -1; //3
		
		int total_elements = mat[0].length * mat.length;
		int count =0;
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(count < total_elements){
		// pehle starting column --> ending column
		for(int i = starting_column; i <= ending_column && count < total_elements; i++){
		    ans.add(mat[starting_row][i]);// 1,2,3,4 // 13,14
		    count++;
		}
		starting_row++;//1
		
		// starting row --> ending row
		for(int i = starting_row; i <= ending_row && count < total_elements; i++){
		    ans.add(mat[i][ending_column]);// 5,6,7
		    count++;
		}
		ending_column--;
		// ending column --> starting column
		for(int i = ending_column; i >= starting_column && count < total_elements; i--){
		    ans.add(mat[ending_row][i]); //8,9,10
		    count++;
		}
		ending_row--;
		// ending row --> starting row
		for(int i = ending_row; i >= starting_row && count < total_elements; i--){
		    ans.add(mat[i][starting_column]); // 11,12
		    count++;
		}
		starting_column++;
		}
		return ans;
	}
}
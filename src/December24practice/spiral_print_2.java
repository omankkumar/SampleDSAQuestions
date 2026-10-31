package December24practice;

public class spiral_print_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat= {{1,2,3},{5,6,7},{9,10,11},{13,14,15},{16,17,18}};
		int l=0,r=mat[0].length-1,t=0,b=mat.length-1;
		
		
		while(t<=b && l<=r){
			for(int i=t;i<=b;i++){
				System.out.print(mat[i][l] + " ");				
			}			
			
			for(int j=l+1;j<=r;j++){
				System.out.print(mat[b][j] + " ");				
			}
			
			if(l!=r){
				for(int i=b-1;i>=t;i--){
					System.out.print(mat[i][r] + " ");				
				}
			}
			if(t!=b){				
				for(int j=r-1;j>l;j--){
					System.out.print(mat[t][j] + " ");				
				}	
			}
			t++;
			r--;
			b--;
			l++;
			
		}

	}

}

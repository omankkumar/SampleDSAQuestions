package December21practice;

public class subsets_of_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int n =0;
		while(n<arr.length){
		for(int i = n; i< arr.length;i++)
		{
			for(int j = n; j<=i;j++)
			{
				System.out.print(arr[j]);
			}
			System.out.println();
		}
		System.out.println();
		n++;}

	}

}

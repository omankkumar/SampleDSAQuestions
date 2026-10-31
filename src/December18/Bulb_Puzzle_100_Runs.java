package December18;

public class Bulb_Puzzle_100_Runs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Answer - only bulbs with perfect squares will keep glowing
		// toggle bulbs at every run
		// run1 1 2 3 4 5  
		// run2 2 4 6 8 10
		// run3 3 6 9 12 15
		
		int n =100;
		System.out.print("On Bulb Number would be ");
		for(int i = 1; i*i<=n; i++)//loop runs only 10 times while checks for every number
		{
			System.out.print(i*i + " ");
		}
		

	}

}

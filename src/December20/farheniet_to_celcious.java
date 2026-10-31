package December20;

public class farheniet_to_celcious {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//celsius = (5/9)*(far-32)
		
		int sr = 0;
		int er = 300;
		
		for(int i = sr; i<=er; i = i+20)
		{
			//int cel = (5*(i-32))/9;
			//double cel = (5.0/9.0)*(i-32); default is double not float, double means double precion
			//int cel = (int)((5.0/9)*(i-32));//complete typecasting
			int cel = (int)(5.0/9)*(i-32);//5.0/9 is double but then immediately
			System.out.println(cel + " ");//typecasted to int which makes it zero
		}								// hence do complete typecasting
	}

}

package January02;

public class queen_combination_arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queenc(4,0,0,2,""); // box ki choice

	}
	
	public static void queenc(int total_box,int boxno, int qno, int queens, String path)
	{
		if(qno == queens)
		{
			System.out.println(path);
			return;
		}
		if(boxno == total_box)
		{
			return;
		}
		queenc(total_box, boxno+1, qno+1,queens, path+(" q" + qno + "-b" + boxno));
		queenc(total_box, boxno+1,qno,queens,path);
	}

}

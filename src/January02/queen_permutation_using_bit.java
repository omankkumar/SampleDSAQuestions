package January02;

public class queen_permutation_using_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		queenBM(4,0,0,2,"");
	}
	static int cnt = 0;
	public static void queenBM(int tbox, int boxno, int qno, int queens, String ways)
	{
		if(qno == queens)
		{
			System.out.println((++cnt) + ways);
			return;
		}
		for(int i = 0; i<tbox; i++)
		{
			int bm = 1<<i;
			if((boxno & bm) == 0)
			{
				int nboxno = boxno | bm;
				boxno = nboxno;
				
				String asf = ways + " q" + (qno) + "-b" + i;
				queenBM(tbox, boxno,qno+1,queens,asf);
				
				int n1boxno = boxno & (~bm);
				boxno = n1boxno;
			}
		}
	}

}

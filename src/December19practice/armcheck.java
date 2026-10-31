package December19practice;

import java.util.Scanner;

public class armcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
	        int arn=s.nextInt();
	        int er=s.nextInt();
	        int end=s.nextInt();
	        System.out.println(IsArm(arn,digits(arn)));
	        arm(er,end);
		
		    
		

	}
	public static boolean IsArm(int a,int digit){
        int b=a,sum=0;
        while(a!=0){
            int rem=1;
            int c=digit;
            while(c!=0)
            {
            	rem=rem*(a%10);
            	c--;
            }
            sum=sum+rem;
            a=a/10;
        }
        if(b==sum){
            return true;
        }
        else return false;
    }
    public static void arm(int st,int end){
        int u=digits(end);
        while(st+1<end){
           if(IsArm(st,u)==true){
               System.out.print(st+" ");
           }
           st++;
       }}
public static int digits(int p){
    int t=0;
    while(p!=0){
        p=p/10;
        t++;
    }
    return t;
}

}

package Pattern;
import java.util.Scanner;

public class prime {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
      
		int n ;
		System.out.println("enter no");
        n=sc.nextInt(); 
       
       for (int i=2 ; i<n/2 ; i++)
       {
    	   if (n%i ==0)
    	   {
    		   System.out.println(" not prime");
    		   return;
    	   }
       }
    		   
    		     System.out.println("  prime");
                 return;
    		   
    	   
       }
	}



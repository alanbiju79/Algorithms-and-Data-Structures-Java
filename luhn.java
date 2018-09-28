import java.util.Scanner;

public class luhn{
	public static void main(String[]args){

		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		int total = 0;

		for(int i=0;i<num.length();i++){
			int digit = Integer.parseInt(""+num.charAt(num.length()-1-i));

			if(i%2==1)
            	digit=digit*2;

            if(digit>9)
            	digit=digit-9;

			total+=digit;
		}

		if(total%10==0)
			System.out.println("VALID");

		else
			System.out.println("INVALID");
	}
}

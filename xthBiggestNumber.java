//This program finds the xth largest number in an array

import java.util.Scanner;

public class xthBiggestNumber{
	public static void main(String[]args){

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter size of array");
        int array[] = new int[scan.nextInt()];
        int temp = 0;

		System.out.println("Please enter integers in array");
        for(int i=0; i<array.length; i++){
            array[i] = scan.nextInt();
        }

		System.out.println("Please enter xth largest number you wish to find");
        int x = scan.nextInt();

        for(int i=1; i<array.length; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j] < array[j+1]){
                	temp = array[j];
                	array[j] = array[j+1];
                	array[j+1] = temp;
            	}
        	}
        }

        System.out.println("Result: "+array[x-1]);
	}
}


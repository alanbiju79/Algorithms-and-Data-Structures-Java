//This program takes in a string, prints it in binary and also prints how many times a character occured.

import java.util.Scanner;

public class stringToAscii{
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter your sentence: ");
    String s = scan.nextLine();
    int arr[] = new int[s.length()];
    String binary[] = new String[s.length()];
    int[] asciiarray = new int[256];

    for(int i=0; i<s.length(); i++){
      arr[i] = (int) s.charAt(i);
      asciiarray[arr[i]]++;
      binary[i] = Integer.toBinaryString(arr[i]);

      if(binary[i].length()<7)
        binary[i] = 0+binary[i];
    }

    for(int i=0; i<s.length(); i++){
    	if(i%7==0)
    		System.out.println("");
      	System.out.print(binary[i]+" ");
    }

	System.out.println(" ");
    for(int i=0; i<256; i++){
    	if(asciiarray[i]==1)
    		System.out.println("'"+((char)i)+"'"+" appeared "+asciiarray[i]+" time");
    	if(asciiarray[i] >1)
    		System.out.println("'"+((char)i)+"'"+" appeared "+asciiarray[i]+" times");
    }

  }
}

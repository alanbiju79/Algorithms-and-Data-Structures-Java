//This program takes in a string and plays it in Morse Code

import java.util.Scanner;
import javax.sound.sampled.*;

public class MorseCode{
  public static void main(String[] args)throws LineUnavailableException{

      char[] english = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                    'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                    ',', '.', '?' };

      String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                  ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                  "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                  "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                  "-----", "--..--", ".-.-.-", "..--.." };

      Scanner scan = new Scanner(System.in);

      System.out.println("Enter what you would like translate");

      String in = scan.nextLine().toLowerCase();

      char[] chars = in.toCharArray();

      String str = "";
      for (int i = 0; i < chars.length; i++){
          for (int j = 0; j < english.length; j++){

              if (english[j] == chars[i]){
                  str = str + morse[j] + " ";
              }
          }
      }
      System.out.println(str);

      for(int i=0; i<str.length(); i++){
      	if(str.charAt(i)=='.')
      		tone(1000, 100, 1.0);
      		tone(1000, 300, 0.0);

      	if(str.charAt(i)=='-')
      		tone(1000, 300, 1.0);
      		tone(1000, 300, 0.0);

      	if(str.charAt(i)==' ')
      		tone(1000, 400, 0.0);

  	}
  }

  public static void tone(int hz, int msecs, double vol) throws LineUnavailableException{
	float SAMPLE_RATE = 8000f;
	byte[] buf = new byte[1];
	AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
	SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
	sdl.open(af);
	sdl.start();

	for (int i=0; i < msecs*8; i++) {
		double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
		buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
		sdl.write(buf,0,1);
	}
	sdl.drain();
	sdl.stop();
	sdl.close();
  }

}

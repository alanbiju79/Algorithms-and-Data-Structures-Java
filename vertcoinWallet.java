//This program generates a private key for a Vertcoin wallet.

import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.*;

public class vertcoinWallet{
	public static void main(String[] args) throws NoSuchAlgorithmException{

		String eighty2 = ecdsa();
		//System.out.println(eighty2);
		String hash = sha256(eighty2);
		//System.out.println(hash);
		String doublehash = sha256(hash);
		//System.out.println(doublehash);
		String eight = doublehash.substring(0,8);
		//System.out.println(eight);
		String s = eighty2+eight;
		//System.out.println(s);

		BigInteger n = new BigInteger(s,16);
		System.out.println(base58(n));
	}

	public static String ecdsa(){

		Random random = new Random();
		String hex = "";

		for(int i=0;i<64;i++){
			int val = random.nextInt(16);
			hex = hex+Integer.toHexString(val).toUpperCase();
		}

		String eighty = 80+hex;
		return eighty;
	}

	static String sha256(String input) throws NoSuchAlgorithmException{
 		byte[] in = hexStringToByteArray(input);
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(in);
 		StringBuffer sb = new StringBuffer();

 		for (int i = 0; i < result.length; i++) {
 			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
 		}
 		return sb.toString();
 	}

	public static byte[] hexStringToByteArray(String s){
 		int len = s.length();
 		byte[] data = new byte[len / 2];

 		for (int i = 0; i < len; i += 2) {
 			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
 			+ Character.digit(s.charAt(i+1), 16));
 		}
 		return data;
 	}


 	static String base58(BigInteger n){
    	String aplphabet = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    	String result = "";
    	while(n.compareTo(new BigInteger("58")) > 0){
      	//int mod = n % 58;
      		BigInteger mod = n.mod(new BigInteger("58"));
      		result = aplphabet.charAt(mod.intValue()) + result;

      		//n = n / 58;
      		n = n.divide(new BigInteger("58"));
    	}

    if(n.compareTo(new BigInteger("0")) > 0){
    	result = aplphabet.charAt(n.intValue()) + result;
    }

    return result;
  }
}




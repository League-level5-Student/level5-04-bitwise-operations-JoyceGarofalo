package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for(int i = 0; i < 64; i++) {
			if(base64Chars[i] == c) {
				byte b = (byte) i;
				return b;
			}
		}
		return 0;
	}	//finished
	
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		System.out.println(s);
		char c0 = s.charAt(0);
		char c1 = s.charAt(1);
		char c2 = s.charAt(2);
		char c3 = s.charAt(3);

		ArrayList<Integer> first6 = new ArrayList<Integer>();
		ArrayList<Integer> second6 = new ArrayList<Integer>();
		ArrayList<Integer> third6 = new ArrayList<Integer>();
		ArrayList<Integer> fourth6 = new ArrayList<Integer>();

		//converts first letter to corresponding number value and then into binary
		int result = convertBase64Char(c0);
		for(int i = 5; i > -1; i--) {
			int numShifted = result >> i;
			int numOnes = numShifted%10;
			numOnes = numOnes & 1;
			//System.out.print(numOnes);
			first6.add(numOnes);
		}
		
		//System.out.print(first6);
		//System.out.print("hi");
		
		//converts second letter to corresponding number value and then into binary
		int result_1 = convertBase64Char(c1);
		for(int i = 5; i > -1; i--) {
			int numShifted = result_1 >> i;
			int numOnes = numShifted%10;
			numOnes = numOnes & 1;
			//System.out.print(numOnes);
			second6.add(numOnes);
		}
		
		//converts third letter to corresponding number value and then into binary
		int result_2 = convertBase64Char(c2);
		for(int i = 5; i > -1; i--) {
			int numShifted = result_2 >> i;
			int numOnes = numShifted%10;
			numOnes = numOnes & 1;
			//System.out.print(numOnes);
			third6.add(numOnes);
		}
		
		//converts fourth letter to corresponding number value and then into binary
		int result_3 = convertBase64Char(c3);
		for(int i = 5; i > -1; i--) {
			int numShifted = result_3 >> i;
			int numOnes = numShifted%10;
			numOnes = numOnes & 1;
			//System.out.print(numOnes);
			fourth6.add(numOnes);
		}
		
		//separates four binary values into three binary values
		ArrayList<Integer> totalArray = new ArrayList<Integer>();
		totalArray.addAll(first6);
		totalArray.addAll(second6);
		totalArray.addAll(third6);
		totalArray.addAll(fourth6);
		//System.out.print(totalArray);
		//24 values
		
		
		int[] first8 = new int[8];
		int[] second8 = new int[8];
		int[] third8 = new int[8];

		for(int i = 0; i < 8; i++) {
			first8[i] = totalArray.get(i);
			second8[i] = totalArray.get(i+8);
			third8[i] = totalArray.get(i+16);
		}
		
		//first digit binary to decimal
		int[] first8numerical = new int[8];
		int firstnumber = 1;
		byte first8sum = 0;
		for(int i = 7; i > -1; i--) {
			//from the rightmost value to the leftmost:
			// assign the bit to a value of 1
			first8numerical[i] = firstnumber;
			// as you move left assign the next bit to double the previous value
			firstnumber = 2*firstnumber;
			// for every bit value of 1, add all those values
			if(first8[i] == 1) {
				first8sum = (byte) (first8sum + first8numerical[i]);
			}
		}
		
		//second digit binary to decimal
		int[] second8numerical = new int[8];
		int secondnumber = 1;
		byte second8sum = 0;
		for(int i = 7; i > -1; i--) {
			//from the rightmost value to the leftmost:
			// assign the bit to a value of 1
			second8numerical[i] = secondnumber;
			// as you move left assign the next bit to double the previous value
			secondnumber = 2*secondnumber;
			// for every bit value of 1, add all those values
			if(second8[i] == 1) {
				second8sum = (byte) (second8sum + second8numerical[i]);
			}
		}
		
		//third digit binary to decimal
		int[] third8numerical = new int[8];
		int thirdnumber = 1;
		byte third8sum = 0;
		for(int i = 7; i > -1; i--) {
			//from the rightmost value to the leftmost:
			// assign the bit to a value of 1
			third8numerical[i] = thirdnumber;
			// as you move left assign the next bit to double the previous value
			thirdnumber = 2*thirdnumber;
			// for every bit value of 1, add all those values
			if(third8[i] == 1) {
				third8sum = (byte) (third8sum + third8numerical[i]);
			}
		}
		
		//puts three decimal values into an array
		byte[] charsToBits = {first8sum, second8sum, third8sum};
		for(int i = 0; i< 3; i++) {
			System.out.println(charsToBits[i]);
		}
		
		return charsToBits;
	}	
	
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	
	//1 byte = 8 bits
	public static byte[] base64StringToByteArray(String file) {
		String message = JOptionPane.showInputDialog("enter a string");
		
		ArrayList<Integer> totalBinaryValues = new ArrayList<Integer>();
		
		//makes list divisible by 8
		int numberOfBits = message.length()*6;
		int numberOfExtraZeros = numberOfBits % 8;
		for(int i = 0; i < numberOfExtraZeros; i++) {
			totalBinaryValues.add(0);
		}
			
		//converts letters to binary and puts all binary values into a list
		for(int i = 0; i < message.length(); i++) {
			//convert each char to a decimal
			int charsToNum = convertBase64Char(message.charAt(i));
			//convert each decimal value to binary
			for(int x = 5; x > -1; x--) {
				int numShifted = charsToNum >> x;
				int numOnes = numShifted%10;
				numOnes = numOnes & 1;
				//add all binary values to one array list
				totalBinaryValues.add(numOnes);
			}	
		}
		
		System.out.println(totalBinaryValues);
		
		int numberOfGroupsOf8 = totalBinaryValues.size() / 8;
		
		//converts array list into an array
		int[] BinaryValues = new int[totalBinaryValues.size()];
		for(int i = 0; i < totalBinaryValues.size(); i++) {
			BinaryValues[i] = totalBinaryValues.get(i);
		}
				
		//take array and work in groups of 8 to turn binary back into numbers. Put numbers in a byte array
		int[] NumericalValues = new int[BinaryValues.length];
		int replaceValues = 1;
		byte[] decoded = new byte[numberOfGroupsOf8];
		for(int i = 0; i < numberOfGroupsOf8; i++) {
			decoded[i] = 0;
			replaceValues = 1;
			for(int setOf8 = 7+(8*i); setOf8 > -1+(8*i); setOf8--) {
				NumericalValues[setOf8] = replaceValues;
				replaceValues = 2*replaceValues;
				if(BinaryValues[setOf8] == 1) {
					decoded[i] = (byte) (decoded[i] + NumericalValues[setOf8]);
				}
			}
		}
		
		for(int i = 0; i < decoded.length; i++) {
			System.out.println(decoded[i]);
		}
		
		
		return decoded;
	}
}

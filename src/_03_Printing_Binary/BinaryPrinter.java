package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */

	
	public void printByteBinary(byte b) {
		for(int i = 1; i < 8; i++) {
			// We first want to print the bit in the one's place
			int onesPlace = b % 10;
			System.out.println(onesPlace);
			// Shift b seven bits to the right
			int numShifted = b >> 7;
			
			// Use the & operator to "mask" the bit in the one's place
			// This can be done by "anding" (&) it with the value of 1
			int num = onesPlace & 1;
			// Print the result using System.out.print (NOT System.out.println)
			System.out.print(num);
			//Use this method to print the remaining 7 bits of b
		}
	}
	
	public void printShortBinary(short s) {
		// Create 2 byte variables
		byte b1;
		byte b2;
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		for(int i = 1; i < 8; i++) {
			int firstBit = s % 10;
			int shiftBit = s >> 7;
			int num = firstBit & 1;
		}
		for(int i = 8; i < 16; i++) {
			int firstBit = s % 10;
			int shiftBit = s >> 7;
			int num = firstBit & 1;
		}
		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
		//b1.printByteBinary();
		//b2.printByteBinary();
	}
	
	public void printIntBinary(int i) {
		// Create 2 short variables
		short a;
		short b;
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
		//a.printShortBinary();
		//b.printShortBinary();
	}
	
	public void printLongBinary(long l) {
		// Use the same method as before to complete this method
	}
	
	public static void main(String[] args) {
		// Test your methods here
	}
}

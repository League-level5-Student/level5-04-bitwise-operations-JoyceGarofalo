package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */
	
	public void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		for(int i = 6; i > -1; i--) {
			// Shift b seven bits to the right
			int numShifted = b >> i;
			//System.out.println(numShifted);
			int numOnes = numShifted%10;
			
			// Use the & operator to "mask" the bit in the one's place
			// This can be done by "anding" (&) it with the value of 1
			numOnes = numOnes & 1;
			
			// Print the result using System.out.print (NOT System.out.println)
			System.out.print(numOnes);
		}
		//Use this method to print the remaining 7 bits of b
		System.out.println();
	}
	
	public void printShortBinary(short s) {
		// Create 2 byte variables
		byte b1 = 0;
		byte b2 = 0;
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		for(int i = 15; i > 7; i--) {
			int numShifted = s >> i;
			int numOnes = numShifted%10;
			b2 = (byte) (numOnes & 1);
			//System.out.print(b2);
		}

		for(int i = 7; i > -1; i--) {
			int numShifted = s >> i;
			int numOnes = numShifted%10;
			b1 = (byte) (numOnes & 1);
			//System.out.print(b1);
		}
		
		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
		printByteBinary(b2);
		printByteBinary(b1);
		
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
		
	}
	
	public void printLongBinary(long l) {
		// Use the same method as before to complete this method
	}
	
	public static void main(String[] args) {
		// Test your methods here
		BinaryPrinter bp = new BinaryPrinter();
		
		byte b = 82; // 1010010
		bp.printByteBinary(b);
		
		short s = 1254; //0000010011100110
		bp.printShortBinary(s);
	}
}

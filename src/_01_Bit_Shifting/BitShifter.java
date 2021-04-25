package _01_Bit_Shifting;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 4; //100 binary
		int numShifted = num << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted);
		System.out.println(convertDecimaltoBinary(numShifted));
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		
		// 4. Try shifting num 3 places.
		
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
	}

	private static String convertDecimaltoBinary(int numShifted) {
		// TODO Auto-generated method stub
		String binaryStr = "";
	    
        do {
            int quotient = numShifted >> 1; //diving by 2 shifts binary value down 1 to the right

            if( numShifted % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            numShifted = quotient;
  
        } while( numShifted != 0 );
        
        return binaryStr;
	}
}

import java.util.*;

class CaesarCipher
{

	public static void main(String ar[])
	{
		String choice; 
		String encode = "encode";
		String decode = "decode";
		Scanner in = new Scanner(System.in);
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.printf("Would you like to encode or decode a message? ");
		choice = in.nextLine();
		if(choice.equals(encode)) // used to string compare. 
		{
			encryptcaesar(); // calling encode function.
		}
		else if(choice.equals(decode))
		{
			decryptcaesar(); // calling decode function. 
		}
		else
		{
			System.out.println("Invalid input! Enter either 'encode' or 'decode' "); 
		}

	}

	public static void encryptcaesar() // this method encodes a given string from a user using a specific formula. 
	{
		int base = 97; // declaration of base to keep track of ascii value. 
		Scanner in = new Scanner(System.in);
		String en ;
		System.out.printf("Enter the string to encode: ");
		en = in.nextLine();
       		for(int n = 0; n<26; n++) // loop to display all 26 different possibilities.
       		{
            		System.out.printf("n =" +n+ ":  ");
            		char[] fin = new char[en.length()]; // array creation to hold the new encoded word.
            		for(int i=0;i<en.length();i++)
            		{
                		char temp = en.charAt(i);
                		int asc = ((((int) temp) - base) + n) ;
                		if(asc>25){ // check if value needs to be wrapped around.
                     		asc= (asc-26) + base;
                	}
                	else
			{
                     		asc = asc+base ;
                	}
                	char f = (char) asc ;
                	fin[i] = f;
            	}
            	String finalans = new String(fin);
            	System.out.println(finalans); // printing new string
       		}
	}
	public static void decryptcaesar() // this method decodes a given string from a user using a specific formula.
	{
		int base = 97; // declaration of base to keep track of ascii value. 
		Scanner in = new Scanner(System.in);
		String en ;
		System.out.printf("Enter the string to decode: ");
		en = in.nextLine();
		
		for(int n = 0; n<26; n++)
        	{
            		System.out.printf("n =" +n+ ":  ");
            		char[] fin = new char[en.length()];
            		for(int i=0;i<en.length();i++)
            		{
               	 		char temp = en.charAt(i);
                		int asc = ((((int) temp) - base) - n);
               			if(asc<0)
                		{
                    			 asc= (asc+26) + base;
                		}
               			else
               			{
                    		 asc = asc+base ;
              			}
                		char f = (char) asc ;
               			 fin[i] = f;
            	}
            	String finalans = new String(fin);
            	System.out.println(finalans);
        }
   
    }
		
}

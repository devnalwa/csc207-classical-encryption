import java.util.*;

class VigenereCipher
{
	public static void main(String ar[])
	{
		String choice; 
		String encode = "encode";
		String decode = "decode";
		Scanner in = new Scanner(System.in); // to take user inputs.
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.printf("Would you like to encode or decode a message? ");
		choice = in.nextLine();
		if(choice.equals(encode)) // used to string compare. 
		{
			encryptvig(); // calling encode function.
		}
		else if(choice.equals(decode))
		{
			decryptvig(); // calling decode function. 
		}
		else
		{
			System.out.println("Invalid input! Enter either 'encode' or 'decode' "); 
		}

	}
	public static void encryptvig() // this method encodes a given string from a user.
	{
	
		int base = 97; // declaration of base to keep track of ascii value. 
		String en, key ;
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the string to encode: ");
		en = in.nextLine();
		char[] output = new char[en.length()];
		System.out.printf("Enter the key: ");
		key = in.nextLine();
		char[] temp = new char[en.length()];
        
        if(key.length() == 0)
        {
                System.out.println(en);
                System.exit(0);
            
        }
        else
        {
        
        	if(key.length() >= en.length())
        	{
            		for(int i =0; i<en.length(); i++)
            		{
               			 temp[i] = key.charAt(i);
            		}
        	}
        	else // To wrap around if needed and use of remainder and quotient to duplicate the key if too small.
        	{
            		int fullIndex = en.length() / key.length();
            		int partIndex = en.length() % key.length();
            		for(int i = 0; i < fullIndex; i++)
            		{
                		int j = (i * key.length());
                		for(int n = 0; n < key.length(); n++)
                		{
                   			 temp[j] = key.charAt(n);
                    			j++;
                		}
           	}
            	int count = 0;
            	for(int m = (en.length() - partIndex); m < en.length(); m++)
            	{
                	temp[m] = key.charAt(count);
                	count++;
            	}
        }
      
        for( int i = 0; i < en.length(); i++)
        {
        	int asc1 = (int) en.charAt(i) - base;
        	int asc2 = (int) temp[i] - base;
        	int sum = asc1 + asc2;
       	    	if(sum>25)
         	{             
             		sum= (sum-26) + base;
        	}
        	else
        	{
        		sum = sum+base ;
        	}
        	char f = (char) sum ;
        	output[i] = f;
        }
        String finalans = new String(output);
        System.out.println(finalans); // printing the new vignere encrypted word.
        }
    }
    
    public static void decryptvig() // this method encodes a given string from a user.
	{
		int base = 97; // declaration of base to keep track of ascii value. 
		String en, key ;
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the string to decode: ");
		en = in.nextLine();
		char[] output = new char[en.length()];
		System.out.printf("Enter the key: ");
		key = in.nextLine();
		char[] temp = new char[en.length()];
        
        if(key.length() == 0)
        {
            System.out.println(en);
            System.exit(0);
            
        }
        else
        {
        	if(key.length() >= en.length())
        	{
            		for(int i =0; i<en.length(); i++)
            		{
                		temp[i] = key.charAt(i);
           		}
        	}
        	else // To wrap around if needed and use of remainder and quotient to duplicate the key if too small.)
        	{
            		int fullIndex = en.length() / key.length();
            		int partIndex = en.length() % key.length();
            		for(int i = 0; i < fullIndex; i++)
            		{
                		int j = (i * key.length());
                		for(int n = 0; n < key.length(); n++)
                		{
                    			temp[j] = key.charAt(n);
                    			j++;
                		}
            		}
            		int count = 0;
            		for(int m = (en.length() - partIndex); m < en.length(); m++)
            		{
                		temp[m] = key.charAt(count);
                		count++;
            		}
        	}
        	for( int i = 0; i < en.length(); i++)
        	{
        		int asc1 = (int) en.charAt(i) - base;
        		int asc2 = (int) temp[i] - base;
        		int diff = asc1 - asc2;
       	   		if(diff<0)
         		{             
             			diff= (diff+26) + base;
        	 	}
        		else
        		{
        			diff = diff+base ;
        		}
        		char f = (char) diff ;
        		output[i] = f;
        	}
        	String finalans = new String(output);
        	System.out.println(finalans); // printing the new vignere decrypted word.
        	}
	}
 }

   
    
 

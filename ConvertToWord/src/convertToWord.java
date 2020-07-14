import java.util.Scanner;

public class convertToWord {
 
	static String convert(int no){          								// Function definition Code for converting number into words
		
		String string = "";
		if(no < 100){							
			string = onesTens(no);  										// Function calling onesTens
		}
		else if(no >= 100 && no <1000){
			string = onesTens(no/100) + "Hundread And " + convert(no%100);	// Function declaring onesTens And recursion of convert. 
		}
		else if(no >= 1000 && no <100000){
			string = onesTens(no/1000) + "Thousand " + convert(no%1000);	// Function declaring onesTens And recursion of convert.
		}
		else if(no >= 100000 && no <1000000){
			string = onesTens(no/100000) + "Lakh " + convert(no%100000);	// Function declaring onesTens And recursion of convert.
		}
		return string;
	}
	 
	static String onesTens(int n){       									// Function definition of oneTens for one to ninety nine print
			String str = "";
			String [] strOnes = { "", "One ", "Two ", "Three ", "Four ", 
                    "Five ", "Six ", "Seven ", "Eight ", 
                    "Nine ", "Ten ", "Eleven ", "Twelve ", 
                    "Thirteen ", "Fourteen ", "Fifteen ", 
                    "Sixteen ", "Seventeen ", "Eighteen ", 
                    "Nineteen " }; 
			String [] strTens =	{ "", "", "Twenty ", "Thirty ", "Forty ", 
                "Fifty ", "Sixty ", "Seventy ", "Eighty ", 
                "ninety " };
			if(n < 20){														// Condition for 0 to 19 word print
				str = strOnes[n];
			}
			else if(n >= 20 && n < 100){									// Condition for 10 to 99 word print
				str = strTens[n/10] + strOnes[n%10];
			}
		return str;
		}
	
	public static void main(String [] args){
		double value;
		Scanner sc= new Scanner(System.in);
		System.out.println("Please Enter value between 0 to 1000000");
		value = sc.nextDouble();
		if(value > 0 && value < 1000000){     								// Value checking condition
			int intValue =(int)value;
			String con = convert(intValue);   								// Function declaring convert
			System.out.print(con);
			float floatValue = (float) value % 1;
			floatValue = floatValue * 100;
			int remValue = (int) floatValue;
			if(remValue > 0){
				String strVal = String.valueOf(remValue);
				String strHun = "/100";			
				System.out.print(strVal+strHun);
			}
		}
		else{
			System.out.println("Please Emter currect value");
		}
		sc.close();
	}
}

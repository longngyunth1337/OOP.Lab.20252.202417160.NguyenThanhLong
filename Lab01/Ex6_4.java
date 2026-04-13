package Lab01;
import java.util.Scanner;
public class Ex6_4 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int month = -1;
		 while(month == -1)
		 {
			 System.out.println("Enter month : ");
			 String input = sc.nextLine();
			input = input.toLowerCase();
			input = input.replace(".","");
			if(input.equals("1") || input.startsWith("jan")) month = 1;
			else if(input.equals("2") || input.startsWith("feb")) month = 2;
			else if(input.equals("3") || input.startsWith("mar")) month = 3;
			else if(input.equals("4") || input.startsWith("apr")) month = 4;
			else if(input.equals("5") || input.startsWith("may")) month = 5;
			else if(input.equals("6") || input.startsWith("jun")) month = 6;
			else if(input.equals("7") || input.startsWith("jul")) month = 7;
			else if(input.equals("8") || input.startsWith("aug")) month = 8;
			else if(input.equals("9") || input.startsWith("sep")) month = 9;
			else if(input.equals("10") || input.startsWith("oct")) month = 10;
			else if(input.equals("11") || input.startsWith("nov")) month = 11;
			else if(input.equals("12") || input.startsWith("dec")) month = 12;
			else if(month == -1) System.out.println("Invalid month, please try again !");
		 }
		 int year = -1;
		 while(year < 0)
		 {
			 System.out.println("Enter year: ");
			 year = sc.nextInt();
			 if(year < 0)
				 System.out.println("Please try agian !"); 
		 }
		 int days = 0;
		 switch (month)
		 {
		 case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
			 days = 31;
			 break;
		 case 4 : case 6 : case 9 : case 11 :
			 days = 30;
			 break;
		 case 2: 
			 if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
				 days = 29;
			 else
				 days = 28;
			 break;
		 }
		 System.out.println("This month has " + days + " days" );
		 	 
		
	}
}

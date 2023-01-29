
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    boolean isExitMenu3 = true;
	while (isExitMenu3) {
		System.out.println("Please Choose Number From Menu:       \n");
		System.out.println(" ====================================================");
		System.out.println("|  [1]Shop Settings                                  |");
		System.out.println("|  [2]Manage Shop Items                              |");
		System.out.println("|  [3]Create New Invoice                             |");
		System.out.println("|  [4]Report Statistics                              |");
		System.out.println("|  [5]Report All Invoices                            |");
		System.out.println("|  [6]Search Invoice                                 |");
		System.out.println("|  [7]Program Statistics                             |");
		System.out.println("|  [8]EXIT                                           |");
		System.out.println(" ====================================================");
		Integer num = sc.nextInt();

		switch (num) {
		case 1:
			boolean isExitMenu = true;
			while (isExitMenu) {

				System.out.println("Please Choose Number From Menu:               \n");
				System.out.println(" ==============================================");
				System.out.println("|  [1]Load Data                                |");
				System.out.println("|  [2]Set shop info                            |");
				System.out.println("|  [3]GO Back To Main Menu                     |");
				System.out.println(" ==============================================");
				int op = sc.nextInt();

				switch (op) {
				case 1:
			

					break;

				case 2:
			
					break;
		
				case 3:
					isExitMenu = false;

					break;
				}

			}

			isExitMenu3 = true;

			break;

		case 2:
			boolean isExitMenu4 = true;
			while (isExitMenu4) {

				System.out.println("Please Choose Number From Menu:               \n");
				System.out.println(" ==============================================");
				System.out.println("|  [1]Add Items                                |");
				System.out.println("|  [2]Delete Items                             |");
				System.out.println("|  [3]Change Item Price                        |");
				System.out.println("|  [3]Report All Items                         |");
				System.out.println("|  [4]GO Back To Main Menu                     |");
				System.out.println(" ==============================================");
				int op = sc.nextInt();

				switch (op) {
				case 1:
				

					break;

				case 2:
					
					break;
				case 3:
					isExitMenu = false;

					break;
				}

			}

			isExitMenu3 = true;

			break;

		case 3:

			break;
		case 4:


			break;

		case 5:
		
			break;
		case 6:
	
			break;
		case 7:
			System.out.println("THANK YOU");
			isExitMenu = false;
			break;
	

		}
	}
}

	}



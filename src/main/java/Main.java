import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		 Scanner sc=new Scanner(System.in);
		    boolean isExitMenu3 = true;

			while (isExitMenu3) {
			for(String x:Menu.superMenuList()) {
				System.out.println(x);
			}
				Integer num = sc.nextInt();

				switch (num) {
				case 1:
					boolean isExitMenu = true;
					while (isExitMenu) {

						System.out.println("Please Choose Number From Menu:               \n");
						System.out.println(" ==============================================");
						System.out.println("|  [1]create Tables                            |");
						System.out.println("|  [2]Insert to table                                          |");
						System.out.println("|  [3]                                         |");
						System.out.println("|  [4]                                         |");
						System.out.println(" ==============================================");
						int op = sc.nextInt();

						switch (op) {
						case 1:


							BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
							System.out.print(" Please Enter the database connection URL :\n");
							String url = br.readLine();
							System.out.print(" Please user name :");
							String user = br.readLine();
							System.out.print(" Please user password :");
							String pass = br.readLine(); 
							CreatingTables.creatingShopTable(url, user, pass);
							CreatingTables.creatingInvoiceHeaderTable(url, user, pass);
							CreatingTables.creatingCustomerTable(url, user, pass);
							CreatingTables.creatingInvoiceTable(url, user, pass);
							CreatingTables.creatingItemTable(url, user, pass);
							CreatingTables.creatingInvoiceItemTable(url, user, pass);
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
					boolean isExitMenu9 = true;
					while (isExitMenu9) {

						System.out.println("Please Choose Number From Menu:               \n");
						System.out.println(" ==============================================");
						System.out.println("|  [1]Load Data                                |");
						System.out.println("|  [2]Set shop info                            |");
						System.out.println("|  [3]Set Invoice Header                       |");
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

				case 4:

					break;
				case 5:


					break;

				case 6:
				
					break;
				case 7:
			
					break;
				case 8:
					System.out.println("THANK YOU");
					isExitMenu = false;
					break;
			

				}
			}
		}

	}
	



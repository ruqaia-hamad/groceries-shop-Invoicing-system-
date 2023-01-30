import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		boolean isExitMenu3 = true;

		while (isExitMenu3) {
			DatabaseCredentials dbcredentials = new DatabaseCredentials();
			for (String x : Menu.superMenuList()) {
				System.out.println(x);
			}
			Integer num = sc.nextInt();

			switch (num) {

			case 1:
				boolean isExitMenu9 = true;
				while (isExitMenu9) {
				
					for (String x : Menu.shopMenuList()) {
						System.out.println(x);
					}
					int op = sc.nextInt();

					switch (op) {
					case 1:

						Menu.loadData();

						break;

					case 2:
					
						InsertToTables.InsertToInvoiceHeader(dbcredentials.getUrl(), dbcredentials.getUser(),
								dbcredentials.getPass());

						break;

					case 3:
				
						InsertToTables.InsertToInvoiceHeader(dbcredentials.getUrl(), dbcredentials.getUser(),
								dbcredentials.getPass());

						break;
					case 4:
						isExitMenu9 = false;

						break;
					}

				}

				isExitMenu3 = true;

				break;

			case 2:
				boolean isExitMenu4 = true;
				while (isExitMenu4) {
					
					for (String x : Menu.itemMenuList()) {
						System.out.println(x);
					}
					int op = sc.nextInt();
					
					switch (op) {
		
					case 1:
					
						InsertToTables.InsertToItem(dbcredentials.getUrl(), dbcredentials.getUser(),
								dbcredentials.getPass());
						break;
					case 2:
					
						SqlQuries.updateItemPrice(dbcredentials.getUrl(), dbcredentials.getUser(),
								dbcredentials.getPass());
						break;
					case 3:
					
						SqlQuries.updateItemPrice(dbcredentials.getUrl(), dbcredentials.getUser(),
								dbcredentials.getPass());

						break;
					case 4:
						
						SqlQuries.reportItem(dbcredentials.getUrl(), dbcredentials.getUser(),
								dbcredentials.getPass());

						break;
					case 5:
						isExitMenu4 = false;

						break;
					}

				}

				isExitMenu3 = true;

				break;

			case 3:
				InsertToTables.insertToInvoice(dbcredentials.getUrl(), dbcredentials.getUser(),
						dbcredentials.getPass());
				break;
			case 4: 
				SqlQuries.reportStatistics(dbcredentials.getUrl(), dbcredentials.getUser(),
						dbcredentials.getPass());
				break;

			case 5:

				break;

			case 6:

				break;
			case 7:

				break;
			case 8:
				System.out.println("THANK YOU");
				isExitMenu3 = false;
				break;

			}
		}
	}

}

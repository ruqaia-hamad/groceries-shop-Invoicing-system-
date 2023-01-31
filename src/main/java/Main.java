import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		boolean isExitMenu = true;

		DatabaseCredentials dbCredentials = new DatabaseCredentials();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(" Please Enter the database connection URL :\n");
		dbCredentials.setUrl(br.readLine());
		System.out.print(" Please user name :");
		dbCredentials.setUser(br.readLine());
		System.out.print(" Please user password :");
		dbCredentials.setPass(br.readLine());

		Map<String, Integer> menuItems = SqlQuries.initializeMenu();
		while (isExitMenu) {

			for (String x : Menu.superMenuList()) {
				System.out.println(x);
			}
			Integer num = sc.nextInt();

			switch (num) {
			case 0:
				menuItems.put("Shop Settings", menuItems.get("Shop Settings") + 1);

				boolean isExitMenuCreatinTables = true;
				while (isExitMenuCreatinTables) {

					for (String x : Menu.CreatingTables()) {
						System.out.println(x);
					}
					int op = sc.nextInt();

					switch (op) {
					case 1:

						CreatingTables.creatingCustomerTable(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());

						break;

					case 2:
						CreatingTables.creatingInvoiceHeaderTable(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());
						break;

					case 3:

						CreatingTables.creatingItemTable(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());

						break;
					case 4:
						CreatingTables.creatingInvoiceTable(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());
						break;

					case 5:
						CreatingTables.creatingShopTable(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());
					case 6:

						isExitMenuCreatinTables = false;

						break;
					}

				}

				isExitMenu = true;

				break;

			case 1:
				menuItems.put("Shop Settings", menuItems.get("Shop Settings") + 1);

				boolean isExitMenuShop = true;
				while (isExitMenuShop) {

					for (String x : Menu.shopMenuList()) {
						System.out.println(x);
					}
					int op = sc.nextInt();

					switch (op) {
					case 1:

						Menu.loadData(dbCredentials);

						break;

					case 2:

						Invoice.InsertToShop(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());

						break;

					case 3:

						Invoice.InsertToInvoiceHeader(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());

						break;
					case 4:
						isExitMenuShop = false;

						break;
					}

				}

				isExitMenu = true;

				break;

			case 2:
				menuItems.put("Manage Shop Items", menuItems.get("Manage Shop Items") + 1);
				boolean isExitMenuManageShop = true;
				while (isExitMenuManageShop) {

					for (String x : Menu.itemMenuList()) {
						System.out.println(x);
					}
					int op = sc.nextInt();

					switch (op) {

					case 1:

						Product.InsertToItem(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());
						break;
					case 2:

						Product.updateItemPrice(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());
						break;
					case 3:

						Product.updateItemPrice(dbCredentials.getUrl(), dbCredentials.getUser(),
								dbCredentials.getPass());

						break;
					case 4:

						Product.reportItem(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());

						break;
					case 5:
						isExitMenuManageShop = false;

						break;
					}

				}

				isExitMenu = true;

				break;

			case 3:
				Invoice.insertToInvoice(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());
				menuItems.put("Create New Invoice", menuItems.get("Create New Invoice") + 1);
				break;
			case 4:
				SqlQuries.reportStatistics(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());
				menuItems.put("Report Statistics", menuItems.get("Report Statistics") + 1);
				break;

			case 5:
				SqlQuries.reportAllInvoices(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());
				menuItems.put("Report All Invoices", menuItems.get("Report All Invoices") + 1);
				break;

			case 6:
				SqlQuries.searchInvoice(dbCredentials.getUrl(), dbCredentials.getUser(), dbCredentials.getPass());
				menuItems.put("Search Invoice", menuItems.get("Search Invoice") + 1);
				break;
			case 7:
				menuItems.put("Program Statistics", menuItems.get("Program Statistics") + 1);
				for (Map.Entry<String, Integer> entry : menuItems.entrySet()) {
					System.out.println(entry.getKey() + ":" + entry.getValue());
				}

				break;
			case 8:
				System.out.println("THANK YOU");
				isExitMenu = false;
				break;

			}
		}
	}

}

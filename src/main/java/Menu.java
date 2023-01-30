import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static List<String> superMenuList() {
		return Arrays.asList("Please Choose Number From Menu:\n", "[1]Shop Settings ", "[2]Manage Shop Items  ",
				"[3]Create New Invoice  ", "[4]Report Statistics  ", "[5]Report All Invoices ", "[6]Search Invoice",
				"[7]Program Statistics ", "[8]EXIT");

	}

	public static List<String> shopMenuList() {
		return Arrays.asList("Please Choose Number From Menu:\n", "[1]Load Data", "[2]Set shop info ",
				"[3]Set Invoice Header ", "[4]GO Back To Main Menu ");

	}

	public static List<String> itemMenuList() {
		return Arrays.asList("Please Choose Number From Menu:\n", "[1]Add Items", "[2]Delete Items",
				"[3]Change Item Price", "[4]Report All Items", "[5]GO Back To Main Menu");

	}

	public static void loadData() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print(" Please Enter the table number to Load data:");
		System.out.print("1- Customer Table:");
		System.out.print("2- Items Table:");
		System.out.print("3- Invoice Table:");
		int choose = sc.nextInt();
		if (choose == 1) {
			DatabaseCredentials dbcredentials1 = new DatabaseCredentials();
			InsertToTables.InsertToCustomer(dbcredentials1.getUrl(), dbcredentials1.getUser(),
					dbcredentials1.getPass());
		}
		if (choose == 2) {
			DatabaseCredentials dbcredentials1 = new DatabaseCredentials();
			InsertToTables.InsertToItem(dbcredentials1.getUrl(), dbcredentials1.getUser(), dbcredentials1.getPass());
		}
		if (choose == 3) {
			DatabaseCredentials dbcredentials1 = new DatabaseCredentials();
			InsertToTables.InsertToItem(dbcredentials1.getUrl(), dbcredentials1.getUser(), dbcredentials1.getPass());
		}

	}
}

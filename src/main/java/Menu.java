import java.util.Arrays;
import java.util.List;

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
		return Arrays.asList("Please Choose Number From Menu:\n", "[1]Add Items", "[2]Delete Items  ",
				" [3]Change Item Price ", "Report All Items ", "[5]GO Back To Main Menu ");

	}
}

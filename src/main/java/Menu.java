import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public static List<String> superMenuList() {
		return Arrays.asList("Please Choose Number From Menu:\n", "[1]Creating Tables ", "[2]Shop Settings ",
				"[3]Manage Shop Items  ", "[4]Create New Invoice  ", "[5]Report Statistics  ",
				"[6]Report All Invoices ", "[7]Search Invoice", "[8]Program Statistics ", "[9]EXIT");

	}

	public static List<String> creatingMenuList() {
		return Arrays.asList("Please Choose Number From Menu:\n", "[1]Creating Tables ", "[2]Shop Settings ",
				"[3]Manage Shop Items  ", "[4]Create New Invoice  ", "[5]Report Statistics  ",
				"[6]Report All Invoices ", "[7]Search Invoice", "[8]Program Statistics ", "[9]EXIT");

	}
}

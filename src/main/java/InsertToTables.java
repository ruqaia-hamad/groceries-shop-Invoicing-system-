import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertToTables {

	public static void insertToInvoice(String url, String user, String pass) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer ID: ");
		int customerId = sc.nextInt();
		System.out.print("Enter Invoice Header ID: ");
		int invoiceHeaderId = sc.nextInt();
		System.out.print("Enter Invoice Date (YYYY-MM-DD):");
		String invoiceDate = sc.next();
		System.out.print("Enter Total Amount: ");
		int totalAmount = sc.nextInt();
		System.out.print("Enter Paid Amount: ");
		int paidAmount = sc.nextInt();
		int balance = totalAmount - paidAmount;

		String sql = "INSERT INTO Invoice (CustomerID, InvoiceHeaderID, InvoiceDate, TotalAmount, PaidAmount, Balance) VALUES (?, ?, ?, ?, ?, ?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerId);
			statement.setInt(2, invoiceHeaderId);
			statement.setString(3, invoiceDate);
			statement.setInt(4, totalAmount);
			statement.setInt(5, paidAmount);
			statement.setInt(6, balance);
			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}
	}

	public static void InsertToCustomer(String url, String user, String pass) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Customer name:");
		String CustomerName = br.readLine();
		System.out.print("Enter the Customer phone:");
		Integer PhoneNumber = br.read();
		String sql = "INSERT INTO Customer (CustomerName, PhoneNumber) VALUES (?, ?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, CustomerName);
			statement.setInt(2, PhoneNumber);

			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}

	}

	public static void InsertToItem(String url, String user, String pass) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Item Description:");
		String ItemDescription = br.readLine();
		System.out.print("Enter Quantity: ");
		Integer Quantity = br.read();
		System.out.print("Enter Unit Price: ");
		double unitPrice = sc.nextDouble();

		double totalPrice = Quantity * unitPrice;

		String sql = "INSERT INTO  Item (ItemDescription, Quantity,UnitPrice,TotalPrice) VALUES (?,?,?,?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ItemDescription);
			statement.setInt(2, Quantity);
			statement.setDouble(3, unitPrice);
			statement.setDouble(4, totalPrice);
			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}

	}

	public static void InsertToInvoiceItem(String url, String user, String pass) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Item ID:");
		Integer ItemID = br.read();
		System.out.print("Enter Invoice ID :");
		Integer InvoiceID = br.read();

		String sql = "INSERT INTO  InvoiceItem (ItemID,InvoiceID) VALUES (?,?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, ItemID);
			statement.setInt(2, InvoiceID);
			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}

	}

	public static void InsertToShop(String url, String user, String pass) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Shop Name:");
		String ShopName = br.readLine();

		String sql = "INSERT INTO  Shop(ShopName) VALUES (?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ShopName);
			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}

	}

	public static void InsertToInvoiceHeader(String url, String user, String pass) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Tel:");
		String Tel = br.readLine();
		System.out.print("Enter the Fax:");
		String Fax = br.readLine();
		System.out.print("Enter the Email:");
		String Email = br.readLine();
		System.out.print("Enter the Website:");
		String Website = br.readLine();
		System.out.print("Enter the Shop ID:");
		Integer ShopID = br.read();

		String sql = "INSERT INTO  InvoiceHeader(Tel,Fax,Email,Website,ShopID) VALUES (?,?,?,?,?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Tel);
			statement.setString(2, Fax);
			statement.setString(3, Email);
			statement.setString(4, Website);
			statement.setInt(5, ShopID);
			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class Invoice {
	static int customerId;
	static int invoiceHeaderId;
	static String invoiceDate;
	static int totalAmount;
	static int paidAmount ;
	static int balance;
	List<Product> itemsList;
	
	public List<Product> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Product> itemsList) {
		this.itemsList = itemsList;
	}

	public static int getCustomerId() {
		return customerId;
	}

	public static void setCustomerId(int customerId) {
		Invoice.customerId = customerId;
	}

	public static int getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public static void setInvoiceHeaderId(int invoiceHeaderId) {
		Invoice.invoiceHeaderId = invoiceHeaderId;
	}

	public static String getInvoiceDate() {
		return invoiceDate;
	}

	public static void setInvoiceDate(String invoiceDate) {
		Invoice.invoiceDate = invoiceDate;
	}

	public static int getTotalAmount() {
		return totalAmount;
	}

	public static void setTotalAmount(int totalAmount) {
		Invoice.totalAmount = totalAmount;
	}

	public static int getPaidAmount() {
		return paidAmount;
	}

	public static void setPaidAmount(int paidAmount) {
		Invoice.paidAmount = paidAmount;
	}

	public static int getBalance() {
		return balance;
	}

	public static void setBalance(int balance) {
		Invoice.balance = balance;
	}

	public static void insertToInvoice(String url, String user, String pass) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer ID: ");
		int customerId = sc.nextInt();
		setCustomerId(customerId);
		System.out.print("Enter Invoice Header ID: ");
		int invoiceHeaderId = sc.nextInt();
		setInvoiceHeaderId(invoiceHeaderId);
		System.out.print("Enter Invoice Date (YYYY-MM-DD):");
		String invoiceDate = sc.next();
		setInvoiceDate(invoiceDate);
		System.out.print("Enter Total Amount: ");
		int totalAmount = sc.nextInt();
		setTotalAmount(totalAmount);
		System.out.print("Enter Paid Amount: ");
		int paidAmount = sc.nextInt();
		setPaidAmount(paidAmount);
		int balance = totalAmount - paidAmount;
        setBalance(balance);
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
		String PhoneNumber = br.readLine();
		String sql = "INSERT INTO Customer (CustomerName, PhoneNumber) VALUES (?, ?)";

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, CustomerName);
			statement.setString(2, PhoneNumber);

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
		int ShopID = sc.nextInt();

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

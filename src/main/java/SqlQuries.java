import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SqlQuries {

	

	public static void reportStatistics(String url, String user, String pass) throws Throwable {

		String sql = "SELECT COUNT(*) AS NoOfItems,\r\n" + "       (SELECT COUNT(*) FROM Invoice) AS NoOfInvoices,\r\n"
				+ "       SUM(TotalPrice) AS TotalSales\r\n" + "FROM Item";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				System.out.println("No. of Items: " + rs.getInt("NoOfItems"));
				System.out.println("No. of Invoices: " + rs.getInt("NoOfInvoices"));
				System.out.println("Total Sales: " + rs.getDouble("TotalSales"));
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	// -----------------------------------

	public static void reportAllInvoices(String url, String user, String pass) throws Throwable {

		String sql = "SELECT Invoice.InvoiceID, Invoice.InvoiceDate, Customer.CustomerName, \r\n"
				+ "(SELECT COUNT(*) FROM InvoiceItem WHERE InvoiceItem.InvoiceID = Invoice.InvoiceID) AS NoOfItems,\r\n"
				+ "Invoice.TotalAmount, Invoice.Balance\r\n" + "FROM Invoice\r\n"
				+ "JOIN Customer ON Invoice.CustomerID = Customer.CustomerID";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				System.out.println("Invoice ID: " + rs.getInt("InvoiceID"));
				System.out.println("Invoice Date: " + rs.getDate("InvoiceDate"));
				System.out.println("Customer Name: " + rs.getString("CustomerName"));
				System.out.println("No. of Items: " + rs.getInt("NoOfItems"));
				System.out.println("Total Amount: " + rs.getDouble("TotalAmount"));
				System.out.println("Total Amount: " + rs.getDouble("Balance"));
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	// --------------------------------

	public static void searchInvoice(String url, String user, String pass) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Invoice  id : ");
		int InvoiceID = sc.nextInt();

		String sql = "\r\n" + "SELECT  Invoice.InvoiceDate, Customer.CustomerName, \r\n" + "     \r\n"
				+ "       Invoice.TotalAmount, Invoice.PaidAmount, Invoice.Balance , InvoiceHeader.Email ,InvoiceHeader.Fax ,InvoiceHeader.Website ,InvoiceHeader.Tel ,Shop.ShopName\r\n"
				+ "FROM Invoice\r\n" + "JOIN Customer ON Invoice.CustomerID = Customer.CustomerID\r\n" + "\r\n"
				+ "JOIN InvoiceHeader ON InvoiceHeader.InvoiceHeaderID    = Invoice.InvoiceHeaderID\r\n"
				+ "JOIN Shop ON InvoiceHeader.ShopID = Shop.ShopID\r\n" + "WHERE Invoice.InvoiceID = ?";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, InvoiceID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Shop Name : " + rs.getString("ShopName"));
				System.out.println("TEl : " + rs.getString("Tel"));
				System.out.println("Fax : " + rs.getString("Fax"));
				System.out.println("Email : " + rs.getString("Email"));
				System.out.println("Website : " + rs.getString("Website"));
				System.out.println("Invoice Date: " + rs.getDate("InvoiceDate"));
				System.out.println("Customer Name: " + rs.getString("CustomerName"));

				PreparedStatement pstmt2 = con.prepareStatement("\r\n"
						+ "SELECT Item.ItemID, ItemDescription, Quantity, UnitPrice, TotalPrice  ,InvoiceID FROM Item \r\n"
						+ "WHERE InvoiceID =?");

				pstmt2.setInt(1, InvoiceID);

				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					System.out.println("  Item ID: " + rs2.getInt("ItemID"));
					System.out.println("  Item Description: " + rs2.getString("ItemDescription"));
					System.out.println("  Quantity: " + rs2.getInt("Quantity"));
					System.out.println("  Unit Price: " + rs2.getDouble("UnitPrice"));
					System.out.println("  Total Price:" + rs2.getDouble("TotalPrice"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public static Map<String, Integer> initializeMenu() {
		Map<String, Integer> menuItems = new HashMap<>();
		menuItems.put("Shop Settings", 0);
		menuItems.put("Manage Shop Items", 0);
		menuItems.put("Create New Invoice", 0);
		menuItems.put("Report Statistics", 0);
		menuItems.put("Report All Invoices", 0);
		menuItems.put("Search Invoice", 0);
		menuItems.put("Program Statistics", 0);
		return menuItems;
	}

}

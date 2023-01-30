import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlQuries {

	public static void deleteItem(String url, String user, String pass) throws Throwable {

		String sql = "DELETE FROM Item WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id to be deleted : ");
		int id = sc.nextInt();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();

			System.out.println("Row with id " + id + " deleted successfully!");
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public static void updateItemPrice(String url, String user, String pass) throws Throwable {

		String sql = "UPDATE Item SET UnitPrice = ?  WHERE ItemID = ?";

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the item id : ");
		int ItemID = sc.nextInt();
		System.out.print("Enter the item Unit Price to be updated: ");
		double UnitPrice = sc.nextInt();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, UnitPrice);
			pstmt.setInt(2, ItemID);
			pstmt.executeQuery();

			System.out.println("Row with id " + ItemID + "  updated successfully!");
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public static void reportItem(String url, String user, String pass) throws Throwable {

		String sql = "SELECT * FROM Item";
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
				int itemID = rs.getInt("ItemID");
				String itemDescription = rs.getString("ItemDescription");
				int quantity = rs.getInt("Quantity");
				double unitPrice = rs.getDouble("UnitPrice");
				double totalPrice = rs.getDouble("TotalPrice");
				System.out.println("\n" + "Item ID  :" + itemID + "\n" + "Item description " + itemDescription + "\n"
						+ "Quantity :" + quantity + "\n" + "Unit Price :" + unitPrice + "\n" + "Total Price :"
						+ totalPrice + "\n");
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

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
}

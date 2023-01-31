import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Product {

	public static void InsertToItem(String url, String user, String pass) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Item Description:");
		String ItemDescription = br.readLine();
		System.out.print("Enter Quantity: ");
		int Quantity = sc.nextInt();
		System.out.print("Enter Unit Price: ");
		double unitPrice = sc.nextDouble();
		System.out.print("Enter Invoice ID: ");
		int InvoiceID = sc.nextInt();

		double totalPrice = Quantity * unitPrice;

		String sql = "INSERT INTO  Item (ItemDescription, Quantity,UnitPrice,TotalPrice,InvoiceID) VALUES (?,?,?,?,?)";

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
			statement.setInt(5, InvoiceID);
			statement.executeUpdate();
			System.out.println("Inserted Successfly");

		} catch (Exception e) {
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}

	}
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

}

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

}

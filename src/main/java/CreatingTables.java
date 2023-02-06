import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreatingTables {

	public static void creatingInvoiceTable(String url, String user, String pass) {

		String sql = "CREATE TABLE Invoice (\r\n" + "    InvoiceID int IDENTITY(1,1) PRIMARY KEY,\r\n"
				+ "    CustomerID int NOT NULL,\r\n" + "    InvoiceHeaderID int NOT NULL,\r\n"
				+ "    InvoiceDate date NOT NULL,\r\n" + "    TotalAmount decimal(18,2) NOT NULL,\r\n"
				+ "    PaidAmount decimal(18,2) NOT NULL,\r\n" + "    Balance decimal(18,2) NOT NULL,\r\n"
				+ "    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),\r\n"
				+ "    FOREIGN KEY (InvoiceHeaderID) REFERENCES InvoiceHeader(InvoiceHeaderID))";

		boolean success = SqlQuries.createTable(url, user, pass, sql);
		if (success) {
			System.out.println("Created successfully : " + sql);
		} else {
			System.out.println("creating table failed");
		}
	}

	public static void creatingItemTable(String url, String user, String pass) {

		String sql = "\r\n" + "CREATE TABLE Item (\r\n" + "    ItemID int IDENTITY(1,1) PRIMARY KEY,\r\n"
				+ "    ItemDescription varchar(255) NOT NULL,\r\n" + "    Quantity int NOT NULL,\r\n"
				+ "    UnitPrice decimal(18,2) NOT NULL,\r\n" + "    TotalPrice decimal(18,2) NOT NULL,  \r\n"
				+ "	InvoiceID int NOT NULL,\r\n" + "	FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID)\r\n"
				+ ")";

		boolean success = SqlQuries.createTable(url, user, pass, sql);
		if (success) {
			System.out.println("Created successfully : " + sql);
		} else {
			System.out.println("creating table failed");
		}

	}

	public static void creatingInvoiceItemTable(String url, String user, String pass) {

		String sql = "CREATE TABLE InvoiceItem (\r\n" + "    InvoiceItemID int IDENTITY(1,1) PRIMARY KEY,\r\n"
				+ "    InvoiceID int NOT NULL,\r\n" + "    ItemID int NOT NULL,\r\n"
				+ "    FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID),\r\n"
				+ "    FOREIGN KEY (ItemID) REFERENCES Item(ItemID)\r\n" + ")";

		boolean success = SqlQuries.createTable(url, user, pass, sql);
		if (success) {
			System.out.println("Created successfully : " + sql);
		} else {
			System.out.println("creating table failed");
		}
	}

	public static void creatingCustomerTable(String url, String user, String pass) {

		String sql = "CREATE TABLE Customer (\r\n" + "    CustomerID int IDENTITY(1,1) PRIMARY KEY,\r\n"
				+ "    CustomerName varchar(255) NOT NULL,\r\n" + "    PhoneNumber varchar(20) NOT NULL\r\n" + ")";

		boolean success = SqlQuries.createTable(url, user, pass, sql);
		if (success) {
			System.out.println("Created successfully : " + sql);
		} else {
			System.out.println("creating table failed");
		}
	}

	public static void creatingShopTable(String url, String user, String pass) {

		String sql = "CREATE TABLE Shop (\r\n" + "    ShopID int IDENTITY(1,1) PRIMARY KEY,\r\n"
				+ "    ShopName varchar(255) NOT NULL\r\n" + ")";

		boolean success = SqlQuries.createTable(url, user, pass, sql);
		if (success) {
			System.out.println("Created successfully : " + sql);
		} else {
			System.out.println("creating table failed");
		}
	}

	public static void creatingInvoiceHeaderTable(String url, String user, String pass) {

		String sql = "CREATE TABLE InvoiceHeader (\r\n" + "    InvoiceHeaderID int IDENTITY(1,1) PRIMARY KEY,\r\n"
				+ "    Tel varchar(20) NOT NULL,\r\n" + "    Fax varchar(20) NOT NULL,\r\n"
				+ "    Email varchar(255) NOT NULL,\r\n" + "    Website varchar(255) NOT NULL,\r\n"
				+ "    ShopID int NOT NULL,\r\n" + "    FOREIGN KEY (ShopID) REFERENCES Shop(ShopID)\r\n" + ")";

		boolean success = SqlQuries.createTable(url, user, pass, sql);
		if (success) {
			System.out.println("Created successfully : " + sql);
		} else {
			System.out.println("creating table failed");
		}
	}

}

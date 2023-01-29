import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean isExitMenu3 = true;

		while (isExitMenu3) {
			for (String x : Menu.superMenuList()) {
				System.out.println(x);
			}
			Integer num = sc.nextInt();

			switch (num) {

			case 1:
				boolean isExitMenu9 = true;
				while (isExitMenu9) {

					for (String x : Menu.shopMenuList()) {
						System.out.println(x);
					}
					int op = sc.nextInt();

					switch (op) {
					case 1:
						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						System.out.print(" Please Enter the database connection URL :\n");
						String url = br.readLine();
						System.out.print(" Please user name :");
						String user = br.readLine();
						System.out.print(" Please user password :");
						String pass = br.readLine();
						InsertToTables.InsertToItem(url, user, pass);
						break;

					case 2:

						break;

					case 3:
						isExitMenu9 = false;

						break;
					}

				}

				isExitMenu3 = true;

				break;

			case 2:
				boolean isExitMenu4 = true;
				while (isExitMenu4) {
					for (String x : Menu.itemMenuList()) {
						System.out.println(x);
					}
					int op = sc.nextInt();

					switch (op) {
					case 1:

						break;

					case 2:

						break;
					case 3:
						isExitMenu4 = false;

						break;
					}

				}

				isExitMenu3 = true;

				break;

			case 4:

				break;
			case 5:

				break;

			case 6:

				break;
			case 7:

				break;
			case 8:
				System.out.println("THANK YOU");
				isExitMenu3 = false;
				break;

			}
		}
	}

}

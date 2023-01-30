import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DatabaseCredentials {
	  private String url;
	  private String user;
	  private String pass;

	  public DatabaseCredentials() throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print(" Please Enter the database connection URL :\n");
	    this.url = br.readLine();
	    System.out.print(" Please user name :");
	    this.user = br.readLine();
	    System.out.print(" Please user password :");
	    this.pass = br.readLine();
	  }

	  public String getUrl() {
	    return url;
	  }

	  public String getUser() {
	    return user;
	  }

	  public String getPass() {
	    return pass;
	  }
	}




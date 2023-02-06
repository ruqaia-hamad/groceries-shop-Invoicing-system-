import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DatabaseCredentials {
	private String url;
	private String user;
	private String pass;

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}

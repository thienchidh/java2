import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
	public Connection createConnection() {

		String host = "localhost";
		String dbName = "finaltestjava";
		String username = "root";
		String password = "123456";

		final String strConnect = "jdbc:mysql://" + host + "/" + dbName;
		final Properties pro = new Properties();
		pro.put("user", username);
		pro.put("password", password);
		pro.put("useUnicode", "true");
		pro.put("characterEncoding", "UTF-8");
		pro.put("autoReconnect", "true");
		pro.put("useSSL", "false");

		try {
			return DriverManager.getConnection(strConnect, pro);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

	}
}

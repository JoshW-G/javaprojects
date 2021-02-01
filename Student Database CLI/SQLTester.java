package eeub10.project3;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTester {
	public static void main(String[] args) throws  ClassNotFoundException,SQLException, IOException {
		InputStream stream = SQLTester.class.getResourceAsStream("/database.properties");
		SimpleDataSource.init(stream);
		Connection conn = SimpleDataSource.getConnection();
		Statement st = conn.createStatement();
		
		try {
			st.execute(
					"CREATE TABLE IF NOT EXISTS accounts (balance DECIMAL(5,2))");
			st.execute(
					"INSERT INTO accounts VALUES (999.99)");
			st.execute(
					"INSERT INTO accounts VALUES (666.66)");
			
			
			ResultSet rs = st.executeQuery("SELECT * FROM accounts");
			
			while(rs.next()) {
				System.out.println(rs.getString("balance"));
			}
			
			st.execute("DROP TABLE accounts");
		
		} finally {
			System.out.println("Table created and then dropped!");
			st.close();
			conn.close();
		}
		//
	}
}
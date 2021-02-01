package eeub10.project3;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseMain {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		DatabaseManager m = new DatabaseManager();
		DatabaseTextInterface cli = new DatabaseTextInterface(m);
		
	}
}

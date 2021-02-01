package eeub10.project3;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagerTester {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		DatabaseManager m = new DatabaseManager();
		
		
		ResultSet rs = m.reports("modules" ,"E10010");
		System.out.printf("%-10s %-30s %-10s%n","module_Id","module_name","credits");
		while(rs.next()) {
			
			System.out.printf("%-10s %-30s %-10s%n", rs.getString("module_Id"), rs.getString("module_name"),rs.getString("credits"));
		
		}
	}
}
//http://www.sqlitetutorial.net/sqlite-java/delete/
package eeub10.project3;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseTextInterface {
		
	private static DatabaseManager manager;
	
		public DatabaseTextInterface(DatabaseManager m) throws ClassNotFoundException, IOException, SQLException {
			manager = m;
			
			
			menu();
			System.out.println("You have quit ");
			
		}

		private static void menu() throws SQLException {
			Scanner in = new Scanner(System.in);
			boolean quit = false;
			// TODO Auto-generated method stub
			while(quit ==false) {
			System.out.println("Main Menu\n************");
			System.out.print("\n1. Students\n2. Modules\n3. Registrations\n4. Reports\n0. Quit\n:>");
			int inp = in.nextInt();
			switch(inp){
			case 1:
				studentMenu();
				break;
			case 2:
				moduleMenu();
				break;
			case 3:
				regMenu();
				break;
			case 4:
				reportMenu();
				break;
			case 0:
				quit = true;
				break;
			}	
			}
				
		}

		private static void reportMenu() throws SQLException {
			Scanner in = new Scanner(System.in);
			boolean quit = false;
			String id;
			ResultSet rs;
			// TODO Auto-generated method stub
			while(quit  == false) {
				System.out.println("\nReports\n*******");
				System.out.print("1. Modules taught by\n2. Students registered on\n3. Staff who teach student\n4. Staff who teach more than\n0. Quit\n:>");
				int inp = in.nextInt();
				switch(inp) {
				case 1:
					System.out.print("Modules taught by\n************");
					System.out.print("\nStaff Name:> ");
					id = in.next();
					rs= manager.reports("modules" ,id);
					System.out.printf("%-10s %-30s %-10s%n","module_Id","module_name","credits");
					while(rs.next()) {
						
						System.out.printf("%-10s %-30s %-10s%n", rs.getString("module_Id"), rs.getString("module_name"),rs.getString("credits"));
					
					}
					break;
				case 2:
					System.out.print("\nStudents registered on\n************");
					System.out.print("Module ID:> ");
					id = in.next();
					rs = manager.reports("students" ,id);
					System.out.printf("%-15s %-20s %-20s%n","student_Id","student_name","degree_scheme");
					while(rs.next()) {
						System.out.printf("%-15s %-20s %-20s%n", rs.getString("student_Id"), rs.getString("student_name"),rs.getString("degree_scheme"));
					}
					break;
				case 3:
					System.out.print("\nStaff who teach student\n************");
					System.out.print("Student ID:> ");
					id = in.next();
					rs = manager.reports("staffTeachStu" ,id);
					System.out.printf("%-15s %-15s %-15s%n","staff_Id","staff_name","staff_grade");
					while(rs.next()) {
						System.out.printf("%-15s %-15s %-15s%n", rs.getString("staff_Id"), rs.getString("staff_name"),rs.getString("staff_grade"));
					}
					break;
				case 4:
					System.out.println("Staff who teach more than\n************");
					System.out.print("No. Modules:> ");
					id = in.next();
					
					rs = manager.reports("staffTeachMore" ,id);
					System.out.printf("%-15s %-15s %-15s%n","staff_Id","staff_name","staff_grade");
					while(rs.next()) {
						System.out.printf("%-15s %-15s %-15s%n", rs.getString("staff_Id"), rs.getString("staff_name"),rs.getString("staff_grade"));
					}
				
					break;
				case 0:
					quit = true;
					break;
				}
			}
		}

		private static void regMenu() throws SQLException {
			Scanner in = new Scanner(System.in);
			
			boolean quit = false;
			while(quit ==false) {
				System.out.print("\nSub-Menu (Registration)\n************");
				System.out.print("\n1. Add Registration\n2. Remove Registration\n3. List Registration \n0. Quit\n:>");
				int inp = in.nextInt();
				String stu_id;
				String mod_id;
				ResultSet rs;
				switch(inp) {
				case 1:
					System.out.print("\nAdd Registration\n************");
					System.out.print("Student ID:> ");
					stu_id = in.next();
					System.out.print("Module ID:> ");
					mod_id = in.next();
					manager.addRow("registered", stu_id, mod_id, null);
					break;
				case 2:
					System.out.print("\nRemove Registration\n************");
					System.out.print("Student ID:> ");
					stu_id = in.next();
					System.out.print("Module ID:> ");
					mod_id = in.next();
					manager.removeRow("module", stu_id,mod_id);
					break;
				case 3:
					rs = manager.getTable("registered");
					System.out.println("Table: registered\nstudent_Id\tmodule_Id");
					while(rs.next()) {
						System.out.println(rs.getString("student_Id") + "\t" + rs.getString("module_Id"));
					}
					break;
			
				case 0:
					quit = true;
					break;
					
				}
			}	
		}

		private static void moduleMenu() throws SQLException {
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			boolean quit = false;
			while(quit ==false) {
				System.out.println("\nSub-Menu (Modules)\n************");
				System.out.print("\n1. Add Module\n2. Remove Module\n3. Update Module\n4. List Modules\n0. Quit\n:>");
				int inp = in.nextInt();
				String id;
				String credit;
				ResultSet rs;
				switch(inp) {
				case 1:
					System.out.println("\nAdd Module\n************");
					System.out.print("Module ID:> ");
					id = in.next();
					System.out.print("Module Name:> ");
					String name = in.next();
					System.out.print("Module Credits:> ");
					credit = in.next();
					manager.addRow("module", id, name, credit);
					break;
				case 2:
					System.out.println("\nRemove Module\n************");
					System.out.print("Module ID:> ");
					id = in.next();
					manager.removeRow("module", id, null);
					break;
				case 3:
					System.out.println("\nUpdate Module\n************");
					System.out.print("Module ID:> ");
					id = in.next();
					System.out.print("Update Module Credits:> ");
					credit = in.next();
					manager.updateRow("module", id, credit);
					break;
				case 4:
					
					rs =manager.getTable("module");
					System.out.println("\nTable: module\nmodule_Id\tmodule_name\tcredits");
					while(rs.next()) {
						System.out.println(rs.getString("module_Id") + "\t" + rs.getString("module_name") + "\t" + rs.getString("credits"));
					}
					break;
				case 0:
					quit = true;
					break;
				}
			}
		}

		private static void studentMenu() throws SQLException {
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			ResultSet rs;
			boolean quit = false;
			while(quit ==false) {
			System.out.println("\nSub-Menu (Students)\n************");
			System.out.print("\n1. Add Students\n2. Remove Student\n3. Update Student\n4. List Students\n0. Return to Main Menu\n:>");
			int inp = in.nextInt();
			switch(inp){
			case 1:
				System.out.println("\nAdd Student\n************");
				System.out.print("Student ID:> ");
				String id = in.next();
				System.out.print("Student Name:> ");
				String name = in.next();
				System.out.print("Degree Scheme:> ");
				String degree = in.next();
				manager.addRow("student", id, name, degree);
				break;
			case 2:
				System.out.println("\nRemove Student\n************");
				System.out.print("Student ID:> ");
				id = in.next();
				manager.removeRow("student", id, null);
				break;
			case 3:
				System.out.println("\nUpdate Student\n************");
				System.out.print("Student ID:> ");
				id = in.next();
				System.out.print("Update Student Degree:> ");
				degree = in.next();
				manager.updateRow("student", id, degree);
				break;
			case 4:
				
				rs = manager.getTable("student");
				System.out.println("\nTable: student\nstudent_Id\tstudent_name\tdegree_scheme");
				while(rs.next()) {
					System.out.println(rs.getString("student_Id") +"\t\t"+ rs.getString("student_name")+"\t\t"+rs.getString("degree_scheme"));
				}
				break;
			case 0:
				quit = true;
				break;
				
			}
		}
		}

		

		
}

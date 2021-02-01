package eeub10.project3;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	
	private Connection conn;
	
	
	public DatabaseManager() throws ClassNotFoundException, IOException, SQLException {
		
		InputStream stream = DatabaseManager.class.getResourceAsStream("/database.properties");
		SimpleDataSource source = new SimpleDataSource();
		source.init(stream);
		conn = source.getConnection();
		
	}
	
	/**
	 * 
	 * @param tableName name of the table
	 * @param id unique identifier of the row
	 * @param name name
	 * @param desc
	 * @throws SQLException
	 */
	public void addRow(String tableName,String id, String name, String desc) throws SQLException {
		PreparedStatement stmt;
		switch(tableName) {
		case "student":
			 stmt = conn.prepareStatement("INSERT INTO student VALUES(?,?,?)");
			 stmt.setString(1, id);
			 stmt.setString(2,name);
			 stmt.setString(3, desc);
			 stmt.executeUpdate();
			break;
		case "registered":
			stmt = conn.prepareStatement("INSERT INTO registered VALUES(?,?)");
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.executeUpdate();
			break;
		case "teaches":
			stmt = conn.prepareStatement("INSERT INTO teaches VALUES(?,?)");
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.executeUpdate();
			break;
		case "staff":
			stmt = conn.prepareStatement("INSERT INTO staff VALUES(?,?,?)");
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, desc);
			stmt.executeUpdate();
			break;
		case "module":
			stmt = conn.prepareStatement("INSERT INTO module VALUES(?,?,?)");
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setShort(3, Short.parseShort(desc));
			stmt.executeUpdate();
			break;
		}
		
	}
	
	
	/**
	 * 
	 * @param tableName name of the table 
	 * @param colName name of the column
	 * @param value value related to the column to delete by
	 * @throws SQLException
	 */
	public void removeRow(String tableName,String id,String id_2) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		switch(tableName) {
		case "student":
			 stmt = conn.prepareStatement("DELETE FROM student WHERE student_Id = ?");
			 stmt.setString(1, id);
			 stmt.executeUpdate();
			break;
		case "registered":
			stmt = conn.prepareStatement("DELETE FROM registered WHERE student_Id = ? AND module_Id = ?");
			stmt.setString(1, id);
			stmt.setString(2, id_2);
			stmt.executeUpdate();
			break;
		case "teaches":
			stmt = conn.prepareStatement("DELETE FROM registered WHERE staff_Id = ? AND module_Id = ?");
			stmt.setString(1, id);
			stmt.setString(2,id_2);
			stmt.executeUpdate();
			break;
		case "staff":
			stmt = conn.prepareStatement("DELETE FROM staff WHERE staff_Id = ?");
			stmt.setString(1, id);
			stmt.executeUpdate();
			break;
		case "module":
			stmt = conn.prepareStatement("DELETE FROM module WHERE module_Id = ? ");
			stmt.setString(1, id);
			stmt.executeUpdate();
			break;
		}
		
	}
	
	
	/**
	 * 
	 * @param tableName
	 * @param id
	 * @param desc
	 * @throws SQLException 
	 */
	public void updateRow(String tableName, String id, String desc) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		switch(tableName) {
		case "student":
			 stmt = conn.prepareStatement("UPDATE student SET degree_scheme = ? WHERE student_Id = ? ");
			 stmt.setString(1, desc);
			 stmt.setString(2, id);
			 stmt.executeUpdate();
			break;
		case "staff":
			stmt = conn.prepareStatement("UPDATE staff SET staff_grade = ? WHERE staff_Id = ?");
			stmt.setString(1, desc);
			stmt.setString(2,id);
			stmt.executeUpdate();
			break;
		case "module":
			stmt = conn.prepareStatement("UPDATE module SET credits = ? WHERE module_Id = ?");
			stmt.setString(1, desc);
			stmt.setString(2, id);
			stmt.executeUpdate();
			break;
		}
	}
	
	/**
	 * 
	 * @param tableName
	 * @param id
	 * @throws SQLException 
	 */
	public ResultSet getRow(String tableName, String id) throws SQLException {
		
		PreparedStatement st;
		ResultSet rs;
		switch(tableName) {
		case "student":
			st = conn.prepareStatement("SELECT * FROM student WHERE student_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "regStu"://get module that student is registered to
			st = conn.prepareStatement("SELECT * FROM registered WHERE student_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "regMod": //get students who are registered to what module
			st = conn.prepareStatement("SELECT * FROM registered WHERE module_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "teaches": //get modules that are taught by 
			st = conn.prepareStatement("SELECT * FROM teaches WHERE staff_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "teachesMod"://get who teaches which module
			st = conn.prepareStatement("SELECT * FROM teaches WHERE module_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "staff":
			st = conn.prepareStatement("SELECT * FROM staff WHERE staff_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "module":
			st = conn.prepareStatement("SELECT * FROM module WHERE module_id = ?");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		default:
			return rs = null;
		
		}
		
	}
	
	/**
	 * 
	 * @param tableName
	 * @throws SQLException 
	 */
	public ResultSet getTable(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		//String sql;
		Statement st = conn.createStatement();
		ResultSet rs;
		switch(tableName) {
		case "student":
			 rs= st.executeQuery("SELECT * FROM student");
			 return rs;
		case "registered":
			rs = st.executeQuery("SELECT * FROM registered");
			return rs;
		case "teaches":
			rs = st.executeQuery("SELECT * FROM teaches");
			return rs;
		case "staff":
			rs = st.executeQuery("SELECT * FROM staff");
			return rs;
		case "module":
			rs = st.executeQuery("SELECT * FROM module");
			return rs;
		default:
			return rs = null;
		}
	}
	
	public ResultSet reports(String reportName, String id) throws SQLException {
		PreparedStatement st;
		ResultSet rs;
		switch(reportName) {
		case "modules":
			st = conn.prepareStatement("SELECT * FROM module WHERE module_Id IN (SELECT module_Id FROM teaches WHERE staff_name = ?)");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "students":
			st = conn.prepareStatement("SELECT * FROM student WHERE student_Id IN (SELECT student_Id FROM registered WHERE module_Id = ?)");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "staffTeachStu":
			st = conn.prepareStatement("SELECT * FROM staff WHERE staff_Id IN (SELECT staff_Id FROM teaches WHERE module_Id IN (SELECT module_Id FROM registered WHERE student_ID = ? ))");
			st.setString(1, id);
			rs = st.executeQuery();
			return rs;
		case "staffTeachMore":
			st = conn.prepareStatement("SELECT * FROM staff WHERE staff_Id IN ( SELECT staff_Id FROM teaches GROUP BY staff_Id HAVING COUNT(*) > ?)");
			st.setInt(1, Integer.parseInt(id));
			rs = st.executeQuery();
			return rs;
		default:
			return rs = null;
			
		}
		
		
	}

	
	
	
}


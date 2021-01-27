package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjSql {
	
	private static final String DBName = "java";
	private static final String USERNAME = "java";
	private static final String PASSWORD = "java";
	
	private static String url = "jdbc:mysql://dbMY:3306/"+DBName
			+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static Connection dbConnection = null;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	private List<Object> response;
	
	public ObjSql() {}
	private void closeMysql() {
		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void openMysql() {
		try {

			Class.forName(driver);

			
			dbConnection = DriverManager.getConnection(url, USERNAME, PASSWORD);


		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public  List<Object> getResponse() {
		return this.response;
	}
	public boolean sql(String updateTableSQL,Object []x) {
		
		response=new ArrayList<>();
		this.openMysql();
		
		java.sql.PreparedStatement cmd = null;
		boolean success = true;
		Integer counter = 0;
		
		try {
			cmd = dbConnection.prepareStatement(updateTableSQL);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for(Object obj : x) {
			try {
				
				if(obj.getClass().getTypeName().toString().matches(".*String\\s*\\[.*")) {
					//string array, quindi array di date
					String[] Obj =(String[])obj;
					cmd.setDate(++counter,(java.sql.Date) new JavaDate()
							.convert(Obj[0], Obj[1], Obj[2]));
				}else if(obj.getClass().getTypeName().toString().matches(".*String.*")) {
					//add string
					cmd.setString(++counter,(String) obj);
				}else if(obj.getClass().getTypeName().toString().matches(".*Integer.*")) {
					//add int
					cmd.setInt(++counter,(Integer) obj);
				}else if(obj.getClass().getTypeName().toString().matches(".*Boolean.*")) {
					//add int
					cmd.setBoolean(++counter,(Boolean) obj);
				}else {
					// dev'esserci un errore
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
				success=false;
			}
		}
		
		try {
			cmd.execute();
			
			ResultSet rs =cmd.getResultSet();
			if(rs!=null) {
				ResultSetMetaData md = rs.getMetaData();
				Integer colonne = md.getColumnCount();
				
				while(rs.next()) {
					Object []oggetto = new Object[colonne];
					for(int i = 1;i<=colonne;i++) {
						oggetto[i-1]=rs.getObject(i);
					}
					response.add(oggetto);
				}
			}
			
			
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
			success=false;
		}
		
		this.closeMysql();
	
		return success;
	}
}

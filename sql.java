import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=jxsk";//jxsk是数据库名
		String userName="SQL_User";//用户名
		String userPwd="123456";//密码
		
		Connection dbConn = null;
		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动失败");

		}
		try {
			dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("连接成功");
		} catch (SQLException e) {
			System.out.println("连接失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查看数据库中表的数据
		Statement sql;
		ResultSet rs;
		try {
			sql = dbConn.createStatement();
			rs = sql.executeQuery("SELECT* FROM dbo.S");//SQL查询语句
			while (rs.next()) {
				String TN = rs.getString(2);
				System.out.printf("%s\t", TN);

			}
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
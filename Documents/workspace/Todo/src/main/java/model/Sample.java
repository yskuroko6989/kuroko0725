package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Sample {

	String url = DB_CONNECT.getURL();
	String db_name = DB_CONNECT.getDB_NAME();
	String db_pass = DB_CONNECT.getDB_PASS();

	//Todoリスト一覧表示します
	public List<MutterList> execute(MutterList m){

	List<MutterList> mutterList = new ArrayList<MutterList>();
	try(Connection con = DriverManager.getConnection(url,db_name, db_pass)){
		String sql = "SELECT * FROM todo ORDER BY day ASC";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id");
			String text = rs.getString("content");
			String date = rs.getString("day");
			m = new MutterList(id, text, date);
			mutterList.add(m);
		}



	}catch(SQLException e) {
		e.printStackTrace();

	}
	return mutterList;

	}

	//ToDoリストの追加・削除の処理
	public void test(int mode,MutterList m) {
		if(mode == 1) {
			try(Connection con = DriverManager.getConnection(url,db_name, db_pass)){
				String sql = "INSERT INTO todo(content,day) VALUES(?,?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, m.getText());
				pst.setString(2, (String)m.getDate());
			pst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}


		}else if(mode == 2) {

			try(Connection con = DriverManager.getConnection(url,db_name, db_pass)){
				String sql = "DELETE FROM todo WHERE id = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, m.getId());
				pst.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

}
}

package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBUtil;



public class Delete {

	public boolean deleteUser(String table,String id)
	{
		boolean c=false;
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		String sql="delete from "+table+" where username=?";
		System.out.println(sql);
		try {
			state=conn.prepareStatement(sql);
			state.setString(1,id);
			int num = state.executeUpdate();
			if(num!=0)
			{
				c= true;
			}
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}

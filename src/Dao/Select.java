package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.PowerBean;
import Bean.TableBean;
import Bean.UserBean;
import DB.DBUtil;

public class Select {
	public PowerBean  SelectPower(String name)
	{
		PowerBean pb=new PowerBean();
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select power,xqzj_qx,xqgl_qx,yhxx_qx,yhxg_qx,xssh_qx,bmsh_qx,tjcx_qx from power where name = '"+name+"';";
			System.out.println(sql);
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("??");
				pb.setPower(rs.getInt(1));
				pb.setXqzj_qx(rs.getInt(2));
				pb.setXqgl_qx(rs.getInt(3));
				pb.setYhxx_qx(rs.getInt(4));
				pb.setYhxg_qx(rs.getInt(5));
				pb.setXssh_qx(rs.getInt(6));
				pb.setBmsh_qx(rs.getInt(7));
				pb.setTjcx_qx(rs.getInt(8));
				
			}
			rs.close();
			state.close();
			conn.close();
		
		}
		catch(Exception e)
		{
			
		}
		return pb;
	}
	public boolean SelectLogin(String username,String password)
	{
		boolean flag=false;
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select * from user where username = '"+username+"' and password = '"+password+"'";
			System.out.println(sql);
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				flag =true;
			}
			rs.close();
			state.close();
			conn.close();
		
		}
		catch(Exception e)
		{
			
		}
		return flag;
	}
	
	public UserBean SelectUser(String username)
	{
		UserBean ub=new UserBean();
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select * from user where username = '"+username+"'";
			System.out.println(sql);
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				ub.setUsername(rs.getString(1));
				ub.setPassword(rs.getString(2));
				ub.setName(rs.getString(3));
				ub.setSfzh(rs.getString(4));
				ub.setSex(rs.getString(5));
				ub.setBm(rs.getString(6));
				ub.setSheng(rs.getString(7));
				ub.setShi(rs.getString(8));
				ub.setGzdw(rs.getString(9));
				ub.setZyfx(rs.getString(10));
				ub.setSzhy(rs.getString(11));
				ub.setJycd(rs.getString(12));
				ub.setZc(rs.getString(13));
				ub.setTxdz(rs.getString(14));
				ub.setYzbm(rs.getString(15));
				ub.setSj(rs.getString(16));
				ub.setGddh(rs.getString(17));
				ub.setYx(rs.getString(18));
				ub.setQq(rs.getString(19));
				ub.setRole(rs.getString(20));
				ub.setStatus(rs.getString(21));
			}
			rs.close();
			state.close();
			conn.close();
		
		}
		catch(Exception e)
		{
			
		}
		return ub;
	}
	
	public TableBean SelectTable(String id)
	{
		TableBean tb=new TableBean();
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select * from book where id = '"+id+"'";
			System.out.println(sql);
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				tb.setId(id);
				tb.setXssh(rs.getString(3));
				tb.setXsshyj(rs.getString(4));
				tb.setBmsh(rs.getString(5));
				tb.setBmshyj(rs.getString(6));
				tb.setJgqc(rs.getString(7));
				tb.setGkglbm(rs.getString(8));
				tb.setTxdz(rs.getString(9));
				tb.setSzdy(rs.getString(10));
				tb.setWz(rs.getString(11));
				tb.setDzyx(rs.getString(12));
				tb.setFrdb(rs.getString(13));
				tb.setYzbm(rs.getString(14));
				tb.setLxr(rs.getString(15));
				tb.setGddh(rs.getString(16));
				tb.setYddh(rs.getString(17));
				tb.setCz(rs.getString(18));
				tb.setJgsx(rs.getString(19));
				tb.setJgjj(rs.getString(20));
				tb.setJsxqmc(rs.getString(21));
				tb.setQsnf(rs.getString(22));
				tb.setJznf(rs.getString(23));
				tb.setZywt(rs.getString(24));
				tb.setJsgj(rs.getString(25));
				tb.setYqmb(rs.getString(26));
				tb.setGjz(rs.getString(27));
				tb.setNtrzjze(rs.getString(28));
				tb.setJsxqjjfs(rs.getString(29));
				tb.setHzyxdw(rs.getString(30));
				tb.setKjhdlx(rs.getString(31));
				tb.setXkfl(rs.getString(32));
				tb.setXqjsssly(rs.getString(33));
				tb.setXqjsyyhy(rs.getString(34));
				
			}
			rs.close();
			state.close();
			conn.close();
		
		}
		catch(Exception e)
		{
			
		}
		return tb;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//学科分类三级联动
	
	
	
	public static void main(String[] args) {
		Select s=new Select();
		s.SelectPower("123");
	}

}

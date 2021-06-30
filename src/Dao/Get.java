package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Bean.Ajax_RoleBean;
import Bean.PowerBean;
import Bean.SJBean;
import Bean.TableBean;
import Bean.UserBean;
import DB.DBUtil;
import java.util.Map;



public class Get {
	//统计查询获取搜索内容的全部信息
	public static List<TableBean> getAllBook(String table,String name[],String value[],String flag1[],String flag2[],int n)
	{
		List<TableBean> list=new ArrayList<TableBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		//String sql="select * from "+table+" where create_date like'%"+value+"%'";
		String sql="select id,jsxqmc,kjhdlx,xssh,bmsh from "+table+" where";
		/*
		 * for(int i=0;i<n;i++) { if(flag1[i].equals("binghan")) {
		 * if(flag2[i].equals("jingque")) { sql+=" "+name[i]+" ='"+value[i]+"'"; } else
		 * { sql+=" "+name[i]+" like'%"+value[i]+"%'"; } if(i==n-1) { break; } else {
		 * sql+=" and"; } } else { if(flag2[i].equals("jingque")) {
		 * sql+=" "+name[i]+" ='"+value[i]+"'"; } else {
		 * sql+=" "+name[i]+" like'%"+value[i]+"%'"; } if(i==n-1) { break; } else {
		 * sql+=" or"; } } }
		 */
		for(int i=0;i<n;i++)
		{
			if(flag2[i].equals("jingque"))
			{
				sql+=" "+name[i]+" ='"+value[i]+"'";
				if(i==n-1)
				{
					break;
				}
				else
				{
					if(flag1[i].equals("binghan"))
					{
						sql+=" and ";
					}
					else
					{
						sql+=" or";
					}
				}
				
			}
			else
			{
				sql+=" "+name[i]+" like'%"+value[i]+"%'";
				if(i==n-1)
				{
					break;
				}
				else
				{
					if(flag1[i].equals("binghan"))
					{
						sql+=" and ";
					}
					else
					{
						sql+=" or";
					}
				}
			}
		}
		try
		{
			System.out.println(sql);
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1));
					TableBean tb=new TableBean();
					tb.setId(rs.getString(1));
					tb.setJsxqmc(rs.getString(2));
					tb.setKjhdlx(rs.getString(3));
					tb.setXssh(rs.getString(4));
					tb.setBmsh(rs.getString(5));
					list.add(tb);
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	//个人查询，只能获取自己的信息
	public static List<TableBean> getMyBook(String username,String table,String name[],String value[],String flag1[],String flag2[],int n)
	{
		List<TableBean> list=new ArrayList<TableBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		//String sql="select * from "+table+" where create_date like'%"+value+"%'";
		String sql="select id,jsxqmc,kjhdlx,xssh,bmsh from "+table+" where username='"+username+"' and";
		/*
		 * for(int i=0;i<n;i++) { if(flag1[i].equals("binghan")) {
		 * if(flag2[i].equals("jingque")) { sql+=" "+name[i]+" ='"+value[i]+"'"; } else
		 * { sql+=" "+name[i]+" like'%"+value[i]+"%'"; } if(i==n-1) { break; } else {
		 * sql+=" and"; } } else { if(flag2[i].equals("jingque")) {
		 * sql+=" "+name[i]+" ='"+value[i]+"'"; } else {
		 * sql+=" "+name[i]+" like'%"+value[i]+"%'"; } if(i==n-1) { break; } else {
		 * sql+=" or"; } } }
		 */
		for(int i=0;i<n;i++)
		{
			if(flag2[i].equals("jingque"))
			{
				sql+=" "+name[i]+" ='"+value[i]+"'";
				if(i==n-1)
				{
					break;
				}
				else
				{
					if(flag1[i].equals("binghan"))
					{
						sql+=" and ";
					}
					else
					{
						sql+=" or";
					}
				}
				
			}
			else
			{
				sql+=" "+name[i]+" like'%"+value[i]+"%'";
				if(i==n-1)
				{
					break;
				}
				else
				{
					if(flag1[i].equals("binghan"))
					{
						sql+=" and ";
					}
					else
					{
						sql+=" or";
					}
				}
			}
		}
		try
		{
			System.out.println(sql);
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1));
					TableBean tb=new TableBean();
					tb.setId(rs.getString(1));
					tb.setJsxqmc(rs.getString(2));
					tb.setKjhdlx(rs.getString(3));
					tb.setXssh(rs.getString(4));
					tb.setBmsh(rs.getString(5));
					list.add(tb);
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	public static List<UserBean> getUser(String username)
	{
		List<UserBean> list=new ArrayList<UserBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select username,gzdw,role from user where username like '%"+username+"%'";
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
					UserBean ub=new UserBean();
					ub.setUsername(rs.getString(1));
					ub.setGzdw(rs.getString(2));
					ub.setRole(rs.getString(3));
					
					list.add(ub);
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	public static List<PowerBean> getPower(String name)
	{
		List<PowerBean> list=new ArrayList<PowerBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from power where name like '%"+name+"%'";
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
				PowerBean pb=new PowerBean();
				pb.setName(rs.getString(1));
				pb.setXqzj_qx(rs.getInt(2));
				pb.setXqgl_qx(rs.getInt(3));
				pb.setYhxx_qx(rs.getInt(4));
				pb.setYhxg_qx(rs.getInt(5));
				pb.setXssh_qx(rs.getInt(6));
				pb.setBmsh_qx(rs.getInt(7));
				pb.setTjcx_qx(rs.getInt(8));
				list.add(pb);
				System.out.println(pb.getName());
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	public static List<TableBean> getTableXssh(String kjhdlx)
	{
		List<TableBean> list=new ArrayList<TableBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select id,jsxqmc,kjhdlx,qsnf from book where kjhdlx like '%"+kjhdlx+"%' and xssh ='未审核'";
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
				TableBean tb=new TableBean();
				tb.setId(rs.getString(1));
				tb.setJsxqmc(rs.getString(2));
				tb.setKjhdlx(rs.getString(3));
				tb.setQsnf(rs.getString(4));
				
				list.add(tb);
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	public static List<TableBean> getTableBmsh(String kjhdlx,String shbm)
	{
		List<TableBean> list=new ArrayList<TableBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select id,jsxqmc,kjhdlx,qsnf from book where kjhdlx like '%"+kjhdlx+"%' and bmsh ='未审核' and xssh='通过' and shbm='"+shbm+"'";
		System.out.println(sql);
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
				TableBean tb=new TableBean();
				tb.setId(rs.getString(1));
				tb.setJsxqmc(rs.getString(2));
				tb.setKjhdlx(rs.getString(3));
				tb.setQsnf(rs.getString(4));
				
				list.add(tb);
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//学科分类三级联动
	public static List<SJBean> getSJ(String table,String lie,String lie0,String value)
	{
		List<SJBean> list=new ArrayList<SJBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select distinct "+lie+" from "+table+" where "+lie0+" ='"+value+"'";
		System.out.println(sql);
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
				
				SJBean sj=new SJBean();
				sj.setTwo(rs.getString(1));
				sj.setThree(rs.getString(1));
				list.add(sj);
				
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	
	//ChangeUser中角色下拉框获取信息
	public static List<Ajax_RoleBean> getRole(String table)
	{
		List<Ajax_RoleBean> list=new ArrayList<Ajax_RoleBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select name from "+table;
		System.out.println(sql);
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
				
				Ajax_RoleBean arb=new Ajax_RoleBean();
				arb.setRole(rs.getString(1));
				list.add(arb);
				
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	
	
	//统计查询图表中的value和name值查询      
	public static List getAllNameValue(String table,String name[],String value[],String flag1[],String flag2[],int n)
	{
		List list =new ArrayList();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		//String sql="select * from "+table+" where create_date like'%"+value+"%'";
		String sql="select kjhdlx,count(*) from "+table+" where";
		/*
		 * for(int i=0;i<n;i++) { if(flag1[i].equals("binghan")) {
		 * if(flag2[i].equals("jingque")) { sql+=" "+name[i]+" ='"+value[i]+"'"; } else
		 * { sql+=" "+name[i]+" like'%"+value[i]+"%'"; } if(i==n-1) { break; } else {
		 * sql+=" and"; } } else { if(flag2[i].equals("jingque")) {
		 * sql+=" "+name[i]+" ='"+value[i]+"'"; } else {
		 * sql+=" "+name[i]+" like'%"+value[i]+"%'"; } if(i==n-1) { break; } else {
		 * sql+=" or"; } } }
		 */
		for(int i=0;i<n;i++)
		{
			if(flag2[i].equals("jingque"))
			{
				sql+=" "+name[i]+" ='"+value[i]+"'";
				if(i==n-1)
				{
					break;
				}
				else
				{
					if(flag1[i].equals("binghan"))
					{
						sql+=" and ";
					}
					else
					{
						sql+=" or";
					}
				}
				
			}
			else
			{
				sql+=" "+name[i]+" like'%"+value[i]+"%'";
				if(i==n-1)
				{
					break;
				}
				else
				{
					if(flag1[i].equals("binghan"))
					{
						sql+=" and ";
					}
					else
					{
						sql+=" or";
					}
				}
			}
		}
		try
		{
			sql +=" group by kjhdlx";
			System.out.println(sql);
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			
			while(rs.next())
			{
				Map<String, Object> map = new HashMap<String, Object>();
		        map.put("name",rs.getString(1));
		        map.put("value",rs.getString(2));
		        list.add(map);
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}
	
	
}

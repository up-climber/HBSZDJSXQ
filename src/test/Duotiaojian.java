package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBUtil;

public class Duotiaojian {
	
	
	public static List<Service> getAll(String table,String name[],String value[],String flag1[],String flag2[],int n)
	{
		List<Service> list=new ArrayList<Service>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		
		//String sql="select * from "+table+" where create_date like'%"+value+"%'";
		String sql="select * from "+table+" where";
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
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			System.out.println(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
					/*Service user=new Service();
					user.setId(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSalt(rs.getInt(4));
					user.setTime(rs.getString(5));
					
					list.add(user);*/
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



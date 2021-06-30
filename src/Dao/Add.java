package Dao;

import Bean.PowerBean;
import Bean.TableBean;
import Bean.UserBean;
import DB.DBUtil;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {
	

	
	public boolean AddUser(String table,UserBean ub)
	{
		boolean c=false;
		String sql="insert into "+table+" values('"+ub.getUsername()+"','"+ub.getPassword()+"','"+ub.getName()+"','"+ub.getSfzh()+"','"+ub.getSex()+"','"+ub.getBm()+"','"+ub.getSheng()+"','"+ub.getShi()+"','"+ub.getGzdw() +"','"+ub.getZyfx()+"','"+ub.getSzhy()+"','"+ub.getJycd()+"','"+ub.getZc()+"','"+ub.getTxdz()+"','"+ub.getYzbm()+"','"+ub.getSj()+"','"+ub.getGddh()+"','"+ub.getYx()+"','"+ub.getQq()+"','"+ub.getRole()+"','"+ub.getStatus()+"');";               
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			int num=state.executeUpdate(sql);
			if(num!=0)
				c=true;
			
			
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		return c;
		
	}
	public boolean AddTable(String table,TableBean tb)
	{
		boolean c=false;
		String sql="insert into "+table+" (username,xssh,xsshyj,bmsh,bmshyj,jgqc,gkglbm,txdz,szdy,wz,dzyx,frdb,yzbm,lxr,gddh,yddh,cz,jgsx,jgjj,jsxqmc,qsnf,jznf,zywt,jsgj,yqmb,gjz,ntrzjze,jsxqjjfs,hzyxdw,kjhdlx,xkfl,xqjsssly,xqjsyyhy,status,shbm) values('"+tb.getUsername()+"','"+tb.getXssh()+"','"+tb.getXsshyj()+"','"+tb.getBmsh()+"','"+tb.getBmshyj()+"','"+tb.getJgqc()+"','"+tb.getGkglbm()+"','"+tb.getTxdz()+"','"+tb.getSzdy()+"','"+tb.getWz()+"','"+tb.getDzyx()+"','"+tb.getFrdb()+"','"+tb.getYzbm()+"','"+tb.getLxr()+"','"+tb.getGddh()+"','"+tb.getYddh()+"','"+tb.getCz()+"','"+tb.getJgsx()+"','"+tb.getJgjj()+"','"+tb.getJsxqmc()+"','"+tb.getQsnf()+"','"+tb.getJznf()+"','"+tb.getZywt()+"','"+tb.getJsgj()+"','"+tb.getYqmb()+"','"+tb.getGjz()+"','"+tb.getNtrzjze()+"','"+tb.getJsxqjjfs()+"','"+tb.getHzyxdw()+"','"+tb.getKjhdlx()+"','"+tb.getXkfl()+"','"+tb.getXqjsssly()+"','"+tb.getXqjsyyhy()+"','"+tb.getStatus()+"','"+tb.getShbm()+"');";               
		System.out.println(sql);
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			int num=state.executeUpdate(sql);
			if(num!=0)
				c=true;
			
			
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		return c;
	}
	public boolean AddPower(String table,PowerBean pb)
	{
		boolean c=false;
		String sql="insert into "+table+" values('"+pb.getName()+"','"+pb.getXqzj_qx()+"','"+pb.getXqgl_qx()+"','"+pb.getYhxx_qx()+"','"+pb.getYhxg_qx()+"','"+pb.getXssh_qx()+"','"+pb.getBmsh_qx()+"','"+pb.getTjcx_qx()+"','"+pb.getPower()+"');";               
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			int num=state.executeUpdate(sql);
			if(num!=0)
				c=true;
			
			
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		return c;
		
	}

    public static void main(String[] args) {
		
		/*
		 * Add a=new Add(); UserBean ub=new UserBean(); ub.setUsername("123");
		 * ub.setPower(1); ub.setYhxg_qx(1); ub.setYhxx_qx(1); ub.setXqgl_qx(1);
		 * ub.setXqzj_qx(1); a.AddUser("user",ub);
		 */
		
		/*
		 * Add a=new Add(); TableBean tb=new TableBean(); tb.setJgqc("W cao");
		 * a.AddTable("book", tb);
		 */
	}

}

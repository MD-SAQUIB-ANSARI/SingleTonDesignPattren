package com.mypack.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.saquib.bean.EmpBean;


public class EmpDao {
	
	private Connection conn;
	private PreparedStatement pst;
	private String sql;
	//String driverName="com.mysql.cj.jdbc.Driver";	
	//String url="jdbc:mysql://localhost:3306/sagar";
	//String username="root";
	//String password="root";
	ResultSet rs;
	public EmpDao() throws ClassNotFoundException, SQLException, IOException{
		//ab na hi driver ko load krne ki req hai, na hi connection ko stablish krne ki req hai(baar- baar)
		conn=MyConnection.getConnection();	
	}
	public int addRecord(EmpBean emp) throws SQLException
	{
		sql="insert into employee values(?,?,?)";
		pst= conn.prepareStatement(sql);
		pst.setInt(1, emp.getEmpno());
		pst.setString(2, emp.getEmpname());
		pst.setFloat(3,emp.getEmpsal());		
		return pst.executeUpdate();
	}
}

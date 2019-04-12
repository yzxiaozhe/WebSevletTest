package com.zhe.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhe.dao.SickDao;
import com.zhe.pojo.Sick;


public class SickDaoImpl implements SickDao{

	//获取所有用户信息
	public List<Sick> gaoShowDao() {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<Sick> gao=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="select * from gaoxueya";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			//执行sql
			rs=ps.executeQuery();
			//给集合赋值
			gao=new ArrayList<Sick>();
			//遍历结果
				while(rs.next()){
					//给变量赋值
					Sick s=new Sick();
					s.setUid(rs.getInt("Id_gao"));
					s.setUname(rs.getString("Realname"));
					s.setSex(rs.getString("Sex"));
					s.setAge(rs.getInt("Age"));
					s.setSickroom(rs.getString("Sickroom"));
					s.setAdvice(rs.getString("Food_gao"));
					//将对象存储到集合中
					gao.add(s);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//返回结果
		return gao;
	}

	public List<Sick> tangShowDao() {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<Sick> tang=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="select * from tangniaobing";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			//执行sql
			rs=ps.executeQuery();
			//给集合赋值
			tang=new ArrayList<Sick>();
			//遍历结果
				while(rs.next()){
					//给变量赋值
					Sick s=new Sick();
					s.setUid(rs.getInt("Id_tang"));
					s.setUname(rs.getString("Realname"));
					s.setSex(rs.getString("Sex"));
					s.setAge(rs.getInt("Age"));
					s.setSickroom(rs.getString("Sickroom"));
					s.setAdvice(rs.getString("Food_tang"));
					//将对象存储到集合中
					tang.add(s);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//返回结果
		return tang;
	}

	public List<Sick> weiShowDao() {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<Sick> wei=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="select * from weibing";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			//执行sql
			rs=ps.executeQuery();
			//给集合赋值
			wei=new ArrayList<Sick>();
			//遍历结果
				while(rs.next()){
					//给变量赋值
					Sick s=new Sick();
					s.setUid(rs.getInt("Id_wei"));
					s.setUname(rs.getString("Realname"));
					s.setSex(rs.getString("Sex"));
					s.setAge(rs.getInt("Age"));
					s.setSickroom(rs.getString("Sickroom"));
					s.setAdvice(rs.getString("Food_wei"));
					//将对象存储到集合中
					wei.add(s);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//返回结果
		return wei;
	}

	public int weiAddDao(Sick s) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="insert into weibing values (?,?,?,?,?,?)";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, s.getUid());
			ps.setString(2, s.getUname());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getSickroom());
			ps.setString(6, s.getAdvice());
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//返回结果
		return index;
	}

	public int tangAddDao(Sick s) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="insert into tangniaobing values (?,?,?,?,?,?)";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, s.getUid());
			ps.setString(2, s.getUname());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getSickroom());
			ps.setString(6, s.getAdvice());
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//返回结果
		return index;
	}

	public int gaoAddDao(Sick s) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="insert into gaoxueya values (?,?,?,?,?,?)";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, s.getUid());
			ps.setString(2, s.getUname());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getSickroom());
			ps.setString(6, s.getAdvice());
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//返回结果
		return index;
	}

	public int weiDelDao(int id) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//创建sql命令
			String sql="DELETE FROM weibing WHERE Id_wei = ?";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, id);
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//返回结果
		return index;
	}
}

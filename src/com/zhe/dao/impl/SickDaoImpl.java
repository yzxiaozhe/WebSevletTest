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

	//��ȡ�����û���Ϣ
	public List<Sick> gaoShowDao() {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//��������
		List<Sick> gao=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="select * from gaoxueya";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			//ִ��sql
			rs=ps.executeQuery();
			//�����ϸ�ֵ
			gao=new ArrayList<Sick>();
			//�������
				while(rs.next()){
					//��������ֵ
					Sick s=new Sick();
					s.setUid(rs.getInt("Id_gao"));
					s.setUname(rs.getString("Realname"));
					s.setSex(rs.getString("Sex"));
					s.setAge(rs.getInt("Age"));
					s.setSickroom(rs.getString("Sickroom"));
					s.setAdvice(rs.getString("Food_gao"));
					//������洢��������
					gao.add(s);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		
		//���ؽ��
		return gao;
	}

	public List<Sick> tangShowDao() {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//��������
		List<Sick> tang=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="select * from tangniaobing";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			//ִ��sql
			rs=ps.executeQuery();
			//�����ϸ�ֵ
			tang=new ArrayList<Sick>();
			//�������
				while(rs.next()){
					//��������ֵ
					Sick s=new Sick();
					s.setUid(rs.getInt("Id_tang"));
					s.setUname(rs.getString("Realname"));
					s.setSex(rs.getString("Sex"));
					s.setAge(rs.getInt("Age"));
					s.setSickroom(rs.getString("Sickroom"));
					s.setAdvice(rs.getString("Food_tang"));
					//������洢��������
					tang.add(s);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		
		//���ؽ��
		return tang;
	}

	public List<Sick> weiShowDao() {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//��������
		List<Sick> wei=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="select * from weibing";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			//ִ��sql
			rs=ps.executeQuery();
			//�����ϸ�ֵ
			wei=new ArrayList<Sick>();
			//�������
				while(rs.next()){
					//��������ֵ
					Sick s=new Sick();
					s.setUid(rs.getInt("Id_wei"));
					s.setUname(rs.getString("Realname"));
					s.setSex(rs.getString("Sex"));
					s.setAge(rs.getInt("Age"));
					s.setSickroom(rs.getString("Sickroom"));
					s.setAdvice(rs.getString("Food_wei"));
					//������洢��������
					wei.add(s);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		
		//���ؽ��
		return wei;
	}

	public int weiAddDao(Sick s) {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		//��������
		int index=-1;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="insert into weibing values (?,?,?,?,?,?)";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setInt(1, s.getUid());
			ps.setString(2, s.getUname());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getSickroom());
			ps.setString(6, s.getAdvice());
			//ִ��
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		//���ؽ��
		return index;
	}

	public int tangAddDao(Sick s) {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		//��������
		int index=-1;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="insert into tangniaobing values (?,?,?,?,?,?)";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setInt(1, s.getUid());
			ps.setString(2, s.getUname());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getSickroom());
			ps.setString(6, s.getAdvice());
			//ִ��
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		//���ؽ��
		return index;
	}

	public int gaoAddDao(Sick s) {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		//��������
		int index=-1;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="insert into gaoxueya values (?,?,?,?,?,?)";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setInt(1, s.getUid());
			ps.setString(2, s.getUname());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getSickroom());
			ps.setString(6, s.getAdvice());
			//ִ��
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		//���ؽ��
		return index;
	}

	public int weiDelDao(int id) {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		//��������
		int index=-1;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "123456");
			//����sql����
			String sql="DELETE FROM weibing WHERE Id_wei = ?";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setInt(1, id);
			//ִ��
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
		
		//���ؽ��
		return index;
	}
}

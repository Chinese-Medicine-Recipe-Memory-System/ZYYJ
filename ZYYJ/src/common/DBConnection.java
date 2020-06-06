package common;
import java.sql.*;

//ͨ�ù���Bean���������ݿ�����
public class DBConnection 
{
	public static Connection conn = null;
	
	//�������ݿ�����
	public static Connection getConnection()
	{
		//1��������������
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			System.out.println("��������com.mysql.jdbc.Driver����ʧ��");
		}
		
		//2���������ݿ�
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://182.92.116.152:3306/db_zyyj?useUnicode=false&useSSL=false&characterEncoding=UTF-8",
					"root",
					"12345678");
		} 
		catch(Exception e)
		{
			System.out.println("��ȡ���ݿ�����ʧ��");
		}
		
		return conn;
	}
	
	//�ر����ݿ�����
	public static void closeConnection()
	{
		try 
		{
			if (conn != null)//�����Ѿ�������
			{
				conn.close();
				conn = null;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("�ر����ݿ�����ʧ�ܣ�");
		}
	}
}

package User;
import java.sql.*;
import java.util.ArrayList;
import common.*;

//ҵ����Bean
public class UserDB 
{
	// ��ȡ�����û���Ϣ
	public ArrayList<UserInfo> GetAllUsers() 
	{
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<UserInfo> userList=new ArrayList<UserInfo>();
        try 
        {
        	Connection con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from zyyj_user");
	    	while(rs.next())
	    	{
	    		UserInfo user=new UserInfo();
	    		user.setUser_id(rs.getString("user_id"));
				user.setPost_id(rs.getInt("post_id"));
				user.setName(rs.getString("name"));
				user.setRealname(rs.getString("realname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getInt("gender"));
				user.setStatus(rs.getInt("status"));
				user.setPhoto(rs.getString("photo"));
	    		userList.add(user);	    		
	    	}  
			rs.close();
			sql.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("��ȡ�����û���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return userList;
    }
	
	// ����û���Ϣ
	public int inserUser(UserInfo user)
	{
		int count = 0;
		
		try 
		{
			Connection con = DBConnection.getConnection();
			Statement stm = con.createStatement();
			String sql = "insert into zyyj_user "
					+ "(user_id, post_id, name, realname, password, phone, email, gender, status) "
					+ "values ";
			sql += "('"+user.getUser_id()+"', '"+user.getPost_id()+"' '"+user.getName()+"', "
					+ "'"+user.getRealname()+"', '"+user.getPassword()+"', "
					+ "'"+user.getPhone()+"', '"+user.getEmail()+"', "
					+ ""+user.getGender()+","+user.getStatus()+")";
			count = stm.executeUpdate(sql);
			stm.close();
		}
		catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("����û���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
	}
	
	//ͨ���û��˺Ż�ȡָ���û���Ϣ
	public UserInfo GetUserbyId(String user_id)
	{
		UserInfo user = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try 
		{
			Connection con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * from zyyj_user where user_id=?");
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			if (rs.next())
			{
				user = new UserInfo();
				user.setUser_id(rs.getString("user_id"));
				user.setPost_id(rs.getInt("post_id"));
				user.setName(rs.getString("name"));
				user.setRealname(rs.getString("realname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getInt("gender"));
				user.setStatus(rs.getInt("status"));
				user.setPhoto(rs.getString("photo"));
			
			}
			rs.close();
			pStmt.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("��ȡָ���û���Ϣʧ��");
		}
		finally 
		{
			DBConnection.closeConnection();
		}
		return user;
	}
	
	//�޸��û���Ϣ���޸�����
	public int updateUser(UserInfo user)
	{
		int count = 0;
		try 
		{
			Connection con = DBConnection.getConnection();
			String sql = "update zyyj_user "
					+ "set post_id=?, set name=?, "
					+ "set realname=?, set password=?, set phone=?, "
					+ "set email=?, set gender=?, set status=?"
					+ "where user_id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, user.getPost_id());
			stm.setString(2, user.getName());
			stm.setString(3, user.getRealname());
			stm.setString(4, user.getPassword());
			stm.setString(5, user.getPhone());
			stm.setString(6, user.getEmail());
			stm.setInt(7, user.getGender());
			stm.setInt(8, user.getStatus());
			stm.setString(9, user.getUser_id());
			count = stm.executeUpdate(sql);
			stm.close();
		}
		catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("�����û���Ϣʧ�ܣ�");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
	}
	
	//ɾ���û���Ϣ
	public int deleteUser(String user_id)
	{
		int count = 0;
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement stm = con.prepareStatement("delete from zyyj_user where user_id=?"); 
			stm.setString(1, user_id);
			count= stm.executeUpdate();
			stm.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("ɾ��ָ���û���Ϣʧ��");
		}
		finally 
		{
			DBConnection.closeConnection();
		}
		return count;
	}
}

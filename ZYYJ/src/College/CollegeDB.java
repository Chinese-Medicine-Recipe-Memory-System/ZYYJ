package College;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import College.CollegeInfo;

//ҵ����Bean
public class CollegeDB
{
	private Connection con = null;
  
	//��ȡ����ѧԺ��Ϣ
	public ArrayList<CollegeInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<CollegeInfo> collegeList=new ArrayList<CollegeInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 ִ�в�ѯ����ȡ���пγ���Ϣ
	        rs=sql.executeQuery("SELECT * FROM zyyj_college");
	        //TODO 2 ѭ������ѧԺ��Ϣ���������ÿ����¼����Ϊһ���γ���Ϣ���󣬲���ӵ�������
	        while(rs.next())
	        {
	        	CollegeInfo college =new CollegeInfo();
	        	college.setCollegid(rs.getString("college_id"));
	        	college.setCollegename(rs.getString("name"));
	        	college.setCollegedetail(rs.getString("comment"));
	        	collegeList.add(college);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("��ȡ����ѧԺ��Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return collegeList;
	 }
  
  //���ѧԺ��Ϣ
	public int Collegeinsert(CollegeInfo college) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_college (college_id,name,comment) values (?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,college.getCollegid());		
	  		pStmt.setString(2,college.getCollegename());		
	  		pStmt.setString(3,college.getCollegedetail());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("���ѧԺʧ�ܣ�");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//����ѧԺ��Ϣ��������
	public int update(CollegeInfo college) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_college set name=?,comment=? where college_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,college.getCollegename());		
	  		pStmt.setString(2,college.getCollegedetail());
	  		pStmt.setString(3, college.getCollegid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("�޸�ָ��ѧԺ��Ϣʧ�ܣ�");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//ͨ��ָ��ѧԺ�Ų�ѯĳѧԺ��������Ϣ
	public CollegeInfo getCollegeById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	CollegeInfo college = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_college where college_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	college = new CollegeInfo();
		    	college.setCollegid(rs.getString("college_id"));
		    	college.setCollegename(rs.getString("name"));
		    	college.setCollegedetail(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("��ȡָ��ѧԺ��Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return college;
	  }
  
  //ͨ��ѧԺ��ɾ��ָ��ѧԺ��Ϣ
  public int deleteCollege(String id) 
  {
	  PreparedStatement pStmt=null; 
	  int count=0;
      try 
      {
      	con=DBConnection.getConnection();
  		pStmt = con.prepareStatement("delete from zyyj_college where college_id=?");
  		pStmt.setString(1,id);		
  		count = pStmt.executeUpdate();
  		pStmt.close();    		
      } 
      catch (Exception e) 
      {
         	e.printStackTrace();
          System.out.println("ɾ��ָ��ѧԺʧ�ܣ�");
      } 
      finally
      {
    	  DBConnection.closeConnection();
      }		
      return count;
  }   

}
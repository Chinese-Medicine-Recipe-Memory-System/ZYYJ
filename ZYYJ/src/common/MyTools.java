package common;

//ͨ�ù���Bean�������ַ������ʽת��
public class MyTools 
{
	public static String toChinese(String str)
	{//��String�ַ��������ʽת��Ϊ����
		if (str == null || str.equals(""))
			str = "";
		try 
		{
			str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} 
		catch (Exception e) 
		{
			str = "";
		}
		return str;
	}
	
	public static int toint(String str)
	{//��String������ת��Ϊint�����ݵķ���
		if(str == null || str.equals(""))
			str="0";
		int i = 0;
		try
		{
			i = Integer.parseInt(str);
		}
		catch(NumberFormatException e)
		{
			i = 0;
			e.printStackTrace();
		}
		return i;		
	}
	public static float toFloat(String str)
	{//��String������ת��Ϊfloat�����ݵķ���
		if(str==null||str.equals(""))
			str = "0";
		float f = 0.0f;
		try
		{
			f = Float.parseFloat(str);
		}
		catch(NumberFormatException e)
		{
			f = 0.0f;
			e.printStackTrace();
		}
		return f;		
	}
}

package util;
import java.util.Date;
import java.io.*;

public class LogDog
{
	private Date date;
	private BufferedWriter writer;
	private String sep;
	
	public LogDog(){
		this.sep = "->";
	}
	public LogDog(String sep){
		this.sep = sep;
	}
	
	public void newLog() throws IOException{
		File f = new File(date.toString()+".log");
		writer = new BufferedWriter(
		new FileWriter(f));
	}
	
	public boolean addNormalCell(String name,String cell){
		try
		{
			writer.write("NORMAL:"+date.toString()+" "+name + " " + sep + " " + cell);
			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	public boolean addCustomCell(String state,String name,String cell){
		try
		{
			writer.write(state+":"+date.toString()+" "+name + " " + sep + " " + cell);
			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	public boolean addWarringCell(String name,String cell){
		try
		{
			writer.write("WARRING:"+date.toString()+" "+name + " " + sep + " " + cell);
			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	public boolean addErrorCell(Exception ex){
		try
		{
			writer.write(ex.toString());
			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	public boolean addErrorCell(Error er){
		try{
			writer.write(er.toString());
			return true;
		}catch(IOException e){
			return false;
		}
	}
	
}

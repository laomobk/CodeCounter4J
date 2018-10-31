import java.io.*;
<<<<<<< HEAD
import java.util.*;

=======
import java.util.ArrayList;
import java.util.HashMap;
import util.LogDog;
>>>>>>> new
/*
*Spec.Inc.
*2018.10.19
*QZFLS 1601 72/54
*/

/*
*18-10-16 First Version
*18-10-17 Android Version
*18-10-18 read nullLine
*18-10-21 read marked line
<<<<<<< HEAD
*18-10-24 new version 0.2
=======
*18-10-24 new version
*18-10-29 clean up code
*18-10-31 Helloween~ add a new future
>>>>>>> new
*/

public class Counter
{
	private FileReader reader;
	private BufferedReader breader;
	private int totalLine = 0;
	private int totalFile = 0;
	private String type = "java";
	private String fileName;
	private int nullLine = 0;
	private int markLine = 0;
	private String line;
<<<<<<< HEAD
	private File[] files;
	

=======
	private String path;
	private File[] files;
	
	Counter(String path){
		this.path = path;
	}
>>>>>>> new
	
	private boolean isThatFile(String name){
		if(name.indexOf(".")>0){
			if(
			name.substring(name.indexOf(".")+1,name.length()).equals(type)
			){
				return true;
			}
			else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public void printInfo(){
<<<<<<< HEAD
=======
		System.out.println("工程："+(getProjName()));
>>>>>>> new
		System.out.println("一共检索了：" + totalFile + "个文件");
		System.out.println("有"+nullLine+"条空行");
		System.out.println("有"+markLine+"条注释行");
	}
	
	public ArrayList getInfo(){
		
		HashMap map = new HashMap();
		ArrayList total = new ArrayList();
<<<<<<< HEAD
		ArrayList<String> paths = new ArrayList<>();
=======
		ArrayList<String> paths = new ArrayList<String>();
>>>>>>> new
		
		map.put("Total Files:",totalFile);
		for(File f:this.files){
			paths.add(f.getAbsolutePath());
		}
		
		map.put("Null Lines:",nullLine);
		map.put("Marked Lines:",markLine);
		
		total.clear();
		total.add(map);
		total.add(paths);
		return total;
	}
	
	public int[] getFullInfo(){
		int[] info = {totalLine,nullLine,markLine};
		return info;
	}
	
<<<<<<< HEAD
	private boolean isMarkedLine(String line){
		//将缩进排除！
		String nline = line.replace("\t","");
		if(nline.startsWith("//")||nline.startsWith("/*")||nline.startsWith("*")){
=======
	public int ReadLine(){
		File f = new File(this.path);
		int t =CountLine(f.listFiles());
		return t;
	}
	
	private boolean isMarkedLine(String line){
		String nline = line.replaceAll("\t","");
		if(nline.startsWith("//")||nline.startsWith("/*")||nline.startsWith("*")||nline.startsWith("*/")||nline.startsWith(" *")){
>>>>>>> new
			return true;
		}else{
			return false;
		}
	}
	
<<<<<<< HEAD
	private boolean isNullLine(String line){
		String nline = line.replace("\t","");
=======
	private boolean isSingleMarked(String l){
		//for mojang style code
		String line = l.replaceAll("\t","");
		//System.out.println(line.indexOf("*/")+":"+line.length());
		if(line.indexOf("*/") < line.length()&&line.indexOf("*/") != -1){
			return true;
		}else{
			return false;
		}
	}
	
	private String getProjName(){
		String s = path.substring(this.path.lastIndexOf("/")+1,path.length());
		return 
			s.equals("")?
			"UNTITLED":
			s;
		
	}
	
	private boolean isNullLine(String line){
		String nline = line.replaceAll("\t","");
>>>>>>> new
		if(nline.length()<=0){
			return true;
		}
		else{
			return false;
		}
	}
	
<<<<<<< HEAD
	public int ReadLine(File[] f)
	{
		this.files = f;
		for (File file:f)
		{
			if (file.isFile())
			{
				if (isThatFile(file.getName()))
				{
					totalFile++;
					try
					{
						reader = new FileReader(file);
						breader = new BufferedReader(reader);

						try
						{

							while ((line = breader.readLine()) != null)
							{
								totalLine++;
								
								if(isNullLine(line)){
									nullLine++;
								}
								if(isMarkedLine(line)){
									markLine++;
								}
							}

						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
					catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
				}
			}
			else
			{
				ReadLine(file.listFiles());
			}
=======
	private int CountLine(File[] f)
	{
		try
		{
			this.files = f;
		
			for (File file:files)
			{
				if (file.isFile() && isThatFile(file.getName()))
				{
					totalFile++;

					reader = new FileReader(file);
					breader = new BufferedReader(reader);

					while ((line = breader.readLine()) != null)
					{
						totalLine++;

						if (isNullLine(line))
						{
							nullLine++;
						}
						if (isMarkedLine(line)&&!isSingleMarked(line))
						{
							markLine++;
						}
					}
				}
				else if(file.isDirectory())
				{
					CountLine(file.listFiles());
				}
			}
		}
		
		catch (NullPointerException e)
		{
			System.out.println("oops! Something goes wrong! \n Program will exit in 10 seconds!");
			new LogDog().addErrorCell(e);
			e.printStackTrace();
			
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e2)
			{}
			System.exit(0);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
>>>>>>> new
		}
		return totalLine;
	}
}


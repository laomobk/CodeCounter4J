import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import util.LogDog;
/*
*LineCounter Core version 1.0 release
*Spec.Inc.
*2018.10.19
*QZFLS 1601 72/54
*/

/*
*18-10-16 First Version
*18-10-17 Android Version
*18-10-18 read nullLine
*18-10-21 read marked line
*18-10-24 new version
*18-10-29 clean up code
*18-10-31 Helloween~ add a new future
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
	private String path;
	private File[] files;
	
	Counter(String path){
		this.path = path;
	}

	
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
		System.out.println("工程："+(getProjName()));
		System.out.println("一共检索了：" + totalFile + "个文件");
		System.out.println("有"+nullLine+"条空行");
		System.out.println("有"+markLine+"条注释行");
	}
	
	public ArrayList getInfo(){
		
		HashMap map = new HashMap();
		ArrayList total = new ArrayList();
		ArrayList<String> paths = new ArrayList<String>();
		
		map.put("FileName",getProjName());
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
		int[] info = {totalLine,nullLine,markLine,};
		return info;
	}
	
	public int ReadLine(){
		File f = new File(this.path);
		//检测是否是不存在的路径
		if(f.exists()){
			int t =CountLine(f.listFiles());
			return t;
		}else{
			return 0;
		}
		
	}
	
	private boolean isMarkedLine(String line){
		String nline = line.replaceAll("\t","");
		if(nline.startsWith("//")||nline.startsWith("/*")||nline.startsWith("*")||nline.startsWith("*/")||nline.startsWith(" *")){

			return true;
		}else{
			return false;
		}
	}
	
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
		if(nline.length()<=0){
			return true;
		}
		else{
			return false;
		}
	}
	
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
		}
		return totalLine;
	}
}


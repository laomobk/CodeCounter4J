import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] a){
		
//		System.out.println("=======LineCounter=======");
//		System.out.print("请输入语言种类(默认为Java)：");
//		String type = new Scanner(System.in).nextLine();
<<<<<<< HEAD
		//System.out.print("请输入文件路径：");
		//String p = new Scanner(System.in).nextLine();
=======
//		System.out.print("请输入文件路径：");
//		String p = new Scanner(System.in).nextLine();
>>>>>>> new
//		System.out.println(
//			read("/storage/emulated/0/AppProjects/Lessons")
//		);
		String type = "";
		String p =
<<<<<<< HEAD
		"/storage/emulated/0/AppProjects/Minecraft";
		int line = read(p,type);
=======
			"/storage/emulated/0/AppProjects/LineCounter4J/src/test";
		int line = read(p);
>>>>>>> new
		if(line != 0){
			System.out.println("一共有："+line+" 行！");
		}else{
			System.out.println("没有检测到相应语言的代码！");
		}
	}
	
<<<<<<< HEAD
	static int read(String path,String type){
		File f = new File(path);
		//int line;
		Counter c = new Counter();
		
		int t = c.ReadLine(f.listFiles());
=======
	static int read(String path){
		Counter c = new Counter(path);
		
		int t = c.ReadLine();
>>>>>>> new
		c.printInfo();
		return t;
	}
}

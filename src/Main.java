import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] a){
		//这里的注释是为了方便AIDE使用的~
		
//		System.out.println("=======LineCounter=======");
//		System.out.print("请输入语言种类(默认为Java)：");
//		String type = new Scanner(System.in).nextLine();
		//System.out.print("请输入文件路径：");
		//String p = new Scanner(System.in).nextLine();

//		System.out.print("请输入文件路径：");
//		String p = new Scanner(System.in).nextLine();

//		System.out.println(
//			read("/storage/emulated/0/AppProjects/Lessons")
//		);
		String type = "";
		
		//p 是文件路径
		String p =

			"/storage/emulated/0/AppProjects/LineCounter4J/src/test1";
		int line = read(p);
		if(line != 0){
			System.out.println("一共有："+line+" 行！");
		}else{
			System.out.println("没有检测到相应语言的代码！");
		}
	}
	
	static int read(String path){
		Counter c = new Counter(path);
		
		int t = c.ReadLine();
		c.printInfo();
		return t;
	}
}

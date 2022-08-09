package demo
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner; 
public class programs {
  public static void method1() throws FileNotFoundException {
			File file = new File("C:\\Users\\anisha.s.r\\OneDrive - Accenture\\Documents\\Anisha\\small.dat.txt");
			FileReader fr=new FileReader(file); 
    Scanner scnr = new Scanner(file);
			int count=0;
			while(scnr.hasNextLine()){
         String line = scnr.nextLine();
			   String splitline[]=line.split("\\s");
		         for(String word:splitline) {
               if(word.equals(word.toUpperCase())&&word.startsWith("T")||word.endsWith("S")) {
		        		 count++;
		             }
		        	 
		             }}
			System.out.println("the number of files that start with T or end in S is: "+count);}
public static void trial2() throws IOException {
		File file = new File("C:\\Users\\anisha.s.r\\OneDrive - Accenture\\Documents\\Anisha\\small.dat.txt");
		FileReader fr=new FileReader(file);  
  BufferedReader buffer = new BufferedReader(fr);
		int filecount=0;
		int directorycount=0;
		String filenames="";
		String directories="";
		String line;
  while ((line = buffer.readLine()) != null) {
			 String splitline[]=line.split("\\s");
			 for(String word:splitline) {
          if(word.equals(word.toUpperCase())) {
					if(word.startsWith("T")||word.endsWith("S")) {
						 filecount++;
						 filenames=filenames+word+" " ;
					 }}
         else {
					 directorycount++;
					 directories=directories+word+ " ";
					 String[] directoriessplit=directories.split("");
					 
					 
				 }}}}
  static void RecursivePrint(File[] arr, int index, int level)
    {
		 int count=0;
    ArrayList<String> al = new ArrayList<String>();
        // terminate condition
        if (index == arr.length)
            return;
    for (int i = 0; i < level; i++)
            System.out.print("\t");
    if (arr[index].isFile()) {
       System.out.println("-" +arr[index].getName());
       String eachfile=arr[index].getName().replace(".txt", "");
       if(eachfile.equals(eachfile.toUpperCase())) {
    	  if(eachfile.startsWith("T")||eachfile.endsWith("S")) {
    		 count++;
    		      	  }
       }
        }
     else  if (arr[index].isDirectory()) {
            System.out.println("[" + arr[index].getName()
                               + "]");
        RecursivePrint(arr[index].listFiles(), 0,
                           level + 1);
       }
        RecursivePrint(arr, ++index, level);
        
       }
   public static void main(String[] args)
    {
     String maindirpath
            = "C:\\Users\\anisha.s.r\\OneDrive - Accenture\\Documents\\Anisha01\\Small";
 File maindir = new File(maindirpath);
     if (maindir.exists() && maindir.isDirectory()) {
        File arr[] = maindir.listFiles();
            System.out.println(
                "Files from main directory : " + maindir);
           RecursivePrint(arr, 0, 0);
     }
   }

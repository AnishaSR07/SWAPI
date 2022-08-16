package demo;
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
 

  public static void RecursivePrint(File[] arr, int index)
   {if (index == arr.length)
            return;
    if (arr[index].isFile()) {
      String eachfile=arr[index].getName().replace(".txt", "");
    if(eachfile.equals(eachfile.toUpperCase())) {
    	  if(eachfile.startsWith("T")||eachfile.endsWith("S")) {
    		
    		 System.out.println("Text files are: " +eachfile);
    		      	  }
       }
        }
      else  if (arr[index].isDirectory()) {
        	RecursivePrint(arr[index].listFiles(), 0
                          );
        }
        RecursivePrint(arr, ++index);
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
}

package mypack1;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class listoffiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("welcomeFile.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		int size=bis.available();//returns the size of the file
		byte[] buffer=new byte[size];
		bis.read(buffer);
		String s=new String(buffer);//converts byte[] into String
		System.out.println(s);
		bis.close();
		fis.close();
		int ch;
		do {
		System.out.println("User can choose any one option from below list");
		System.out.println("1: To display current file names in ascending order.");
		System.out.println("2: To add, delete, search a user specified file from the existing directory");
		System.out.println("3: To close the application.");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		ch=sc.nextInt();
		switch(ch){
		case 1: System.out.println("Current files in ascending order"); 
		File directoryPath = new File("/Users/rupalivaishnav/Documents/March2023/Day4proj1");
		String[] list = directoryPath.list();
		Arrays.sort(list);
		System.out.println("File name: "+Arrays.toString(list));
		break;
		case 2: int ch2;
			do {
			System.out.println("1. To add a user specified file from the existing directory");
			System.out.println("2. To delete a user specified file from the existing directory"); 
			System.out.println("3. To Search a user specified file from the existing directory");
			System.out.println("4. To navigate back to main menu");
			System.out.println("Enter Your Choice");
			ch2=sc.nextInt();
			switch(ch2) {
				case 1: 
					System.out.println("Enter a file to add in existing directory");
					Scanner sc1=new Scanner(System.in);
					String file=sc1.nextLine();
					File f0 = new File("/Users/rupalivaishnav/Documents/March2023/Day4proj1/"+file);   
			        if (f0.createNewFile()) {  
			                   System.out.println("File " + f0.getName() + " is created successfully.");  
			        } else {  
			                   System.out.println("File is already exist in the directory.");  
			        }
					
		        break;
				case 2: 
					System.out.println("Enter a file to delete in existing directory");
					Scanner sc2=new Scanner(System.in);
					String file1=sc2.nextLine();
					File f01 = new File("/Users/rupalivaishnav/Documents/March2023/Day4proj1/" +file1);   
			        if (f01.delete()) {  
			                   System.out.println("File " + f01.getName() + " is deleted successfully.");  
			        } else {  
			                   System.out.println("File Not Found.");  
			        }
					break;
				case 3:
			      String pathStr = "/Users/rupalivaishnav/Documents/March2023/Day4proj1";        
			      System.out.println("Enter the desired file name: ");
			      String file2 = sc.next(); 
			      File dir = new File(pathStr);
			      String[] list1 = dir.list();
			      boolean flag = false;      
			      for (int i = 0; i < list1.length; i++) {
			         if(file2.equals(list1[i])){
			            flag = true;
			         }
			      }        
			      if(flag){
			         System.out.println("File Found");
			      }else{
			         System.out.println("File Not Found");
			      }
	
				break;
				case 4: System.out.println("Exit");break;
			}
		}while(ch2!=4);
		break;
		
		case 3: System.out.println("ThankYou"); break;
		}
		}while(ch!=3);

	}

}
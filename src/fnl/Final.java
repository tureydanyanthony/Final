package fnl;


import java.util.Scanner;

public class Final {

	public static void main(String[] args) {
		int ch=0;
		Scanner s=new Scanner(System.in);
	   
	   FileBoImpl fb=new FileBoImpl();
		do {
		System.out.println("---------");
		System.out.println("Lockedme App");
		System.out.println("------------");
		System.out.println("Developer Details");
		System.out.println(" Created by         ABC Company");
		System.out.println(" Created on         29.06.2020");
		System.out.println("MENU");
		System.out.println("------------");
		System.out.println("1.View the Directory List");
		System.out.println("2.Remodel the files");
		System.out.println("3.Exit the application");
		System.out.println("Enter your choice");
		try {
		ch=Integer.parseInt(s.nextLine());
		}catch(Exception e) 
			{
				ch=0;
			}
		switch(ch) {
		case 1:
		     System.out.println(" Directory List");
		     System.out.println("----------------");
		     String[] filelist=fb.viewFiles();
		     for (String s1:filelist) {
		     System.out.println("-"+s1);
		     }
		     break;
		case 2:
			int ch1=0;
			do {
			System.out.println("------------");
			System.out.println("Further options ");
			System.out.println("-----------------");
			System.out.println("1.Add a File");
			System.out.println("2.Delete a File");
			System.out.println("3.Search a file ");
			System.out.println("4.Back to main menu");
			try {
			ch1=Integer.parseInt(s.nextLine());	
			}catch(Exception e) {
				ch1=0;
			}
			switch(ch1) {
				case 1:
					System.out.println("Enter file name to be created "); 
					String filename = s.nextLine(); 
					try {
						fb.addFiles(filename);
						System.out.println("File created Successfully");
					}catch(BusinessException e) {
					System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("Enter file name to be deleted"); 
					String deletefile = s.nextLine(); 
					try {
						fb.deleteFiles(deletefile);
						System.out.println("File deleted Successfully");
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println(" enter file to be searched");
					String searchfile=s.nextLine();
					boolean found=fb.searchFiles(searchfile);
					if(found) {
						System.out.println("File Found");
					}
					else {
						System.out.println("Not Found");
					}
					break;
				case 4:
					System.out.println(" Back to main menu");
					break;
				default:
					System.out.println("Invalid option");
					break;
	             }
			}while(ch1!=4);
			break;
		case 3:
			System.out.println("Thank you");
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
	}while(ch!=3);
	}
}

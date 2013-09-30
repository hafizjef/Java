package main.yellowpaper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import yellowpaper.function.Menu;


public class yellowpaper {
	public static void main(String[] args){
		System.out.println("Welcome to Yellow Paper Unified Records Manager");
		Menu menu=new Menu();
		Scanner in=new Scanner(System.in);
		String stat = "";
		
		int loop=0;
		while (loop==0){
			menu.showOption();
			System.out.print("Please specify your options : ");
			int choice=in.nextInt();
			
			
			if(choice==1){
				System.out.print("\nHow many user do you want to update : ");
				int user = in.nextInt();
				
				for (int x=0; x<user; x++){
					System.out.println();
					System.out.print((x+1)+".Insert Name\t: ");
					String name = in.next();
					
					System.out.print((x+1)+".Insert TelNo\t: ");
					String telno = in.next();
					menu.updatePhoneRecords(x, name, telno);
					try{
						menu.saveToFile(x);
					}catch(IOException e){
						e.printStackTrace();
					}
					
				}
				stat="Records have been updated!";
				System.out.println("> Status : "+stat+"\n");
				continue;
			}
			
			else if(choice==2){
				BufferedReader reader = null;
			   try {
				   try {
				        reader = new BufferedReader(new FileReader("phonebook.data"));
				        String line = null;
				        int loc=0;
				        while ((line = reader.readLine()) != null) {
				        	String [] parts = line.split(",");
				            menu.updatePhoneRecords(loc, parts[0], parts[1]);
				            loc+=1;
				        }
				    } finally {
				        reader.close();
				    }
			   }catch (IOException e){
				   e.printStackTrace();
			   }
				try{
					System.out.println("The size of array is : "+menu.count());
					for (int x=0; x<menu.count(); x++){
						System.out.print(menu.getName(x)+" : "+menu.getPhoneNumber(x));
						System.out.println();
					}	
				}catch(IOException e){
					e.printStackTrace();
				}
				stat="Command processed Successfully!";
				System.out.println("> Status : "+stat+"\n");
				continue;
			}
			
			else if(choice==3){
				System.out.print("Find By : \n1. Name\n2. Number");
				int fs=in.nextInt();
				
				
				if (fs==1){
					System.out.print("Input the Name : ");
					String find=in.next().toLowerCase();
					try{
						for (int x=0; x<menu.count(); x++){
							if (find.contains(menu.getName(x).toLowerCase())==true){
								System.out.println(menu.getName(x)+" : "+menu.getPhoneNumber(x));
							}
							else{
								System.out.println("No records found");
							}
						}	
					}catch(IOException e){
						e.printStackTrace();
					}
				}
				
				if (fs==2){
					System.out.print("Input the Number : ");
					String find=in.next();
					int found = 0;
					try{
						for (int x=0; x<menu.count(); x++){
							if (find.equals(menu.getName(x))){
								System.out.println(menu.getName(x)+" : "+menu.getPhoneNumber(x));
								found=1;
							}
							
						}	
					}catch(IOException e){
						e.printStackTrace();
					}
				}
				continue;
			}
			
			
			else if(choice==4){
				
				continue;
			}
			
			else if(choice==5){
				System.out.println("Thanks for using our system!\nBye!");
				return;
			}
			
			in.close();
		}
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

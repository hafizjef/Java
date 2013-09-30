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
				System.out.println("\n1. Find By name\n2. Find By Number");
				System.out.print("> ");
				int fs=in.nextInt();
				
				if (fs==1){
					System.out.print("Input name to find : ");
					if(menu.findByName(in.next(), menu)==0){
						System.out.println("No records found");
						continue;
					}
				}
				else if (fs==2){
					System.out.print("Input number to find : ");
					if(menu.findByNum(in.next(), menu)==0){
						System.out.println("No records found");
						continue;
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

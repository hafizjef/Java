package yellowpaper.function;
import java.io.*;

public class Records {
	String name, telNo;
	String[] nameData=new String[100];
	String[] telData=new String[100];
	int size=100;
	int found=0;
	
	public void saveToFile(int loc)throws IOException
	{
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("phonebook.data", true)));
		writer.println(nameData[loc]+","+telData[loc]);
		writer.close();
	}
	
	public void updatePhoneRecords(int loc, String name, String telNo){
		nameData[loc] = name;
		telData[loc] = telNo;
		}
	
	public String getPhoneNumber(int loc){
		return telData[loc];
	}
	
	public String getName(int loc){
		return nameData[loc];
	}
	
	public int findByName(String name, Menu menu){
		startUp();
		String find=name.toLowerCase();
		
		try{
			for (int x=0; x<(menu.count()); x++){
					if (find.contains(menu.getName(x).toLowerCase())==true){
						System.out.println(menu.getName(x)+" : "+menu.getPhoneNumber(x));
						this.found=1;
					}
				}	
			}catch(IOException e){
			e.printStackTrace();
			}
			return found;
	}
	
	public int findByNum(String num){
		return 1;
	}
	
	public void startUp(){
		BufferedReader reader = null;
		   try {
			   try {
			        reader = new BufferedReader(new FileReader("phonebook.data"));
			        String line = null;
			        int loc=0;
			        while ((line = reader.readLine()) != null) {
			        	String [] parts = line.split(",");
			            nameData[loc] = parts[0];
			            telData[loc] = parts[1];
			            loc+=1;
			        }
			    } finally {
			        reader.close();
			    }
		   }catch (IOException e){
			   e.printStackTrace();
		   }
	}
}

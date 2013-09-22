import java.io.*;
import java.util.*;
public class phonebook
{
	saveNumber num1 = new saveNumber(50);

	String getInput()throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> ");
		String getInput = input.readLine();
		return getInput;
	}

	public void printM(String message){
		System.out.print(message);
	}


	public void showMenu(){
		System.out.print("\n1. Update Data");
		System.out.print("\n2. View Data");
		System.out.print("\n3. Delete Data");
		System.out.print("\n4. Find Data");
		System.out.print("\n5. Save changes to file\n");

	}
	public void doTell(int option){
		if (option==1){
			printM("\nSelected option 1\n");
		}
		if (option==2){
			printM("\nSelected option 2\n");
		}
	}

	public void doWork(int option)throws IOException{
		switch (option){
			case 1 :	doTell(option);
						printM("\nHow many user you want to input?\n");
						insertData(Integer.parseInt(getInput()));
						break;

			case 2 : 	doTell(option);
						createArr();
						showData();
						break;
			case 3 :	doTell(option);
										
		}
	}


	public void insertData(int size)throws IOException{

		saveNumber num1 = new saveNumber(50);

		int loc=0;
		int loop=0;
		while (loop<size)
		{
			System.out.print("\nUser Name"+"\t|"+(loc+1)+"|"+": ");
			String name = getInput();

			System.out.print("User TelNo"+"\t|"+(loc+1)+"|"+": ");
			String telNo = getInput();

			num1.setArrayElement(loc, name, telNo);
			num1.saveData(loc);
			loc+=1;
			loop+=1;
		}
	}

	public void showData()throws IOException{
		System.out.print("The size of array is : "+count());
		for (int x=0; x<count(); x++){
			printM("\n");
			num1.printArray(x);
		}
	}

	public void findData(String data){
		//num1.findByName(4, data);
	}

	public int count() throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream("phonebook.data"));
    try {
        byte[] c = new byte[1024];
        int count = 0;
        int readChars = 0;
        boolean empty = true;
        while ((readChars = is.read(c)) != -1) {
            empty = false;
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n') {
                    ++count;
                }
            }
        }
        return (count == 0 && !empty) ? 1 : count;
    } finally {
        is.close();
    }
}


	public void createArr()throws IOException{
	    BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader("phonebook.data"));
	        String line = null;
	        int loc=0;
	        while ((line = reader.readLine()) != null) {
	        	String [] parts = line.split(",");
	            num1.setArrayElement(loc, parts[0], parts[1]);
	            loc+=1;
	        }
	    } finally {
	        reader.close();
	    }
	    

	}



	public static void main(String[] args)throws IOException
	{

		//main menu;
		System.out.print("\nWelcome to phonebookSoft, please insert your option : ");
		phonebook func = new phonebook();
		func.showMenu();

		func.doWork(Integer.parseInt(func.getInput()));
	}
}
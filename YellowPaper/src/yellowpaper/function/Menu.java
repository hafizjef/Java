package yellowpaper.function;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Menu extends Records{
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
	
	public void showOption(){
		String[] n = new String[5];
		n[0]="1.Update data";
		n[1]="2.View Data";
		n[2]="3.Find Data";
		n[3]="4.Delete Data";
		n[4]="5.Exit";
		
		System.out.println("======================================");
		for(int x=0; x<5; x++){
			System.out.println(n[x]);
		}
		System.out.println("======================================");
	}
}

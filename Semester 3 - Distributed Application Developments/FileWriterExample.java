import java.io.File;
import java.io.FileWriter;


public class FileWriterExample{

		public static void main(String args[]) throws Exception {

			File file = new File("Welcome.txt");

			if(file.exists() && !file.isDirectory()) {

				FileWriter writer = new FileWriter(file, true);
				writer.write("Software Engineering Department\n");
				writer.flush();
				writer.close();

			} else {

				FileWriter writer = new FileWriter("WelcomeAgain.txt");
				writer.write("Welcome to UTeM!");
				writer.flush();
				writer.close();
			}
		}
}

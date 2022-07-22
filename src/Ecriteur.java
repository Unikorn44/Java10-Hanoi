import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ecriteur {

	public void run(String string) {

		//PrintWriter writer = new PrintWriter(file);
		//writer.print("");
		try(Writer writer2 = new FileWriter("c://testHanoi.txt", true)){
			writer2.append(string + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void brosse() {	
		try(Writer writer2 = new FileWriter("c://testHanoi.txt", false)){
			writer2.append("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

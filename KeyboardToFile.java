import java.io.*;

public class KeyboardToFile {

	public static void main(String[] args) throws IOException {
		File out = new File("chiffre2.txt");
		if (out.exists()) {
			File newFile = new File("chiffre3.txt");
			if(!newFile.exists())
				newFile.createNewFile();
			if(out.exists()) {
				System.out.println(out.delete());
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\"ESC\" will end the input! \nStart typing: ");
			String inputString = in.readLine();
			while (inputString != null) {
				if(inputString.equalsIgnoreCase("esc"))
					break;
				writer.write(inputString);
				inputString = in.readLine();
				writer.newLine();
			}
			writer.close();
			System.out.println("Input ended!");
		} else {
			System.out.println("Destination file does not exist.");
		}
	}
}
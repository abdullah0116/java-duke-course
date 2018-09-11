import edu.duke.*;

public class HelloWorld {
	public static void main() {
		FileResource res = new FileResource("hello_unicode.txt");
		for (String line : res.lines()) {
			System.out.println(line);
		}
	}
}

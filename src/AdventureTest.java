import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AdventureTest {
	public static void main(String[] args) {
		System.out.println("\n\nTesting Small\n\n");
		testSmallAdventure();
		System.out.println("\n\nTesting Crowther\n\n");
		testCrowtherAdventure();
	}

	public static void testSmallAdventure() {
		try {
			Scanner scan = new Scanner(new File("SmallTest.txt"));
			Adventure.setScanner(scan);
			Adventure.main(null);
		} catch (IOException e) {
			System.out
					.println("To test, place the SmallTest.txt file in your project folder");
		}
	}

	public static void testCrowtherAdventure() {
		try {
			Scanner scan = new Scanner(new File("CrowtherTest.txt"));
			Adventure.setScanner(scan);
			Adventure.main(null);
		} catch (IOException e) {
			System.out
					.println("To test, place the CrowtherTest.txt file in your project folder");
		}
	}

}

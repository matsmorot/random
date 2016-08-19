import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Skriv in en text: ");
		String text = scan.nextLine();
		scan.close();

		String stripped = text.replaceAll(" ", "");
		String reversed = new StringBuilder(stripped).reverse().toString();

		if (stripped.toLowerCase().equals(reversed.toLowerCase())) {
			System.out.println("\"" + text + "\"" + " är ett palindrom!");
		} else {
			System.out.println("\"" + text + "\"" + " är inte ett palindrom.");
		}
	}
}

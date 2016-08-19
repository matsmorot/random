import java.util.*;
import java.time.*;
import java.time.temporal.*;

public class Personnummer {

	// Deklarera publika variabler
	public static LocalDate today = LocalDate.now();
	public static int inYear;
	public static int inMonth;
	public static int inDay;
	
	public static String inArea;
	public static int inSex;
	public static int inControl;
	public static String input;
	public static LocalDate inDate = today;

	public static void main(String args[]) {

		while (tryAgain()) {

			isDate();

			if (checkControl(inControl) != inControl) {
				System.out.println("Kontrollsiffran stämmer inte.");
				isDate();
			}

			System.out.println("Personnumret tillhör en " + getSex(inSex) + " som är " + getAge(inDate, today) + " dagar gammal.");
		}
		System.out.println("Tack för din medverkan. Var god lägg på luren.");
	}

// Deklarera metoder

	public static boolean tryAgain() {
		boolean answer = true;
		Scanner scan = new Scanner(System.in);

		System.out.println("Vill du testa ett personnummer? (j/n) ");
		String jn = scan.next();

		// Gå inte vidare förrän j eller n matats in
		while (!(jn.length() == 1 && jn.matches("[jnJN]"))) {
			System.out.println("Svara med 'j' eller 'n'.");
			jn = scan.next();
		}

		if (jn.equalsIgnoreCase("j") || jn.equalsIgnoreCase("ja")) {
			answer = true;
		} 
		else if (jn.equalsIgnoreCase("n") || jn.equalsIgnoreCase("nej")) {
			answer = false;
		}

		return answer;
	}

	public static boolean isDate() {
		
		// Kontrollera om input är siffror
		Scanner scan = new Scanner(System.in);

		System.out.println("Skriv in ett personnummer (12 siffror): ");
		input = scan.nextLine();

		// Gå inte vidare förrän 12 siffror matats in
		while (!(input.length() == 12 && input.matches("[0-9]+"))) {
			System.out.println("12 siffror och endast siffor tack. Inget annat.");
			System.out.println("Du matade in " + input.length() + " tecken.");
			input = scan.nextLine();
		}
		
		try {
		inYear = Integer.parseInt(input.substring(0,4));
		inMonth = Integer.parseInt(input.substring(4,6));
		inDay = Integer.parseInt(input.substring(6,8));
		inArea = input.substring(8,10);
		inSex = Integer.parseInt(input.substring(10,11));
		inControl = Integer.parseInt(input.substring(11,12));
		inDate = LocalDate.of(inYear, inMonth, inDay);
		}

		catch ( Exception e ) {
			System.out.println("Ooops! Du har angett ett felaktigt datum.");
		}

		if (inMonth > 12) {
			System.out.println("Ett år har faktiskt bara 12 månader. Kom igen...");
			isDate();
		}
		
		else if (inDate.isAfter(today)) {
			System.out.println("Du har angett ett datum i framtiden.");
			isDate();
		}

		return true;
	}

	public static String getSex(Integer inSex) {
		String sex = "";

		if (inSex % 2 == 0) {
			sex = "kvinna";
			return sex;
		}
		else {
			sex = "man";
			return sex;
		}
	}

	public static Integer checkControl(Integer inControl) {
		String noControl = input.substring(2,11);
		String odds = "";
		String evens = "";
		String product = "";
		String tutti = "";
		int sum = 0;
		int result = 0;
		
		// Loop för att få fram siffror att multiplicera med 2 och 1
		for (int i = 0; i < noControl.length(); i++) {
			if (i%2 == 0) {
				odds += Character.getNumericValue(noControl.charAt(i));
			}
			else {
				evens += Character.getNumericValue(noControl.charAt(i));
			}
		}
		
		// Loop för att multiplicera med 2
		for (int i = 0; i < odds.length(); i++) {
			product += Character.getNumericValue(odds.charAt(i)) * 2;
		}

		// Loop för att summera
		tutti = product + evens; // Alla siffror, även jämna
		for (int i = 0; i < tutti.length(); i++) {
			sum += Character.getNumericValue(tutti.charAt(i));
		}

		result = 10 - (sum%10);
		return result;
	}

	public static long getAge(LocalDate born, LocalDate today) {
		long days;
		days = ChronoUnit.DAYS.between(born, today);
		return days;
	}

}

package countries_assignment;

public class Validation {

	// method to test if the user's input was a valid menu selection
	public static boolean menuSelectionTest(String userInput) {
		boolean isValid = true;
		int temp = 0;

		try {
			temp = Integer.parseInt(userInput);
			if (temp > 0 && temp < 6) {
				isValid = false;
			} else {
				System.out.println("Not a valid entry, please try again. Number must be 1, 2, 3, 4, or 5");
			}
		} catch (NumberFormatException e) {
			System.out.println("Not a valid entry, please try again . Entry must be a number.");
		}

		return isValid;
	}

	// method to test if a country is already in our list
	public static boolean countryTestOne(String country) {
		boolean isValid = true;

		for (int i = 0; i < WriteAndRead.countries.size(); i++) {
			if (country.equalsIgnoreCase(WriteAndRead.countries.get(i))) {
				isValid = false;
			}
		}

		return isValid;
	}

	// method to test if a country is in our known list of countries
	public static boolean countryTestTwo(String country) {
		boolean isValid = false;

		for (int i = 0; i < WriteAndRead.allCountries.size(); i++) {
			if (country.equalsIgnoreCase(WriteAndRead.allCountries.get(i))) {
				isValid = true;
			}
		}

		return isValid;
	}

}

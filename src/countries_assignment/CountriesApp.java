package countries_assignment;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		WriteAndRead.fillCountryList();
		WriteAndRead.fillCapitalList();
		menu();
	}
	
	public static void menuOptions(){
		System.out.println("Please choose one of the following options:");
		System.out.println("-Enter 1 to diplay a list of countries");
		System.out.println("-Enter 2 to add a country to the list");
		System.out.println("-Enter 3 to delete a country from the list");
		System.out.println("-Enter 4 to view the capitals of the countries in the list");
		System.out.println("-Enter 5 to exit the program");
	}
	
	public static int getUserSelection(){
		Scanner sc = new Scanner(System.in);
		String userInput = null;
		int userSelection = 0;
		
		do{
			userInput = sc.nextLine();
		}while(Validation.menuSelectionTest(userInput));
		
		userSelection = Integer.parseInt(userInput);
		return userSelection;
	}
	
	public static void menu(){
		int choice = 0;
		
		menuOptions();
		choice = getUserSelection();
		
		String country = null;
		
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Here is the list of countries:");
			WriteAndRead.printCountries();
			menu();
			break;

		case 2:
			System.out.println();
			System.out.println("Please enter the country you would like to add:");
			country = getCountry();
			WriteAndRead.addCountry(country);
			menu();
			break;
			
		case 3:
			System.out.println();
			System.out.println("Please enter the country you would like to delete:");
			country = getCountry();
			WriteAndRead.deleteCountry(country);
			menu();
			break;
			
		case 4:
			System.out.println();
			System.out.println("Here is the list of countries and their capitals:");
			WriteAndRead.printCapitalsAndCountries();
			menu();
			break;
			
		case 5:
			System.out.println();
			System.out.println("Goodbye");
			WriteAndRead.saveChanges();
			System.exit(0);
		}
	}
	
	public static String getCountry(){
		String temp = null;
		Scanner sc = new Scanner(System.in);
		
		temp = sc.nextLine();
			
		return temp;
	}

}

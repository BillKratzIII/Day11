package countries_assignment;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;

public class WriteAndRead {
	// declare array lists to to hold countries and capitals
	static ArrayList<String> countries = new ArrayList<>();
	static ArrayList<String> capitals = new ArrayList<>();
	// set up paths to files for countries and capitals
	static Path countryPath = Paths
			.get("\\Users\\admin\\newWorkspace\\Day11\\src\\countries_assignment\\countries.txt");
	static File countryFile = countryPath.toFile();
	static Path capitalPath = Paths.get("\\Users\\admin\\newWorkspace\\Day11\\src\\countries_assignment\\capitals.txt");
	static File capitalFile = capitalPath.toFile();
	// set up path and file to create a new file to store countries and their
	// capitals
	static Path newPath = Paths.get("\\Users\\admin\\newWorkspace\\Day11\\src\\countries_assignment\\newFile.txt");
	static File newFile = newPath.toFile();

	// method to fill the array lists of countries from data in text file
	public static void fillCountryList() {
		String temp = null;
		try (BufferedReader in = new BufferedReader(new FileReader(countryFile))) {
			while ((temp = in.readLine()) != null) {
				countries.add(temp);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// method to fill the array lists of capitals from data in text file
	public static void fillCapitalList() {
		String temp = null;
		try (BufferedReader in = new BufferedReader(new FileReader(capitalFile))) {
			while ((temp = in.readLine()) != null) {
				capitals.add(temp);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// method to display all countries stored in countries array list
	public static void printCountries() {
		for (int i = 0; i < countries.size(); i++) {
			System.out.println(countries.get(i));
		}
		System.out.println();
	}

	// method to add a country the user inputs unless it's already in our list
	public static void addCountry(String country) {

		if (Validation.countryTest(country)) {
			System.out.println();
			countries.add(country);
			System.out.println(country + " was added to the list.");
			System.out.println();

		} else {
			System.out.println(country + " is already in the list.");
			System.out.println();
		}
	}

	// method to delete a country from both array lists for countries and
	// capitals
	public static void deleteCountry(String country) {
		int temp = 0;

		// check to ensure the user selected country is in our list
		if (Validation.countryTest(country)) {
			System.out.println("ERROR: " + country + " was not found in the list.");
			System.out.println();
		} else {
			System.out.println();

			for (int i = 0; i < countries.size(); i++) {
				if (countries.get(i).equalsIgnoreCase(country)) {
					temp = i;
				}
			}
			countries.remove(temp);
			capitals.remove(temp);
			System.out.println(country + " was removed from the list.");
			System.out.println();
		}
	}

	// method to save the changes the user made in the program to the text files
	// before exiting
	public static void saveChanges() {

		// clear and overwrite countries text file with contents of countries
		// array list
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryFile)))) {
			out.println(countries.get(0));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryFile, true)))) {
			for (int i = 1; i < countries.size(); i++) {
				out.println(countries.get(i));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// clear and overwrite capitals text file with contents of capitals
		// array list
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(capitalFile)))) {
			out.println(capitals.get(0));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(capitalFile, true)))) {
			for (int i = 1; i < capitals.size(); i++) {
				out.println(capitals.get(i));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create new file to store both countries and capitals formatted in one
		// text file
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFile, true)))) {
			for (int i = 0; i < capitals.size(); i++) {
				out.print(capitals.get(i));
				out.print(", ");
				out.println(countries.get(i));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// method to display all countries in our list and their capital cities
	public static void printCapitalsAndCountries() {
		for (int i = 0; i < countries.size(); i++) {
			System.out.println("The capital of " + countries.get(i) + " is " + capitals.get(i) + ".");
		}
		System.out.println();
	}

	// method to add a capital city, called when adding a country
	public static void addCapital(String capital) {

		System.out.println();
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(capitalFile, true)))) {
			capitals.add(capital);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package countries_assignment;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;

public class WriteAndRead {
	static ArrayList<String> countries = new ArrayList<>();
	static ArrayList<String> capitals = new ArrayList<>();
	static Path countryPath = Paths.get("\\Users\\admin\\newWorkspace\\Day11\\src\\countries_assignment\\countries.txt");
	static File countryFile = countryPath.toFile();
	static Path capitalPath = Paths.get("\\Users\\admin\\newWorkspace\\Day11\\src\\countries_assignment\\capitals.txt");
	static File capitalFile = capitalPath.toFile();
	static Path newPath = Paths.get("\\Users\\admin\\newWorkspace\\Day11\\src\\countries_assignment\\newFile.txt");
	static File newFile = newPath.toFile();
	
	public static void fillCountryList(){
		String temp = null;
		try(BufferedReader in = new BufferedReader(new FileReader(countryFile))){
			while((temp=in.readLine())!=null){
				countries.add(temp);	
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void fillCapitalList(){
		String temp = null;
		try(BufferedReader in = new BufferedReader(new FileReader(capitalFile))){
			while((temp=in.readLine())!=null){
				capitals.add(temp);	
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void printCountries(){
		for(int i=0; i<countries.size(); i++){
			System.out.println(countries.get(i));
		}
		System.out.println();
	}
	
	public static void addCountry(String country){
		
		if(Validation.countryTest(country)){
			System.out.println();
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryFile, true)))){
				countries.add(country);
				System.out.println(country + " was added to the list.");
				System.out.println();
				out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			System.out.println(country + " is already in the list.");
			System.out.println();
		}
	}
	
	public static void deleteCountry(String country){
		//
			if(Validation.countryTest(country)){
				System.out.println("ERROR: " + country + " was not found in the list.");
				System.out.println();
			}else{
				System.out.println();
				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryFile, true)))){
					countries.remove(country);
					out.close();
					System.out.println(country + " was removed from the list.");
					System.out.println();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	
	public static void saveChanges(){
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryFile)))){
			out.println(countries.get(0));
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryFile, true)))){
			for(int i=1; i<countries.size(); i++){
				out.println(countries.get(i));
			}
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(capitalFile)))){
			out.println(capitals.get(0));
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(capitalFile, true)))){
			for(int i=1; i<capitals.size(); i++){
				out.println(capitals.get(i));
			}
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFile, true)))){
			for(int i=0; i<capitals.size(); i++){
				out.print(capitals.get(i));
				out.print(", ");
				out.println(countries.get(i));
			}
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void printCapitalsAndCountries(){
		for(int i=0; i<countries.size(); i++){
			System.out.println("The capital of " + countries.get(i) + " is " + capitals.get(i) + ".");
		}
		System.out.println();
	}

}

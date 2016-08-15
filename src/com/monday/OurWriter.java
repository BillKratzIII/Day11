package com.monday;

import java.io.*;
import java.nio.file.*;

public class OurWriter {
	public static void main(String[] args) {
		Path ourNewPath = Paths.get("\\Users\\admin\\Desktop\\anewtextfile.txt");
		File aNewFileObj = ourNewPath.toFile();
		String peopleInClassroom = null;
		
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFileObj, true)))){
			out.println("Cris");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (BufferedReader in = new BufferedReader(new FileReader(aNewFileObj))){
			peopleInClassroom = in.readLine();
			while((peopleInClassroom = in.readLine())!=null){
				System.out.println(peopleInClassroom);
			}
			System.out.println(peopleInClassroom);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		
		
	}//main

}//class

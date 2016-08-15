package com.monday;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class MyFavoriteMovies {

	public static void main(String[] args) {
		ArrayList<String> myFavMovies = new ArrayList<>();
		
		Path ourNewPath = Paths.get("\\Users\\admin\\Desktop\\myfavmovies.txt");
		File ourNewFile = ourNewPath.toFile();
		
		try(BufferedReader in = new BufferedReader(new FileReader(ourNewFile))){
			String aMovie;
			while((aMovie = in.readLine()) != null){
				myFavMovies.add(aMovie);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println(myFavMovies);
	}

}

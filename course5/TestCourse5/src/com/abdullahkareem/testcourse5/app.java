package com.abdullahkareem.testcourse5;

import edu.duke.FileResource;

public class app {
	public static void main(String[] args) {
		String anId = "0";
		String aTitle = "Into the Spiderverse";
		String aYear = "2018";
		String theGenres = "Cartoon";
		Movie m = new Movie(anId, aTitle, aYear, theGenres);
		
		System.out.println(m);
	}
}

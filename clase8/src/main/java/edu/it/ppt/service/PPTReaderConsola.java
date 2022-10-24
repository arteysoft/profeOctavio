package edu.it.ppt.service;

import java.util.Scanner;

import edu.it.ppt.enums.ELEMENTOS;

public class PPTReaderConsola implements PPTReader {
	public ELEMENTOS read() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese 1..");
		scn.nextLine();
		return null;
	}
}

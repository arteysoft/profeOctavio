package edu.it.ppt.service;

import java.util.Random;

import edu.it.ppt.enums.ELEMENTOS;

public class PPTReaderRandom implements PPTReader {
	public ELEMENTOS read() {
		var elementoElegido = new Random().nextInt(3);
		
		return null;
	}
}

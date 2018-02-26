package ca.mcgill.ecse428.postalcalculator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPostalCalculator {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		PipedOutputStream pipeout = new PipedOutputStream(); 
		PipedInputStream pipeIn = new PipedInputStream(pipeout);  
		System.setOut(new PrintStream(pipeout));
		Scanner scan = new Scanner(pipeIn); 
		PostalCalculator.main(null);
		assertEquals("Usage: PostalCalculator from_postal, to_postal, length, width, height, weight, post_type", scan.nextLine());
		scan.close();
	}

}

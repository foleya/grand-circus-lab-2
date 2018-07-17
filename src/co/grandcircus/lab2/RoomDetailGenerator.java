package co.grandcircus.lab2;

import java.util.Scanner;

public class RoomDetailGenerator {

    public static void main(String[] args) {
	roomDetailGeneratorProgramLoop();
    }
    
    // Welcomes the user and runs the program loop until the user quits.
    private static void roomDetailGeneratorProgramLoop() {
	boolean programIsRunning = true;
	
	System.out.println("Welcome to the room detail generator! "
		+ "Enter the dimensions of a room to see that room's "
		+ "details!");
	System.out.println();
	
	do {
	    roomDetailGenerator();
	    programIsRunning = confirmContinue();
	} while (programIsRunning);
	
	System.out.println("Goodbye!");
    }
    
    // Prompts user for room dimensions, then calculates and prints room details.
    private static void roomDetailGenerator() {
	double length = getValue("length");
	double width = getValue("width");
	double height = getValue("height");
	
	double area = calculateArea(length, width);
	double perimeter = calculatePerimeter(length, width);
	double volume = calculateVolume(length, width, height);
	
	System.out.println();
	System.out.printf("The room's area is: %.2f square units.%n", area);
	System.out.printf("The room's perimeter is: %.2f regular units.%n", perimeter);
	System.out.printf("The room's volume is: %.2f cubic units.%n", volume);
	System.out.println();
    }
    
    // Prompts user for desired room dimension.
    private static double getValue(String measurement) {
	Scanner scnr = new Scanner(System.in);
	
	System.out.print("Please enter the room's " + measurement + ": ");
	double userInput = scnr.nextDouble();
	
	return userInput;
    }
    
    // Confirms whether the user wants to continue using the program.
    private static boolean confirmContinue() {
	Scanner scnr = new Scanner(System.in);
	
	System.out.print("Would you like to try again? (y/N): ");
	String confirmation = scnr.next();
	System.out.println();
	
	if (confirmation.toLowerCase().equals("y")) {
	    return true;
	} else {
	    return false;
	}
    }
    
    /*Probably overkill to make these separate methods, but did so
    in case the package was ever exported and these methods needed
    to be used separate from the program logic.*/
  
    // Calculates the area of a room given a certain length and width.
    private static double calculateArea(double length, double width) {
	return length*width;
    }
    
    // Calculates the perimeter of a room given a certain length and width.
    private static double calculatePerimeter(double length, double width) {
	return (length * 2) + (width * 2);
    }
    
    // Calculates the volume of a room given a certain length, width, and height.
    private static double calculateVolume(double length, double width, double height) {
	return length * width * height;
    }

}


/*
Name:				John Hunsaker
Class:			CPSC335 Algorithm Engineering
Project:			Alternating Disks
Problem:			Use both the Left-to-right and Lawnmower algorithm to push the dark disks in front of 
					the light disks in a list of alternating disks by swapping two disks at a time.
Implementation: Java (created using Netbeans IDE)
*/

package disksorting;

import java.util.*;
import java.io.*;

public class DiskSorting {
	
	public static void main(String[] args) throws IOException {
		int number = 0;

		System.out.println("CPSC335 - Programming Assignment #1.");
		System.out.print("This program was created to sort 2 different types of disks. ");

		//Obtain number of disks from the user.
		System.out.println("Enter the number of disks of one color to be created, "
		 + "then press enter.");
		System.out.println("(Note: This number must be even and larger than "
		 + "1 for the output to be correct): ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		number = (Integer.parseInt(input));
		
		//Create new output file, and open it.
		System.out.println();
		System.out.println("The results will be outputted to a file "
		 + "called \"DiskSortingResults.txt\" in the directory where this project"
		 + " is located.");
		System.out.println("Thank you. Goodbye.");
		PrintWriter o = new PrintWriter("DiskSortingResults.txt");
		
		//Create array to store left to right numbers.
		char currentLayoutLR[] = new char[number * 2];
		
		//Create array to store lawnmower orders.
		char currentLayoutLawn[] = new char[number * 2];

		//Create initial layout for both arrays.
		for (int i = 0; i < number; i++) {
			currentLayoutLR[i * 2] = 'D';
			currentLayoutLawn[i * 2] = 'D';
			currentLayoutLR[(i * 2) + 1] = 'L';
			currentLayoutLawn[(i * 2) + 1] = 'L';
		}

		/*Begin L to R Algorithm*/
		o.println("We will begin by using the left-to-right algorithm to sort the dark and light disks.");
		o.println();
		o.println("Starting Configuration: ");
		
		//Print starting order.
		for (int i = 0; i < (2 * number); i++) {
			o.print(currentLayoutLR[i] + " ");
		}
		
		o.println();
		o.println();
		o.println("This is the progression of passes being performed on the disks: ");

		//Sort and print the disks.
		int swaps = 0;
		int rightmostDisk = (2 * number) - 2;
		for (int i = 0; i < number; i++) {
			for (int a = 0; a <= rightmostDisk; a++) {
				if ((currentLayoutLR[a] == 'D') && currentLayoutLR[a + 1] == 'L') {
					char holdValue = currentLayoutLR[a];
					currentLayoutLR[a] = currentLayoutLR[a + 1];
					currentLayoutLR[a + 1] = holdValue;
					swaps++;
				}
			}

			for (int a = 0; a < 2 * number; ++a) {
				o.print(currentLayoutLR[a] + " ");
			}
			o.println();
		}
		o.println();

		//Print final layout.
		o.println("Sorted Configuration: ");
		for (int i = 0; i < 2 * number; i++) {
			o.print(currentLayoutLR[i]+ " ");
		}
		o.println();
		o.println();
		o.println("Number of swaps: " + swaps);

		/*End of L to R Algorithm*/

		
		
		
		/*Begin Lawnmower Algorithm*/

		o.println();
		o.println();
		o.println();
		o.println("Next, we will use the lawnmower algorithm to sort the dark and light disks.");
		o.println();
		o.println("Starting Configuration:");
		
		//Print starting configuration.
		for (int i = 0; i < 2*number; i++) {
			o.print(currentLayoutLawn[i] + " ");
		}
		o.println();

		o.println();
		o.println("This is the progression of passes being performed on the disks: ");

		//Sort and print the disks.
		swaps = 0;
		rightmostDisk = (2 * number) - 2;
		int storeVal = 0;
		for (int i = 0; i < (number/2); i++) {
			for (int a = i; a <= rightmostDisk; a++) {
				if ((currentLayoutLawn[a] == 'D') && currentLayoutLawn[a + 1] == 'L') {
					char holdValue = currentLayoutLawn[a];
					currentLayoutLawn[a] = currentLayoutLawn[a + 1];
					currentLayoutLawn[a + 1] = holdValue;
					swaps++;
					storeVal = a;
				}
			}

			for (int a = 0; a < (2 * number); a++) {
				o.print(currentLayoutLawn[a] + " ");	
			}
			o.println();

			for (int a = storeVal; a > i; a--) {	
				if ((currentLayoutLawn[a] == 'D') && currentLayoutLawn[a + 1] == 'L') {
					char holdValue = currentLayoutLawn[a];
					currentLayoutLawn[a] = currentLayoutLawn[a + 1];
					currentLayoutLawn[a + 1] = holdValue;
					swaps++;
				}
			}

			for (int a = 0; a < 2 * number; a++) {
				o.print(currentLayoutLawn[a] + " ");
			}
			o.println();
		}
		
		o.println();
		o.println("Sorted Configuration: ");
		
		//Print the final list.
		for (int i = 0; i < (2 * number); i++) {
			o.print(currentLayoutLawn[i] + " ");
		}
		o.println("\n");
		o.println();
		o.println("Number of swaps: " + swaps);
		o.println();
		
		//Close the file and program.
		o.println("Algorithms are completed. Terminating program.");
		o.println("\n");
		o.close();

	}
}
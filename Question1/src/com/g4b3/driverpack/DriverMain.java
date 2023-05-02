package com.g4b3.driverpack;

/*class imports*/
import java.util.Scanner;
import com.g4b3.buildingpack.Building;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.RuntimeException;

/* DriverMain class */
public class DriverMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); /* Scanner instance created for user input */
		int totalFloors;
		try {
			do {
				System.out.println("Enter the total no of floors in the building: ");
				totalFloors = sc.nextInt();
				if (totalFloors < 1) {
					System.out.println("Total floors in the building should be 1 or above.\n");
				}
			} while (totalFloors < 1);

			/* ArrayList instance for taking floor sizes as inputs */
			ArrayList<Integer> floorsArray = new ArrayList<Integer>();

			/* Inputs of all floor sizes taken from user with validity check */
			for (int i = 0; i < totalFloors; i++) {
				System.out.println("Enter the floor size given on day " + (i + 1) + ": ");
				int floorSize = sc.nextInt();

				if (floorSize < 1 || floorSize > totalFloors) { /* Valid floor size check */
					System.out.println("Invalid floor size! Try again..\n");
					i--;
				} else if (floorsArray.contains(floorSize)) { /* Repeated same floor size not entry restricted */
					System.out.println("Floor size already exists. Input again...\n");
					i--;
				} else { /* only valid floor size added in input ArrayList */
					floorsArray.add(floorSize);
				}
			}

			Building bldg = new Building(); /* Building instance created */
			bldg.displayWorkOrder(floorsArray, totalFloors); /* displayWorkOrder method invoked */

		} catch (InputMismatchException e) {
			System.out.println("Invalid Input. Only Integer values allowed");
			System.out.println("Program execution stopped!");

		} catch (RuntimeException e) {
			System.out.println("Sorry! Runtime exception occured" + e.getMessage());
			System.out.println("Program execution stopped!");

		} finally {
			sc.close(); /* Scanner instance closed */
		}

	}
}

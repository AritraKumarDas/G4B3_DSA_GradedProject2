package com.g4b3.buildingpack;

/*importing classes*/
import java.util.PriorityQueue;
import java.util.ArrayList;

/* Building class defined*/
public class Building {

	/* method to display the order of floor construction */
	public void displayWorkOrder(ArrayList<Integer> floorsArray, int totalFloors) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int nextFloorSeek = totalFloors;

		System.out.println("The order of construction is as follows: ");
		for (int i = 0; i < totalFloors; i++) {
			System.out.print("DAY " + (i + 1) + "=> ");
			pq.add(floorsArray.get(i));

			while (!pq.isEmpty() && nextFloorSeek == pq.peek()) {
				System.out.print(pq.poll() + " ");
				nextFloorSeek--;
			}
			System.out.println();
		}
	}
}

package elevator;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import exceptions.NoSuchFloorException;
import floor.Floor;
/**
 * Herite d'Elevator, represente les ascenceurs rouges. </br>
 * Definie son propre poids et sa propre surface maximum, numerote les ascenceurs rouges.
 * @author david_Ekchajzer, Mathieu_Ridet
 */

public class RedElevator extends Elevator {

	private static int RedElevatorNumber = 0;
	private static String elevatorColor = "red";
	private static int maxWeight = 1000;
	private static int maxSurface = 10;
 
	public RedElevator(LinkedHashMap<Floor, Integer> reachableFloors) throws NoSuchFloorException {
		super(RedElevator.elevatorColor, RedElevator.maxWeight, RedElevator.maxSurface, ++RedElevatorNumber, reachableFloors);
	}

 
}

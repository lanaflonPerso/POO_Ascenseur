package elevator;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import exceptions.NoSuchFloorException;
import floor.Floor;

/**
 * Herite d'Elevator, represente les ascenceurs jaunes. </br>
 * Definie son propre poids et sa propre surface maximum, numerote les ascenceurs jaunes.
 * @author david_Ekchajzer, Mathieu_Ridet
 */

public class YellowElevator extends Elevator {

	private static int YellowElevatorNumber = 0;
	private static String elevatorColor = "yellow";
	private static int maxWeight = 1000;
	private static int maxSurface = 10;

 
	public YellowElevator(LinkedHashMap<Floor, Integer> reachableFloors) throws NoSuchFloorException {
		super(YellowElevator.elevatorColor, YellowElevator.maxWeight, YellowElevator.maxSurface, ++YellowElevatorNumber, reachableFloors);
	}

}

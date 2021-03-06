package test;
import floor.Floor;
import user.*;
import main.*;
import exceptions.FirstFloorException;
import exceptions.LastFloorException;
import exceptions.NoSuchFloorException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UserTest {
	static SystemInit syst;
	
	@BeforeAll
	
	public static void init() throws NoSuchFloorException {
		if(SystemInitTest.systToTest != null) syst = SystemInitTest.systToTest;
		else syst = new SystemInit();	
	}
	 
	@Test
	public void userCreation() throws FirstFloorException, LastFloorException, NoSuchFloorException {	
		User uAdmin1 = new Administrative("Julien", "Dupont", 45, 84, false, Floor.getFloor(0, "yellow"), Floor.getFloor(14, "yellow"));
		assertEquals(uAdmin1.getAge(),45);
		assertEquals(uAdmin1.getPriority(), 2);
		assertFalse(uAdmin1.getPMR());
		assertTrue(uAdmin1.getWeight() == 84);
		assertEquals(uAdmin1.getFinalDestination(), null);
		assertTrue(uAdmin1.getSource().equals(Floor.getFloor(0, "yellow")));
		assertTrue(uAdmin1.getDestination().equals(Floor.getFloor(14, "yellow")));
		assertTrue(uAdmin1 instanceof Administrative);
		
		User uStudent1 = new Student("Juliette", "Martin", 19, 54, false, Floor.getFloor(14, "yellow"), Floor.getFloor(0, "yellow"));
		assertEquals(uStudent1.getAge(),19);
		assertEquals(uStudent1.getPriority(), 1);
		assertFalse(uStudent1.getPMR());
		assertTrue(uStudent1.getWeight() == 54);
		assertEquals(uStudent1.getFinalDestination(), null);
		assertTrue(uStudent1.getSource().equals(Floor.getFloor(14, "yellow")));
		assertTrue(uStudent1.getDestination().equals(Floor.getFloor(0, "yellow")));
		assertTrue(uStudent1 instanceof Student);
		
		User uTeacher1 = new Teacher("Marin", "Loups", 35, 44, true, Floor.getFloor(5, "green"), Floor.getFloor(14, "yellow"));
		assertEquals(uTeacher1.getAge(),35);
		assertEquals(uTeacher1.getPriority(), 6); 
		assertTrue(uTeacher1.getPMR());
		assertTrue(uTeacher1.getWeight() == 44);
		assertTrue(uTeacher1.getFinalDestination().equals(Floor.getFloor(14, "yellow")));
		assertTrue(uTeacher1.getSource().equals(Floor.getFloor(5, "green")));
		assertTrue(uTeacher1.getDestination().equals(Floor.getFloor(9, "green")));
		assertTrue(uTeacher1 instanceof Teacher);
		
		User uTeacher2 = new Teacher("Marin", "Loups", 35, 44, true, Floor.getFloor(5, "green"), Floor.getFloor(14, "yellow"));
		assertTrue(uTeacher2.equals(uTeacher1));
	}
	
	@Test
	public void setCorrespondanceTest() throws FirstFloorException, LastFloorException, NoSuchFloorException {
		User u = new Student("Prenom", "Nom", 20, 85, false, Floor.getFloor(14,  "yellow"), Floor.getFloor(8, "green"));
		assertEquals(Floor.getFloor(9, "yellow"), u.getDestination());
		assertEquals(8, u.getFinalDestination().getFloorNumber());
	}
	
	@Test
	public void demandTest() throws FirstFloorException, LastFloorException, NoSuchFloorException {
		Demand d1 = new Demand(Floor.getFloor(0, "green"), "up");
		Demand d2 = new Demand(Floor.getFloor(0, "green"), "up");
		Demand d3 = new Demand(Floor.getFloor(13, "yellow"), "down");
		assertTrue(d1.equals(d2));
		assertFalse(d1.equals(d3));
	}
	
	
	@Test
	public void compareToTest() throws FirstFloorException, LastFloorException, NoSuchFloorException {
		User u1 = new Student("David", "Ekchajzer", 22, 350, false, Floor.getFloor(0, "green"), Floor.getFloor(4, "green")) ;
		User u2 = new Student("Mathieu", "Ridet", 22, 300, false, Floor.getFloor(0, "green"), Floor.getFloor(4, "green")) ;
		User u3 = new Teacher("test", "test", 21, 375, false, Floor.getFloor(0, "green"), Floor.getFloor(4, "green")) ;
		User u4 = new Teacher("test", "test", 21, 375, true, Floor.getFloor(0, "green"), Floor.getFloor(4, "green")) ;
		
		// Teacher/Student
		assertTrue(u2.getPriority() < u3.getPriority());	
		assertTrue(u2.compareTo(u3) > 0);
		
		// Student/Student (same age)
		assertTrue(u1.getPriority() == u2.getPriority());
		assertTrue(u1.compareTo(u2) == 0);
		
		// Teacher/PMR
		assertTrue(u3.getPriority() < u4.getPriority());
		assertTrue(u3.compareTo(u4) > 0);
	}
	
	@AfterAll
	public static void after() {
		syst.emptySystem();
	}
	
	

	
	/**
	 * Bonus !
	@Test
	public void PriseEscalierTest() throws FirstFloorExeption, LastFloorExeption {
		User u = new Student("Prenom", "Nom", 20, 85, false, Floor.getFloor(14,  "yellow"), Floor.getFloor(8, "green"));
		
		assertEquals(9, u.getSource().getFloorNumber());
		assertEquals("green",  u.getSource().getColor());
	}
	*/
}

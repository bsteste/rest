package br.com.douglasfernandes.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AngleTest {

	@Test
	public void testAngle() {
		Angle angle = new Angle();
		assertEquals(0,angle.getAngle());
	}

	@Test
	public void testAngleInt() {
		Angle angle = new Angle(90);
		assertEquals(90,angle.getAngle());
	}

	@Test
	public void testGetAngle() {
		Angle angle = new Angle();
		angle.setAngle(90);
		assertEquals(90,angle.getAngle());
	}

	@Test
	public void testSetAngle() {
		Angle angle = new Angle();
		angle.setAngle(90);
		assertEquals(90,angle.getAngle());
	}

	@Test
	public void testGetAngleFromString() {
		Angle angle = Angle.getAngleFromString("9");
		assertEquals(90,angle.getAngle());
	}

}

package br.com.douglasfernandes.Control;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.douglasfernandes.Model.Angle;

public class ClockTeste {

	@Test
	public void testGetAngle() {
		Clock clock = new Clock();
		Angle angle = clock.getAngle("9");
		assertEquals(90,angle.getAngle());
	}

}

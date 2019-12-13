package testesUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import mainProject.Visualizar;
import mainProject.Window;

public class TestVisualizar {

	@Test
	public void testVisualizar() {
		Window w=new Window();
		Visualizar vis=new Visualizar(w);
		fail("Failed to load class.");
	}

}

package testesUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import mainProject.Window;

public class TestWindow {

	@Test
	public void testWriteOnFile() {
		Window w = new Window();
		w.writeOnFile("Testing. Attention please");
		fail("Cannot write on file");
	}

	@Test
	public void testSetLoc() {
		Window w = new Window();
		w.setLoc(0);
		w.setLoc(2);
		w.setLoc(421);
		fail("Cannot change lines of code");
	}

	@Test
	public void testSetCyclo() {
		Window w = new Window();
		w.setCyclo(31);
		fail("Cannot change cyclomatics");
	}

	@Test
	public void testSetAtfd() {
		Window w = new Window();
		w.setAtfd(0);
		w.setAtfd(2);
		fail("Cannot change value for ATFD");
	}

	@Test
	public void testSetLaa() {
		Window w = new Window();
		w.setLaa(1.2);
		fail("Cannot change value for LAA.");
	}

	@Test
	public void testGetLoc_Referencia() {
		Window w = new Window();
		w.getLoc_Referencia();
		fail("Couldn't reach Reference Location.");
	}

	@Test
	public void testGetCyclo_Referencia() {
		Window w = new Window();
		w.getCyclo_Referencia();
		fail("Couldn't find value for Cyclo Reference");
	}

	@Test
	public void testGetAtfd_Referencia() {
		Window w = new Window();
		w.getAtfd_Referencia();
		fail("Couldn't find value for ATFD reference");
	}

	@Test
	public void testGetLaa_Referencia() {
		Window w = new Window();
		w.getLaa_Referencia();
		fail("Couldn't find LAA reference");
	}

	@Test
	public void testSetCaminho() {
		Window w = new Window();
		w.setCaminho("Users/LENOVO/Desktop/Long-Method.xls");
		fail("Couldn't reset path");
	}

	@Test
	public void testCorrerExcel() {
		Window w = new Window();
		w.correrExcel();
		fail("Not yet implemented");
	}
	@Test
	public void testAcaoCriar() {
		Window w = new Window();
		w.acaoCriar();
	}
	@Test
	public void testAcao() {
		Window w = new Window();
		w.acaoImportar();
	}
}
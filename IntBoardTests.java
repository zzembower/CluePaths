//John Aspinwall
//Zachary Zembower

package experiment;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class IntBoardTests {

	IntBoard board;
	
	@Before
	public void init() {
		board = new IntBoard();
	}
	
	@Test
	public void testCalcIndex11() {
		int location = board.calcIndex(1,1);
		assertEquals(location, 5);
	}
	
	@Test
	public void testCalcIndex03() {
		int location = board.calcIndex(0,3);
		assertEquals(location, 3);
	}
	
	@Test
	public void testCalcIndex23() {
		int location = board.calcIndex(2,3);
		assertEquals(location, 11);
	}
	
	@Test
	public void testAdjacency0()
	{
		LinkedList testList = board.getAdjList(0);
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.contains(1));
		Assert.assertEquals(2, testList.size());
	}	
	@Test
	public void testAdjacency15()
	{
		LinkedList testList = board.getAdjList(15);
		Assert.assertTrue(testList.contains(11));
		Assert.assertTrue(testList.contains(14));
		Assert.assertEquals(2, testList.size());
	}	
	@Test
	public void testAdjacency7()
	{
		LinkedList testList = board.getAdjList(7);
		Assert.assertTrue(testList.contains(3));
		Assert.assertTrue(testList.contains(6));
		Assert.assertTrue(testList.contains(11));
		Assert.assertEquals(3, testList.size());
	}	
	@Test
	public void testAdjacency8()
	{
		LinkedList testList = board.getAdjList(8);
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.contains(9));
		Assert.assertTrue(testList.contains(12));
		Assert.assertEquals(3, testList.size());
	}	
	@Test
	public void testAdjacency5()
	{
		LinkedList testList = board.getAdjList(5);
		Assert.assertTrue(testList.contains(1));
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.contains(6));
		Assert.assertTrue(testList.contains(9));
		Assert.assertEquals(4, testList.size());
	}	
	@Test
	public void testAdjacency10()
	{
		LinkedList testList = board.getAdjList(10);
		Assert.assertTrue(testList.contains(6));
		Assert.assertTrue(testList.contains(9));
		Assert.assertTrue(testList.contains(11));
		Assert.assertTrue(testList.contains(14));
		Assert.assertEquals(4, testList.size());
	}
	@Test
	public void testTargets0_3()
	{
		board.startTargets(0, 3);
		Set targets= board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(3));
		Assert.assertTrue(targets.contains(4));
	}
	@Test
	public void testTargets15_2()
	{
		board.startTargets(15, 2);
		Set targets= board.getTargets();
		Assert.assertEquals(3, targets.size());
		Assert.assertTrue(targets.contains(13));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(7));
	}
	@Test
	public void testTargets5_6()
	{
		board.startTargets(5, 6);
		Set targets= board.getTargets();
		Assert.assertEquals(7, targets.size());
		Assert.assertTrue(targets.contains(0));
		Assert.assertTrue(targets.contains(2));
		Assert.assertTrue(targets.contains(7));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(8));
		Assert.assertTrue(targets.contains(13));
		Assert.assertTrue(targets.contains(15));
	}
	@Test
	public void testTargets7_3()
	{
		board.startTargets(7, 3);
		Set targets= board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(4));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(14));
		Assert.assertTrue(targets.contains(11));
		Assert.assertTrue(targets.contains(3));
	}
	@Test
	public void testTargets8_3()
	{
		board.startTargets(8, 3);
		Set targets= board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(11));
		Assert.assertTrue(targets.contains(14));
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(4));
		Assert.assertTrue(targets.contains(1));
	}
	@Test
	public void testTargets10_2()
	{
		board.startTargets(10, 2);
		Set targets= board.getTargets();
		Assert.assertEquals(5, targets.size());
		Assert.assertTrue(targets.contains(2));
		Assert.assertTrue(targets.contains(5));
		Assert.assertTrue(targets.contains(7));
		Assert.assertTrue(targets.contains(15));
		Assert.assertTrue(targets.contains(13));
	}
}
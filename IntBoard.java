//John Aspinwall
//Zachary Zembower

package experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class IntBoard {

	ArrayList<String> boardArray;
	ArrayList<LinkedList<Integer>> adjList;
	int size;
	Set targets = new HashSet<Integer>();
	ArrayList<Boolean> visited;
	public IntBoard() {
		super();
		try {
			Scanner s = new Scanner(new File("simpleMap.csv"));
			boardArray = new ArrayList<String>();
			s.useDelimiter(", *");
			while (s.hasNext()){
			    boardArray.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed in IntBoard declaration due to file not found");
			e.printStackTrace();
		}
		//for(String s: list)
			//System.out.println(s);
		//System.out.println(list.size());
		adjList = new ArrayList<LinkedList<Integer>>();
		size = (int) Math.sqrt(boardArray.size());
	}

	public void calcAdjacencies() {
		for(int i = 0; i < boardArray.size(); i++) {
			LinkedList<Integer> set = new LinkedList<Integer>();
			if(i - size >= 0)
				set.add(i-size);
			if(i + size < size * size)
				set.add(i+size);
			if(i - 1 >= 0 && i%size != 0)
				set.add(i-1);
			if(i + 1 < size * size && (i+1)%size != 0)
				set.add(i+1);
			adjList.add(set);
		}
	}
	
	public void startTargets(int location, int roll) {
		LinkedList<Integer> adjList = getAdjList(location);
		visited = new ArrayList<Boolean>();
		for(int i=0;i<boardArray.size();i++)
			visited.add(false);
		visited.set(location, true);
		if(roll == 1) {
			targets.add(this.getAdjList(location));
		} else {
			for(Integer i: adjList) {
				calcTargets(i,roll-1);
			}
		}
	}
	
	public int calcIndex(int row, int col) {
		int location;
		location = row * size + col;
		return location;
	}
	
	public Set getTargets() {
		return targets;
	}
	
	public LinkedList<Integer> getAdjList(int location) {
		return adjList.get(location);
	}
	
	public void calcTargets(int location, int roll) {
		LinkedList<Integer> adjList = getAdjList(location);
		visited.set(location, true);
		for(Integer i: adjList) {
			if(visited.get(i) == false)
				if(roll == 1)
					targets.add(i);
				else
					calcTargets(i,roll-1);
		}

		visited.set(location, false);
	}
	
	public static void main(String args[]) {
		IntBoard intBoard = new IntBoard();
	}
}

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random rng = new Random();
	public static int p=0;
	
	public static Maze generateMaze(int w, int h){
		System.out.println(p);
		width = w;
		height = h;
		maze = new Maze(width, height);
		if(p==0) {
			
			maze.getCell(4, 5).makeAlive(true);
			maze.getCell(6, 5).makeAlive(true);
			maze.getCell(5, 4).makeAlive(true);
		}
		p++;
		//select a random cell to start
		
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				if(checkNeighbors(maze.getCell(x, y))>2) {
					maze.getCell(x, y).change=1;
				}
				if(checkNeighbors(maze.getCell(x, y))==2 && maze.getCell(x, y).isAlive()) {
					//maze.getCell(x, y).change=0;
				}
				if(checkNeighbors(maze.getCell(x, y))<2 && maze.getCell(x, y).isAlive()) {
					maze.getCell(x, y).change=-1;
				}
				
			}
		}
		//call selectNextPath method with the randomly selected cell
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				if(maze.getCell(x, y).change==1) {
						maze.getCell(x, y).makeAlive(true);
						maze.getCell(x, y).change=0;
				}
				else if(maze.getCell(x, y).change==-1) {
					maze.getCell(x, y).makeAlive(false);
					maze.getCell(x, y).change=0;
			}
				else {
					
				}
			}
		}
		return maze;
	}

	

	private static int checkNeighbors(Cell currentCell) {
		int numNei=0;
		for(int i=-1;i<2;i++) {
			for(int x=-1;x<2;x++) {
				if(currentCell.getX()+i>-1 && currentCell.getX()+i<width && currentCell.getY()+x>-1 && currentCell.getY()+x<height) {
					if(maze.getCell(currentCell.getX()+i, currentCell.getY()+x).isAlive()) {
						numNei++;
					}
				}
			}
		}
	
		return numNei;
		
	}

	

	
}
import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	public static final int X_MARGIN = 100;
	public static final int Y_MARGIN = 100;
	
	private int x;
	private int y;
	
	private int size = 25;
	
	private boolean alive;
	public int change=0;

	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		
		alive = false;
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.black);
		if(this.isAlive()) {
			g.setColor(Color.green);
		}
		g.fillOval((x * size) + (size / 2) + X_MARGIN, (y * size) + (size / 2) + Y_MARGIN, 4, 4);
		g.setColor(Color.RED);
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isAlive() {
		return alive;
	}

	public void makeAlive(boolean Alive) {
		alive = Alive;
	}
}

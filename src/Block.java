import java.awt.Color;

public class Block {
	private BoundedGrid<Block> grid;
	private Location location;
	private Color color;

	public Block(BoundedGrid<Block> gr) {
		grid = gr;
		color = Color.red;
		location = new Location(2, 0);
		putSelfInGrid(gr, location);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color col) {
		color = col;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location loc) {
		location = loc;
	}

	public BoundedGrid<Block> getGrid() {
		return grid;
	}

	public void putSelfInGrid(BoundedGrid<Block> gr, Location loc) {
		if (gr.get(loc) != null)
			gr.get(loc).removeSelfFromGrid();
		gr.put(loc, this);
		location = loc;
		grid = gr;
	}

	public void removeSelfFromGrid() {
		grid.put(location, null);
		location = null;
		grid = null;
	}

	public boolean translate(int x, int y) // positive x and y means moving x
											// down and y right
	{
		Location oldloc = location;
		Location newloc = new Location(location.getRow() + x, location.getCol()
				+ y);
		if (grid.isValid(newloc)) {
			if (grid.get(newloc) == null) {
				putSelfInGrid(grid, newloc);
				grid.remove(oldloc);
				return true;
			}
		}
		return false;
	}

}


public class Game implements ArrowListener{
	public static void main(String args[])
	{
		Game game = new Game();
		game.play();
	}
	
	private BoundedGrid<Block> grid;
	private BlockDisplay display;
	private Block block;
	
	
	public Game()
	{
		grid = new BoundedGrid<Block>(4,4);
		display = new BlockDisplay(grid);
		display.setTitle("Blockmover");
		display.setArrowListener(this);
		block = new Block(grid);
	}
	
	public void play()
	{
		display.showBlocks();
		while(true)
		{}
	}
	
	public void upPressed()
	{
		block.translate(-1, 0);
		display.showBlocks();
	}
	public void downPressed()
	{
		block.translate(1, 0);
		display.showBlocks();
	}
	public void leftPressed()
	{
		block.translate(0, -1);
		display.showBlocks();
	}
	public void rightPressed()
	{
		block.translate(0, 1);
		display.showBlocks();
	}
}

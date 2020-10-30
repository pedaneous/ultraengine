package UltraEngine.AddOns;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import UltraEngine.Shapes.*;

public class TileMap {

	private int x;
	private int y;

	private int tileCellSize;
	
	private int tileSize;
	private int[][] map;
	private int mapWidth;
	private int mapHeight;

	private BufferedImage spriteSheet;
	
	public BufferedImage[] allTiles;
	private ArrayList<BufferedImage> allTilesAL = new ArrayList<BufferedImage>();
	
	public ArrayList<Tile> tiles = new ArrayList<Tile>();

	public TileMap(String s, String tileSet, int tileCellSize, int tileSize) {
		this.tileCellSize = tileCellSize;
		this.tileSize = tileSize;
		loadSpriteSheet(tileSet);
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			mapWidth = Integer.parseInt(br.readLine());
			mapHeight = Integer.parseInt(br.readLine());
			map = new int[mapHeight][mapWidth];

			String delims = " ";
			for (int row = 0; row < mapHeight; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for (int col = 0; col < mapWidth; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			br.close();
			loadTiles();
			addTiles();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void loadTiles() {
		for(int y = 0; y < spriteSheet.getHeight()/tileCellSize; y++) {
			for(int x = 0; x < spriteSheet.getWidth()/tileCellSize; x++) {
				allTilesAL.add(spriteSheet.getSubimage(x*tileCellSize, y*tileCellSize, tileCellSize, tileCellSize));
			}
		}
		allTiles = new BufferedImage[allTilesAL.size()];
		for(int i = 0; i < allTilesAL.size(); i++) {
			allTiles[i] = allTilesAL.get(i);
		}
	}

	private void addTiles() {
		for (int row = 0; row < mapHeight; row++) {
			for (int col = 0; col < mapWidth; col++) {
				int rc = map[row][col];
				if (rc != 1) {
					tiles.add(new Tile(allTiles[rc], x + col * tileSize,
							y + row * tileSize, tileSize, tileSize));
				}
			}
		}
	}

	public void loadSpriteSheet(String tileSet) {
		try {
			spriteSheet = ImageIO.read(getClass().getResourceAsStream("/TileSets/" + tileSet + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {
		for (Tile t : tiles) {
			t.draw(g);
		}
	}

}

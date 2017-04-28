package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class PlatformTile extends Tile {
	
	public static int 	WIDTH = 24,
						HEIGHT = 5;
	public PlatformTile(int id) {
		super(Assets.platform, id);
	}
	


}

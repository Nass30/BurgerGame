package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class EmptyTile extends Tile{

	public EmptyTile(int id) {
		super(Assets.empty, id);
		isSolid();
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	

}

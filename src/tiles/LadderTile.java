package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class LadderTile extends Tile{
	public static int 	WIDTH = 10,
						HEIGHT = 15;
	public LadderTile(int id) {
		super(Assets.ladder1, id);
		switch(id) {
		case 2 : setTexture(Assets.ladder1);
			break;
		case 3 : setTexture(Assets.ladder2);
			break;
		case 4 : setTexture(Assets.ladder3);
			break;
		case 5 : setTexture(Assets.ladder4);
			break;
		}
	}
	
	@Override
	public String toString() {
		
		return "ladderTile";
	}

}

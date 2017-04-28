package states;

import java.awt.Graphics;

import Package.Game;
import Package.Handler;
import gfx.Assets;

public class MenuState extends State{
	
	public MenuState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.loaderImage,0,0,handler.getGame().getWidth(),handler.getGame().getHeight(),null);
	}
	

}

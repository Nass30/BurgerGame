package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 20, height = 20;
	
	public static BufferedImage platform, player, empty, emptySolid,
	
								ladder1, ladder2, ladder3, ladder4,
								
								meal1, meal2, meal3,
								topBread1,topBread2,topBread3,
								botBread1,botBread2,botBread3,
								salad1, salad2, salad3,
								tomato1, tomato2, tomato3,
								egg1, egg2, egg3,
								foodPlatform1, foodPlatform2, foodPlatform3,
								loaderImage,newHighImage;
	
	public static BufferedImage[] 	player_down, player_left, player_up, player_right,
									salad_down, salad_left, salad_up, salad_right,
									pepper_down, pepper_left, pepper_up, pepper_right,
									egg_down, egg_left, egg_up, egg_right;

	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/sheet.png"));
		loaderImage = ImageLoader.loadImage("/images/ecran_chargement.jpg");
		newHighImage = ImageLoader.loadImage("/images/new_high.png");
		
		platform = sheet.crop(0, 362, 24, 5);
		empty = sheet.crop(0,357, 10, 5);
		emptySolid = sheet.crop(222, 240, 10, 5);
		
		foodPlatform1 = sheet.crop(245, 335, 13, 9);
		foodPlatform2 = sheet.crop(258, 335, 12, 9);
		foodPlatform3 = sheet.crop(270, 335, 13, 9);

		ladder1 = sheet.crop(103,347, 10, 5);
		ladder2 = sheet.crop(103,352, 10, 5);
		ladder3 = sheet.crop(103,357, 10, 5);
		ladder4 = sheet.crop(103,362, 10, 5);
		
		meal1 = sheet.crop(151, 230, 9, 7);
		meal2 = sheet.crop(160, 230, 10, 7);
		meal3 = sheet.crop(170, 230, 9, 7);
		
		topBread1 = sheet.crop(85,230,11,7);
		topBread2 = sheet.crop(96,230,10,7);
		topBread3 = sheet.crop(106,230,11,7);
		
		botBread1 = sheet.crop(117,230,11,6);
		botBread2 = sheet.crop(128,230,10,6);
		botBread3 = sheet.crop(138,230,11,6);
		
		salad1 = sheet.crop(181,230,11,7);
		salad2 = sheet.crop(192,230,10,7);
		salad3 = sheet.crop(202,230,11,7);
		
		tomato1 = sheet.crop(214,230,10,7);
		tomato2 = sheet.crop(224,230,10,7);
		tomato3 = sheet.crop(234,230,10,7);
		
		egg1 = sheet.crop(247,231,9,6);
		egg2 = sheet.crop(128,231,10,6);
		egg3 = sheet.crop(139,231,9,6);

		player = sheet.crop(0, 0, width, height);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		salad_down = new BufferedImage[2];
		salad_up = new BufferedImage[2];
		salad_left = new BufferedImage[2];
		salad_right = new BufferedImage[2];
		
		pepper_down = new BufferedImage[2];
		pepper_up = new BufferedImage[2];
		pepper_left = new BufferedImage[2];
		pepper_right = new BufferedImage[2];
		
		egg_down = new BufferedImage[2];
		egg_up = new BufferedImage[2];
		egg_left = new BufferedImage[2];
		egg_right = new BufferedImage[2];
		
		player_down[0] = sheet.crop(40, 0, width, height);
		player_down[1] = sheet.crop(60, 0, width, height);
		player_up[0] = sheet.crop(80, 0, width, height);
		player_up[1] = sheet.crop(100, 0, width, height);
		player_left[0] = sheet.crop(160, 0, width, height);
		player_left[1] = sheet.crop(180, 0, width, height);
		player_right[0] = sheet.crop(120, 0, width, height);
		player_right[1] = sheet.crop(140, 0, width, height);
		
		salad_down[0] = sheet.crop(0, 105, 20, 20);
		salad_down[1] = sheet.crop(20, 105, 20, 20);
		salad_up[0] = sheet.crop(40, 105, 20, 20);
		salad_up[1] = sheet.crop(60, 105, 20, 20);
		salad_left[0] = sheet.crop(120, 105, 20, 20);
		salad_left[1] = sheet.crop(140, 105, 20, 20);
		salad_right[0] = sheet.crop(80, 105, 20, 20);
		salad_right[1] = sheet.crop(100, 105, 20, 20);
		
		pepper_down[0] = sheet.crop(0, 125, 20, 20);
		pepper_down[1] = sheet.crop(20, 125, 20, 20);
		pepper_up[0] = sheet.crop(40, 125, 20, 20);
		pepper_up[1] = sheet.crop(60, 125, 20, 20);
		pepper_left[0] = sheet.crop(120, 125, 20, 20);
		pepper_left[1] = sheet.crop(140, 125, 20, 20);
		pepper_right[0] = sheet.crop(80, 125, 20, 20);
		pepper_right[1] = sheet.crop(100, 125, 20, 20);
		
		egg_down[0] = sheet.crop(0, 145, 20, 20);
		egg_down[1] = sheet.crop(20, 145, 20, 20);
		egg_up[0] = sheet.crop(40, 145, 20, 20);
		egg_up[1] = sheet.crop(60, 145, 20, 20);
		egg_left[0] = sheet.crop(120, 145, 20, 20);
		egg_left[1] = sheet.crop(140, 145, 20, 20);
		egg_right[0] = sheet.crop(80, 145, 20, 20);
		egg_right[1] = sheet.crop(100, 145, 20, 20);
	}
}

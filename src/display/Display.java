package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, heigth;
	
	public Display(String title, int width, int heigth) {
		this.title = title;
		this.width = width;
		this.heigth = heigth;
		createDisplay();
	}
	
	public void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, heigth);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,heigth));
		canvas.setMaximumSize(new Dimension(width,heigth));
		canvas.setMinimumSize(new Dimension(width,heigth));
		canvas.setFocusable(false);
		canvas.setBackground(Color.black);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}

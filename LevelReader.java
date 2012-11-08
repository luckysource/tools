package tools;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class LevelReader {
	
	/**
	 * 
	 * @param location The location of the map image
	 * @return int[][]  	- An integer RGB value for each [x][y] pixel
	 * 
	 */
	public static Color [][] levelRead(String location){	
		File f = new File(location);
		BufferedImage img;
		boolean quit = false;
		do{
			try {
				img = ImageIO.read(f);
				int w = img.getWidth();
				int h = img.getHeight();
			
				Color pixels [][] = new Color [w][h];
		
				for( int i=0; i<w; i++ )
					for( int j=0; j<h; j++ )
						pixels[i][j] = new Color(img.getRGB(i,j));
				
				return pixels;
			} 
			catch (IOException e){		
				e.printStackTrace();
			}
			
			
			//default icon, custom title
			int n = JOptionPane.showConfirmDialog(null,
				"Map failed to load \nWould you like to try loading a map again?",
			    "Map load error!",
			    JOptionPane.YES_NO_OPTION);
			
			if (n==1) quit = true;
			
		}while (!quit);
		return null;
	}
	
	
}

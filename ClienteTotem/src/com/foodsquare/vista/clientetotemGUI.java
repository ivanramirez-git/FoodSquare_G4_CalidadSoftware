package com.foodsquare.vista;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class clientetotemGUI {

	private JFrame frame;

	

	/**
	 * Create the application.
	 * @throws MalformedURLException 
	 */
	public clientetotemGUI() throws MalformedURLException {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws MalformedURLException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		
		URL url;
		try {
			url = new URL("https://s3.us-west-1.amazonaws.com/files-muy/photos/menus/dishes/thumbnails/Arroz_Con_Pollo_Kraft_Col.png");

			Image image = ImageIO.read(url);
			
			lblNewLabel.setIcon(new ImageIcon(image));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

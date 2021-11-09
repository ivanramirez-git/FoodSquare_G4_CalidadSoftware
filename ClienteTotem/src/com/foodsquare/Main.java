package com.foodsquare;

import java.awt.EventQueue;
import java.net.MalformedURLException;

import com.foodsquare.vista.clientetotemGUI;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					clientetotemGUI window = new clientetotemGUI();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
	}
}

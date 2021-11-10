package com.foodsquare;

import java.awt.EventQueue;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;

import com.foodsquare.controlador.Controlador;
import com.foodsquare.vista.clientetotemGUI;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Controlador c = new Controlador();
		c.iniciar();

		/*
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
		*/
	}
}

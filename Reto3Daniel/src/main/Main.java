package main;

import java.util.Scanner;

import clases.Clientes;
import dao.ClientesDAO;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1. Gestion de clientes");
		System.out.println("2. Catálogo de productos");
		System.out.println("3. Crear pedidos");
		System.out.println("4. informes");
		int num=util.Funciones.dimeEntero("dime que quieres hacer", sc);
		switch (num) {
		case 1:
			
			System.out.println("1. Alta de nuevos clientes");
			System.out.println("2. Busqueda por código");
			num=util.Funciones.dimeEntero("que quieres hacer dentro de gestion de clientes", sc);
			switch (num) {
			case 1:	
				int idCliente=util.Funciones.dimeEntero("dime el id del cliente", sc);
				String nombre=util.Funciones.dimeString("dime el nombre del cliente", sc);
				String direccion=util.Funciones.dimeString("dime la direccion del cliente", sc);
				int codigo=util.Funciones.dimeEntero("dime el codigo del cliente", sc);
				Clientes clientes=new Clientes(idCliente,nombre,direccion,codigo);
				ClientesDAO.inserta(clientes);
				System.out.println("el cliente se ha insertado correctamente");
			case 2:
			
			}
		case 2:

		case 3:
		
		case 4:
		}

	}

}

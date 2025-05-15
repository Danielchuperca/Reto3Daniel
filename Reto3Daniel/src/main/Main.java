package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.Clientes;
import clases.Productos;
import dao.ClientesDAO;
import dao.productosDAO;

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
			
			submenu1(sc);
				break;
			
		case 2:
			    List<Productos> listaProd = productosDAO.listaProd();
			    for (Productos prod : listaProd) {
					System.out.println(prod);
				}
				String nombre=util.Funciones.dimeString("dime el nombre del producto que quieres", sc);
				String talla=util.Funciones.dimeString("dime la talla del producto que quieres", sc);
				String color=util.Funciones.dimeString("dime el color que quieres del producto", sc);
				Productos prod=new Productos(nombre,talla,color);
				if(prod.getNombre().equals(nombre)||prod.getTalla().equals(talla)||prod.getColor().equals(color)) {
				System.out.println(dao.productosDAO.buscarProdu(prod)); 
				}
				else {
				System.out.println(dao.productosDAO.buscarProdu(prod));
				}
		case 3:
		
		case 4:

		}

	}

	private static void submenu1(Scanner sc) {
		int num;
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
			break;
		case 2:
			Clientes clien2=null;
			int cod=util.Funciones.dimeEntero("dime el codigo que quieres que busque", sc);
			clien2=dao.ClientesDAO.buscarCodigo(cod);
			if(clien2!=null) {
				System.out.println(clien2);
				System.out.println("añade los datos necesarios");
				String nombre2=util.Funciones.dimeString("dime el nombre del cliente", sc);
				String direccion2=util.Funciones.dimeString("dime la direccion del cliente", sc);
				int codigo2=util.Funciones.dimeEntero("dime el codigo del cliente", sc);
				 clien2=new Clientes(clien2.getIdCliente() ,nombre2,direccion2,codigo2);
				 System.out.println(clien2);
				dao.ClientesDAO.actualizarCliente(clien2);
				
			}
			else {
				System.out.println("no existe");
			}
			break;
			
		}
	}

}

package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import clases.Clientes;
import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import dao.ClientesDAO;
import dao.PedidoDAO;
import dao.PedidoProductoDAO;
import dao.productosDAO;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {

			System.out.println("1. Gestion de clientes");
			System.out.println("2. Catálogo de productos");
			System.out.println("3. Crear pedidos");
			System.out.println("4. informes");

			num = util.Funciones.dimeEntero("dime que quieres hacer, si quieres salir pulsa 0", sc);
			switch (num) {
			case 1:

				submenu1(sc);
				break;

			case 2:
				submenu2(sc);
				break;
			case 3:
				Clientes clien2 = null;
				Pedidos pedi = null;
				do {
					int cod = util.Funciones.dimeEntero("dime el codigo que quieres que busque", sc);
					clien2 = dao.ClientesDAO.buscarCodigo(cod);
					System.out.println(clien2);
					
				} while (clien2 == null);
				LocalDate hoy = LocalDate.now();
				Date hoy2 = util.Funciones.convierte_LocalDate_a_Date(hoy);
				pedi = new Pedidos(clien2, 0, clien2.getDireccion(), hoy2);

				String nomProd = "";
				List<Productos> listaProd = productosDAO.listaProd();
				for (Productos produ : listaProd) {
					System.out.println(produ);
				}
				
				do {
					
					nomProd = util.Funciones.dimeString("dime nombres de productos hasta poner fin", sc);
					if (verificarProd(nomProd)==true) {
						int cantProd= util.Funciones.dimeEntero("dime la cantidad de ese producto que quieres", sc);
						Productos prod =productosDAO.buscarNombre(nomProd);
						
						double sum=cantProd*prod.getPrecio();
						PedidoProducto pedProd = new PedidoProducto(pedi,prod,cantProd,sum);
						PedidoProductoDAO.inserta(pedProd, pedi, prod);
					}
					else {
						System.out.println("no has introducido ningun producto");
					}
					
					
				} while (!(nomProd.equals("fin")));
				System.out.println(pedi);
				String direc=util.Funciones.dimeString("Quieres usar esta direccion de envio=si/no", sc);
				if(direc.equals("no")) {
					double precioTotalAct=PedidoDAO.actualizarPrecioTotal(pedi);
					String nuevaDirec=util.Funciones.dimeString("dime la nueva direccion", sc);
					pedi.setDireccionEnvio(nuevaDirec) ;
					pedi.setPrecioTotal(precioTotalAct);
					PedidoDAO.insertaPedidos(pedi, clien2);
				}
			

			case 4:

			}
		} while (num != 0);
	}

	private static boolean verificarProd(String nombre) {
		List<Productos> listaProd = productosDAO.listaProd();
		for (Productos produ : listaProd) {
			if(produ.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	private static void submenu2(Scanner sc) {

		List<Productos> listaProd = productosDAO.listaProd();
		for (Productos produ : listaProd) {
			System.out.println(produ);
		}
		System.out.println("dime el nombre del producto que quieres");
		String nombre = sc.nextLine();
		System.out.println("dime el color del producto que quieres");
		String talla = sc.nextLine();
		System.out.println("dime la talla que quieres del producto");
		String color = sc.nextLine();
		Productos prod = new Productos(nombre, color, talla);

		List<Productos> listaProd2 = productosDAO.buscarProdu(prod);
		for (Productos prod1 : listaProd2) {
			System.out.println(prod1);
		}
		// System.out.println(dao.productosDAO.buscarProdu(prod));
	}

	private static void submenu1(Scanner sc) {
		int num;
		System.out.println("1. Alta de nuevos clientes");
		System.out.println("2. Busqueda por código");
		num = util.Funciones.dimeEntero("que quieres hacer dentro de gestion de clientes", sc);
		switch (num) {
		case 1:
			int idCliente = util.Funciones.dimeEntero("dime el id del cliente", sc);
			String nombre = util.Funciones.dimeString("dime el nombre del cliente", sc);
			String direccion = util.Funciones.dimeString("dime la direccion del cliente", sc);
			int codigo = util.Funciones.dimeEntero("dime el codigo del cliente", sc);
			Clientes clientes = new Clientes(idCliente, nombre, direccion, codigo);
			ClientesDAO.inserta(clientes);
			System.out.println("el cliente se ha insertado correctamente");
			break;
		case 2:
			Clientes clien2 = null;
			int cod = util.Funciones.dimeEntero("dime el codigo que quieres que busque", sc);
			clien2 = dao.ClientesDAO.buscarCodigo(cod);
			if (clien2 != null) {
				System.out.println(clien2);
				System.out.println("añade los datos necesarios");
				String nombre2 = util.Funciones.dimeString("dime el nombre del cliente", sc);
				String direccion2 = util.Funciones.dimeString("dime la direccion del cliente", sc);
				int codigo2 = util.Funciones.dimeEntero("dime el codigo del cliente", sc);
				clien2 = new Clientes(clien2.getIdCliente(), nombre2, direccion2, codigo2);
				System.out.println(clien2);
				dao.ClientesDAO.actualizarCliente(clien2);

			} else {
				System.out.println("no existe");
			}
			break;

		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.Clientes;
import clases.PedidoProducto;
import clases.Pedidos;
import util.Conexion;

public class PedidoDAO {
	public static void insertaPedidos(Pedidos ped, Clientes clien)
	
	{
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("insert into pedidos (idcliente,precioTotal,direccionEnvio,fecha) values (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
	
			pst.setInt(1, clien.getIdCliente());
			pst.setDouble(2, ped.getPrecioTotal() );
			pst.setString(3, ped.getDireccionEnvio());
			pst.setDate(4, util.Funciones.convierteFecha(ped.getFecha()));
			pst.execute();
			
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next())
				ped.setIdPedido(rs.getInt(1));
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
	}
	public static double actualizarPrecioTotal(Pedidos pedi) {
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//genero el sql
			PreparedStatement pst = con.prepareStatement("update pedidos set preciototal=? where idpedido=?;");
			pst.setDouble(1,pedi.getPrecioTotal());
			pst.setInt(2,pedi.getIdPedido());
			
			
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return pedi.getPrecioTotal();

	}
	public static void actualizarDireccion(Pedidos pedi) {
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//genero el sql
			PreparedStatement pst = con.prepareStatement("update pedidos set direccionEnvio=?;");
			pst.setString(1,pedi.getDireccionEnvio());
			pst.setInt(2,pedi.getIdPedido());
			
			
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}

	}
}

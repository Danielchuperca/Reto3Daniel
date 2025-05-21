package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import util.Conexion;

public class PedidoProductoDAO {
	public static PedidoProducto inserta(PedidoProducto pe, Pedidos ped, Productos prod)
	{
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("insert into pedidoproducto (idpedido, idproducto,unidades,precio) values (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			
			pst.setInt(1, ped.getIdPedido() );
			pst.setInt(2, prod.getIdProducto() );
			pst.setInt(3, pe.getUnidades());
			pst.setDouble(4, pe.getPrecio());
			pst.execute();
			//recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next())
				pe.setIdPedidoProducto(rs.getInt(1));
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return pe;
	}
	public static void sumatorioPrecioProd(PedidoProducto pediProd) {
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//genero el sql
			PreparedStatement pst = con.prepareStatement("select sum(precio) from pedidoproducto where idpedido=? group by idpedido;");
			pst.setInt(1,pediProd.getIdPedidoProducto());
			
			
			
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}

	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.PedidoProducto;
import util.Conexion;

public class PedidoProductoDAO {
	/*public static void inserta(PedidoProducto pe)
	{
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("insert into clientes (idcliente,nombre,direccion,codigo) values (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, );
			pst.setString(2, );
			pst.setString(3, );
			pst.setInt(4, );
			pst.execute();
			//recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next())
				(rs.getInt(1));
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
	}*/
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Productos;
import util.Conexion;

public class productosDAO {
	public static void buscarProdu(Productos prod) {
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("select * from clientes where codigo=?;");
	
			pst.execute();
			//recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
	}
}

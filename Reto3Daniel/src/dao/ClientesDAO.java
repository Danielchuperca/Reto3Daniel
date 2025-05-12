package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.Clientes;
import util.Conexion;

public class ClientesDAO {
	public static void inserta(Clientes clien)
	{
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("insert into clientes (idcliente,nombre,direccion,codigo) \r\n"
					+ "values (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, clien.getIdCliente());
			pst.setString(2, clien.getNombre());
			pst.setString(3, clien.getDireccion());
			pst.setInt(4, clien.getCodigo());
			pst.execute();
			//recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next())
				clien.setIdCliente(rs.getInt(1));
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
	}
}

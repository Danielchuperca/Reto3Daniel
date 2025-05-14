package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Categorias;
import clases.Clientes;
import clases.Productos;
import util.Conexion;

public class productosDAO {
	public static Productos buscarProdu(Productos prod) {
		Productos pro=null;
		Categorias cat=null;
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("select * from productos where nombre=? or talla=? or color=?;");
			pst.setString(1,prod.getNombre());
			pst.setString(2,prod.getTalla());
			pst.setString(3, prod.getColor());
			pst.execute();
			//recupero clave
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				pro=new Productos(rs.getInt("idProducto"),cat,rs.getString("nombre"),rs.getInt("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),rs.getInt("stock"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return pro;
	}

	
}

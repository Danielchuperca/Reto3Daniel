package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import clases.Clientes;
import clases.Productos;
import util.Conexion;

public class productosDAO {
	public static List<Productos> listaProd(){
		List<Productos> lista = new ArrayList<Productos>();
		try(Connection con = Conexion.abreConexion())
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select idproducto, cat.idcategoria,cat.nombre as nombreCat, prod.nombre, precio, descripcion, color, talla, stock from productos prod\r\n"
					+ "inner join categorias cat on prod.idcategoria = cat.idcategoria\r\n"
					+ "order by idproducto;");
			while(rs.next())
			{
				Categorias cate=new Categorias(rs.getInt("idCategoria"),rs.getString("nombre"));
				lista.add(new Productos(rs.getInt("IdProducto"),cate,rs.getString("nombre"),rs.getInt("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),rs.getInt("stock")));
			}
		
		}catch (Exception ex){
			ex.printStackTrace();
		}
		//cierro conexion
		return lista;
		
		}
	
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

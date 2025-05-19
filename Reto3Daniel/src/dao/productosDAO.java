package dao;

import java.sql.CallableStatement;

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
			ResultSet rs = stmt.executeQuery("select idproducto, cat.idcategoria,cat.nombre, prod.nombre, precio, descripcion, color, talla, stock from productos prod\r\n"
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
	
	public static List<Productos> buscarProdu(Productos prod) {
		
		List<Productos> lisProd=new ArrayList<Productos>();
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			CallableStatement cs = con.prepareCall("CALL buscarProducto(?,?,?)");
			// Se proporcionan valores de entrada al procedimiento
			cs.setString(1, prod.getNombre());
			//el segundo parámetro es de salida
			cs.setString(2, prod.getColor());
			cs.setString(3, prod.getTalla());
			
			cs.execute();

			//para recuperar el parámetro de salida
			
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				Categorias cate=new Categorias(rs.getInt("idCategoria"),rs.getString("nombre"));
				Productos pro=new Productos(rs.getInt("IdProducto"),cate,rs.getString("nombre"),rs.getDouble("precio"),rs.getString("descripcion"),
						rs.getString("color"),rs.getString("talla"),rs.getInt("stock"));
				lisProd.add(pro);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return lisProd;
		
	}

	
}

package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.Clientes;
import util.Conexion;
import util.Funciones;

public class ClientesDAO {
	public static void inserta(Clientes clien)
	{
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("insert into clientes (idcliente,nombre,direccion,codigo) values (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
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
	public static Clientes buscarCodigo(int codigo) {
		Clientes c=null;
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//creo select
			PreparedStatement pst = con.prepareStatement("select * from clientes where codigo=?");
			pst.setInt(1,codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				c=new Clientes(rs.getInt("idCliente"),rs.getString("nombre"),rs.getString("direccion"),rs.getInt("codigo"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return c;
	}
	public static void actualizarCliente(Clientes clien, int cod) {
		try {
			//abro conexion
			Connection con = Conexion.abreConexion();
			//genero el sql
			PreparedStatement pst = con.prepareStatement("update clientes set nombre=?, direccion=? where codigo =?");
			pst.setString(1,clien.getNombre());
			pst.setString(2,clien.getDireccion());
			pst.setInt(3, cod);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}

	}
}


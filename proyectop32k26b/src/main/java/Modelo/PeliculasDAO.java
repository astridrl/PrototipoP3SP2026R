package Modelo;

import Controlador.clsPeliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author astri
 */


public class PeliculasDAO {

    //Consultas
    private static final String SQL_SELECT = "SELECT idPeliculas, Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio " + "FROM Peliculas";

    private static final String SQL_SELECT_ID = "SELECT idPeliculas, Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio " + "FROM Peliculas WHERE idPeliculas = ?";

    private static final String SQL_INSERT = "INSERT INTO Peliculas(Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio) " + "VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE Peliculas SET Nombre=?, Clasificacion=?, Genero=?, " + "Subtitulado=?, Idioma=?, precio=? WHERE idPeliculas=?";

    private static final String SQL_DELETE = "DELETE FROM Peliculas WHERE idPeliculas=?";

 
    public List<clsPeliculas> consultarPeliculas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<clsPeliculas> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs   = stmt.executeQuery();

            while (rs.next()) {
                clsPeliculas pelicula = new clsPeliculas();

                pelicula.setIdPeliculas(rs.getInt("idPeliculas"));
                pelicula.setNombre(rs.getString("Nombre"));
                pelicula.setClasificacion(rs.getString("Clasificacion"));
                pelicula.setGenero(rs.getString("Genero"));
                pelicula.setSubtitulado(rs.getString("Subtitulado"));
                pelicula.setIdioma(rs.getString("Idioma"));
                pelicula.setPrecio(rs.getDouble("precio"));

                lista.add(pelicula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    // Por id, esto me lo había copiado del DAO de usuario :D
   
    public clsPeliculas consultarPeliculaPorId(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, pelicula.getIdPeliculas());
            rs   = stmt.executeQuery();

            if (rs.next()) {
                pelicula.setNombre(rs.getString("Nombre"));
                pelicula.setClasificacion(rs.getString("Clasificacion"));
                pelicula.setGenero(rs.getString("Genero"));
                pelicula.setSubtitulado(rs.getString("Subtitulado"));
                pelicula.setIdioma(rs.getString("Idioma"));
                pelicula.setPrecio(rs.getDouble("precio"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return pelicula;
    }

    //Insert
    public int ingresarPelicula(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getClasificacion());
            stmt.setString(3, pelicula.getGenero());
            stmt.setString(4, pelicula.getSubtitulado());
            stmt.setString(5, pelicula.getIdioma());
            stmt.setDouble(6, pelicula.getPrecio());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    //Uptdate
    public int actualizarPelicula(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getClasificacion());
            stmt.setString(3, pelicula.getGenero());
            stmt.setString(4, pelicula.getSubtitulado());
            stmt.setString(5, pelicula.getIdioma());
            stmt.setDouble(6, pelicula.getPrecio());
            stmt.setInt(7,    pelicula.getIdPeliculas());  // WHERE

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    //Delete
    public int borrarPelicula(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pelicula.getIdPeliculas());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}

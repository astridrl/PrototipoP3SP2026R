/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import Modelo.PeliculasDAO;


/**
 *
 * @author miais
 */
public class clsPeliculas {
     //Tabla peliculas
    private int    idPeliculas;
    private String Nombre;
    private String Clasificacion;
    private String Genero;
    private String Subtitulado;
    private String Idioma;
    private double precio;          


    public clsPeliculas() {
    }

    //Constructor ID
    public clsPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    //Constructor 
    public clsPeliculas(int idPeliculas, String nombre, String clasificacion,
                        String genero, String subtitulado, String idioma, double precio) {
        this.idPeliculas   = idPeliculas;
        this.Nombre        = nombre;
        this.Clasificacion = clasificacion;
        this.Genero        = genero;
        this.Subtitulado   = subtitulado;
        this.Idioma        = idioma;
        this.precio        = precio;
    }
//Get y set

    public int getIdPeliculas() {
        return idPeliculas;
    }

    public void setIdPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getSubtitulado() {
        return Subtitulado;
    }

    public void setSubtitulado(String Subtitulado) {
        this.Subtitulado = Subtitulado;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "clsPeliculas{" + "idPeliculas=" + idPeliculas + ", Nombre=" + Nombre + ", Clasificacion=" + Clasificacion + ", Genero="+ Genero + ", Subtitulado="   + Subtitulado + ", Idioma="+ Idioma + ", precio=" + precio + '}';
    }
    
}

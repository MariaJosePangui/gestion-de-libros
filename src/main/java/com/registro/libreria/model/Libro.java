package com.registro.libreria.model;

import com.registro.libreria.model.data.DBConnector;
import com.registro.libreria.model.data.dao.LibroDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Libro {
    int id;
    private String nombre;
    private String categoria;
    private String date;
    public Libro(int id, String nombre, String categoria, String date) {
        this.id=id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.date = date;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public boolean registrarLibro(){
        Connection connection= DBConnector.connection("libreria","root","");
        DSLContext query= DSL.using(connection);
        return new LibroDAO().registrarLibro(query,this);
    }
    public ArrayList<Libro> buscarLibro(){
        System.out.println("buscarLibros");
        Connection connection= DBConnector.connection("libreria","root","");
        DSLContext query= DSL.using(connection);
        ArrayList<Libro> libros= new LibroDAO().obtenerLibros(query,this);
        System.out.println("Ya se obtuvieron los libros");
        return libros;
    }

    public boolean eliminarLibro() {
        Connection connection= DBConnector.connection("libreria","root","");
        DSLContext query= DSL.using(connection);
        return  new LibroDAO().eliminarLibro(query,this);
    }
}
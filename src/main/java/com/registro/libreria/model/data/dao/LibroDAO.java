package com.registro.libreria.model.data.dao;

import com.registro.libreria.model.Libro;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.ArrayList;

public class LibroDAO {
    public boolean registrarLibro(DSLContext query, Libro libro) {
        String tituloLibro=libro.getNombre();
        String fechaLibro=libro.getDate();
        String categoria=libro.getCategoria();
        int result=query.insertInto(DSL.table("libros"),
                DSL.field("cod_libro"),
                DSL.field("titulo"),
                DSL.field("categoria"),
                DSL.field("fecha_publicacion")).values(
                null,
                tituloLibro,
                categoria,
                fechaLibro).execute();
        return result==1;
    }
    public ArrayList<Libro> obtenerLibros(DSLContext query, Libro libro){
        String tituloLibro=libro.getNombre();
        String categoria=libro.getCategoria();
        Result<Record> result=query.select().from(DSL.table("libros")).where(
                DSL.field("titulo").eq(tituloLibro)).or(DSL.field("categoria").eq(categoria)).fetch();
        ArrayList<Libro>libros=new ArrayList<>();
        System.out.println(result.getValue(0,"cod_libro"));
        System.out.println(result.getValue(0,"titulo"));
        System.out.println(result.getValue(0,"categoria"));
        System.out.println(result.getValue(0,"fecha_publicacion"));

        for (int i = 0; i < result.size(); i++) {
            libros.add(
                    new Libro(
                            Integer.parseInt(result.getValue(i,"cod_libro").toString()),
                            result.getValue(i,"titulo").toString(),
                            result.getValue(i,"categoria").toString(),
                            result.getValue(i,"fecha_publicacion").toString()
                    )
            );
        }
        return libros;
    }

    public boolean eliminarLibro(DSLContext query, Libro libro) {
        int idLibro=libro.getId();
        int result=0;
        try{
            result=query.deleteFrom(
                            DSL.table("libros"))
                    .where(DSL.field("cod_libro").eq(idLibro))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result==1;
    }
}
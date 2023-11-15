package com.registro.libreria.model.data.dao;

import com.registro.libreria.model.Categoria;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.ArrayList;

public class CategoriaDAO {
    public static ArrayList<Categoria> obtenerCategorias(DSLContext query){
        Result result=query.select().from(DSL.table("categoria")).fetch();
        ArrayList<Categoria>categorias=new ArrayList<>();
        System.out.println("categorias");
        for (int i = 0; i < result.size(); i++) {
            categorias.add(new Categoria(
                    (Integer) result.getValue(i,"cod_categoria"),
                    (String) result.getValue(i,"nombre")));
        }
        return categorias;
    }

    public boolean registrarCategoria(DSLContext query, Categoria categoria) {
        String nombreCategoria=categoria.getNombreCategoria();
        int result=query.insertInto(DSL.table("categoria"),
                        DSL.field("cod_categoria"),
                        DSL.field("nombre"))
                .values(null,nombreCategoria).execute();
        return result==1;
    }
}
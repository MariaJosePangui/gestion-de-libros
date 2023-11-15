package com.registro.libreria.controller;

import com.registro.libreria.model.Categoria;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistarCategoriaServlet", value = "/registrarCategoria")
public class RegistrarCategoriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCategoria=request.getParameter("nombre");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/categoria.jsp");

        if(!nombreCategoria.isEmpty()){
            Categoria categoria=new Categoria(0,nombreCategoria);
            if(categoria.registrarCategoria()){
                request.setAttribute("status","Se ha registrado correctamente");
            }else{
                request.setAttribute("status","Ha ocurrido un error");
            }
        }else{
            request.setAttribute("status","Rellene el campo requerido");
        }
        requestDispatcher.forward(request,response);
    }
}
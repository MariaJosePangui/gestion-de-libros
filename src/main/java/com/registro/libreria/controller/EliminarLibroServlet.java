package com.registro.libreria.controller;

import com.registro.libreria.model.Libro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EliminarLibroServelt", value = "/eliminarLibro")
public class EliminarLibroServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        int idLibro= Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("buscarLibro");
        Libro libro=new Libro(idLibro,"","","");
        if(libro.eliminarLibro()){
            request.setAttribute("status","Se ha eliminado correctamente el libro");
        }else{
            request.setAttribute("status","No se pudo realizar la accion");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
<%--
  Created by IntelliJ IDEA.
  User: cotep
  Date: 08-11-2023
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registro Libro</title>
    <link rel="stylesheet" type="text/css" href="stylecrearlibro.css">
</head>
<body>
<main>
    <article>
        <section class="formulario">
            <%
                String mensaje = (String) request.getAttribute("status");
                if (mensaje != null && !mensaje.isEmpty()) {
            %>
            <h2><%= mensaje %></h2>
            <%
                }
            %>
            <form action="crearLibro" method="post">
                <h1>Registrar libro</h1>
                <input placeholder="Nombre del libro" name="titulo" type="text">
                <select name="categoria">
                    <option value="0">Categoria</option>
                    <c:forEach items="${categorias}" var="categoria">
                        <option value="${categoria.getId()}">${categoria.getNombreCategoria()}</option>
                    </c:forEach>
                </select>
                <input type="date" name="fecha">
                <button type="submit">Registrar libro</button>
            </form>
            <a href="index.jsp">Volver</a>
        </section>
    </article>
</main>
</body>
</html>
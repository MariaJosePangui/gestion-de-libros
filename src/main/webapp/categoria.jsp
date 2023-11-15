<%--
  Created by IntelliJ IDEA.
  User: cotep
  Date: 08-11-2023
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylecategoria.css">
    <title>Agregar categoria</title>
</head>
<body>
<main>
    <article>
        <section class="formulario">
            <form action="registrarCategoria" method="post">
                <h1>Agregar categoria</h1>

                <input name="nombre" placeholder="Nombre categoria" type="text">
                <button type="submit">Agregar categoria nueva</button>
            </form>
            <%
                String mensaje = (String) request.getAttribute("status");
                if (mensaje != null && !mensaje.isEmpty()) {
            %>
            <h2><%= mensaje %></h2>
            <%
                }
            %>
            <a href="index.jsp">Volver</a>
        </section>
    </article>
</main>
</body>
</html>
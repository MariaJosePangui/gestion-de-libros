<%--
  Created by IntelliJ IDEA.
  User: cotep
  Date: 08-11-2023
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="stylebuscarlibro.css">
  <title>Buscar libro</title>
</head>
<body>
<main>
  <section>
    <article class="b-form">
      <form action="" method="post">
        <input placeholder="Titulo del libro" name="titulo" type="text">
        <select name="categoria">
          <option value="0">Categoria</option>
          <c:forEach items="${categorias}" var="categoria">
            <option value="${categoria.getId()}">${categoria.getNombreCategoria()}</option>
          </c:forEach>
        </select>
        <button type="submit">Buscar</button>
      </form>
      <a href="index.jsp">Volver</a>
    </article>
  </section>
  <%
    String mensaje = (String) request.getAttribute("status");
    if (mensaje != null && !mensaje.isEmpty()) {
  %>
  <h2><%= mensaje %></h2>
  <%
    }
  %>
  <section class="r-busqueda">
    <table>
      <tr>
        <th>ID</th>
        <th>Titulo libro</th>
        <th>Categoria</th>
        <th>Fecha de publicacion</th>
        <th>Eliminar</th>
      </tr>
      <c:forEach items="${libros}" var="libro">
        <tr>
          <td><c:out value="${libro.getId()}"></c:out></td>
          <td><c:out value="${libro.getNombre()}"></c:out> </td>
          <td><c:forEach items="${categorias}" var="categoria">
            <c:choose>
            <c:when test="${libro.categoria eq categoria.id}">
              <c:out value="${categoria.nombreCategoria}" />
            </c:when>
            </c:choose>
            </c:forEach>
          <td><c:out value="${libro.getDate()}"></c:out> </td>
          <td>
            <a href="eliminarLibro?id=${libro.getId()}">Eliminar</a></td>
        </tr>
      </c:forEach>
    </table>
  </section>

</main>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: djcll
  Date: 2/06/2023
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Cancion> listaCancionesPorBanda = (ArrayList<Cancion>) request.getAttribute("listaCancionesPorBanda"); %>


<html>

    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="cancionesPorBanda"/>
    </jsp:include>
    <body>
    <div class='container'>
        <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
        <jsp:include page="/includes/navbar.jsp">
            <jsp:param name="page" value="canciones"/>
        </jsp:include>
        <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
            <th class="col-lg-6">
            <td><h1 class='text-light'>Lista de Canciones por banda</h1></td>
            <td><button onClick=window.location.href="/LAB6_SW1_BASE_war_exploded/listaCanciones" type="submit" class="btn btn-primary" style="background-color: gold; border-color: gold; color: #131212">Mostrar todas las canciones</button></td>
            </th>
        </div>
        <div class="tabla">
            <table class="table table-dark table-transparent table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>CANCION</th>
                    <th>BANDA</th>
                </tr>
                </thead>

                <tbody>
                <% for (Cancion c : listaCancionesPorBanda) { %>
                <tr>

                    <td><%=c.getIdCancion() %>
                    </td>
                    <td><%=c.getNombre_cancion() %>
                    </td>
                    <td><%=c.getBanda() %>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>













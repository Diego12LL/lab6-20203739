<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Cancion> listaCancionesRecomen = (ArrayList<Cancion>) request.getAttribute("listaCancionesRecomen"); %>
<%--
  Created by IntelliJ IDEA.
  User: djcll
  Date: 1/06/2023
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="CancionesRecomendadas"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="canciones"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>CANCION</th>
                <th>BANDA</th>
                <th>Ver</th>
            </tr>
            </thead>

            <tbody>
            <% for (Cancion c : listaCancionesRecomen) { %>
                <tr>

                    <td><%=c.getIdCancion() %>
                    </td>
                    <td><%=c.getNombre_cancion() %>
                    </td>
                    <td><%=c.getBanda() %>
                    </td>
                    <td>stuardo.lucho@pucp.edu.pe
                    </td>
                </tr>
            <%}%>
            <!--
            <tr>
                <td>2
                </td>
                <td>Oscar Diaz
                </td>
                <td>JP
                </td>
                <td>diaz.oa@pucp.edu.pe
                </td>
            </tr>

            <tr>
                <td>3
                </td>
                <td>Mario Gustavo
                </td>
                <td>JP
                </td>
                <td>a2015@pucp.edu.pe
                </td>
            </tr>

            <tr>
                <td>4
                </td>
                <td>Rodrigo Adauto
                </td>
                <td>JP
                </td>
                <td>a20160679@pucp.edu.pe
                </td>
            </tr>
            <tr>
                <td>4
                </td>
                <td>Álvaro Burga
                </td>
                <td>JP
                </td>
                <td>a20160679@pucp.edu.pe
                </td>
            </tr>
            <tr>
                <td>4
                </td>
                <td>Josué López
                </td>
                <td>JP
                </td>
                <td>a20160679@pucp.edu.pe
                </td>
            </tr>
            <tr>
                <td>4
                </td>
                <td> Alejandro Macedo
                </td>
                <td>JP
                </td>
                <td>a20160679@pucp.edu.pe
                </td>
            </tr>
            -->
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>

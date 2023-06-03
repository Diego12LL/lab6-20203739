package Servlets;

import Beans.Cancion;
import Daos.CancionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Boolean.parseBoolean;

@WebServlet(name = "ServletCanciones",urlPatterns = {"/listaCanciones"})
public class ServletCanciones extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        CancionDao cancionDao= new CancionDao();

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        switch (action) {
            case "listar":
                request.setAttribute("listaCanciones", cancionDao.listarCanciones());
                request.getRequestDispatcher("cancionesLista.jsp").forward(request, response);
                break;
            case "actualizarEstado":
                String id=request.getParameter("id");
                request.setAttribute("cancion", cancionDao.listar(id));
                request.getRequestDispatcher("cancionesFav.jsp").forward(request, response);
                break;
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "actualizarEstado" : request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        CancionDao cancionDao = new CancionDao();
        RequestDispatcher view;

        switch (action) {

            case "actualizarEstado":
                int idcancion = Integer.parseInt(request.getParameter("idcancion"));

                cancionDao.actualizarEstado(idcancion);

                response.sendRedirect(request.getContextPath() + "/listaCanciones");
                break;
        }
    }


}


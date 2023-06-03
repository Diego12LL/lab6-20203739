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

        request.setAttribute("listaCanciones",cancionDao.listarCanciones());

        RequestDispatcher view=request.getRequestDispatcher("cancionesLista.jsp");
        view.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");

        CancionDao cancionDao =new CancionDao();
        Cancion cancion =parseCancion(request);
        cancionDao.actualizarEstado(cancion);
        response.sendRedirect(request.getContextPath() + "/ServletCanciones");
    }

    public Cancion parseCancion(HttpServletRequest request) {

        Cancion cancion = new Cancion();
        String estado = request.getParameter("estado");

        try {

            cancion.setEstado(parseBoolean(estado));

            return cancion;

        } catch (NumberFormatException e) {

        }
        return cancion;
    }

}


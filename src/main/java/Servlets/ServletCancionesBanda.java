package Servlets;

import Daos.CancionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCancionesBanda",urlPatterns = {"/listaCancionesPorBanda"})
public class ServletCancionesBanda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        CancionDao cancionDao= new CancionDao();

        request.setAttribute("listaCancionesPorBanda",cancionDao.listarCancionesPorBanda());

        RequestDispatcher view=request.getRequestDispatcher("cancionesPorBanda.jsp");
        view.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}

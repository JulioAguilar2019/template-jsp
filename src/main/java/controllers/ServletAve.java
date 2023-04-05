package controllers;

import entities.Ave;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AveClient;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAve", value = "/ServletAve")
public class ServletAve extends HttpServlet {
    AveClient aveClient = new AveClient();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action)
        {
            case "save":
                create(request, response);
                break;
            case "findOne":
                findOne(request, response);
                break;
            case "findAll":
                findAll(request, response);
            case "delete":
                delete(request, response);
                findAll(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action)
        {
            case "save":
                save(request, response);
                findAll(request, response);
                break;
            case "update":
                update(request, response);
                findAll(request, response);
                break;
            default :
                findAll(request, response);
                break;

        }
    }


    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/Create.jsp").forward(request, response);
    }


    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String kind = request.getParameter("kind");
        String plumage = request.getParameter("plumage");
        String habitat = request.getParameter("habitat");

        Ave ave = new Ave(name, kind, plumage, habitat);
        aveClient.save(ave);

    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Ave> aves = aveClient.findAll();
        request.setAttribute("aves", aves);
        request.getRequestDispatcher("views/table.jsp").forward(request, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Ave ave = aveClient.findById(Integer.parseInt(id));

        request.setAttribute("ave", ave);
        request.getRequestDispatcher("views/update.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String kind = request.getParameter("kind");
        String plumage = request.getParameter("plumage");
        String habitat = request.getParameter("habitat");
        Ave ave = new Ave(name, kind, plumage, habitat);
        ave.setId(Integer.parseInt(id));
        aveClient.update(ave);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        aveClient.delete(Integer.parseInt(id));

    }
}

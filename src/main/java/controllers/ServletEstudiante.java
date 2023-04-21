package controllers;

import entities.Curso;
import entities.Estudiante;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.CursosClient;
import services.EstudianteClient;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ServletEstudiante", value = "/ServletEstudiante")
public class ServletEstudiante extends HttpServlet {
    EstudianteClient estudianteClient = new EstudianteClient();
    CursosClient cursosClient = new CursosClient();

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
        request.setAttribute("cursos", cursosClient.findAll());
        request.getRequestDispatcher("views/Create.jsp").forward(request, response);
    }


    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String[] cursosSeleccionados = request.getParameterValues("cursos");


        Estudiante estudiante = new Estudiante(nombre, apellido);
        Set<Curso> cursos = new HashSet<>();

        CursosClient cursosClient = new CursosClient();

        if (cursosSeleccionados != null) {
            for (String cursoId : cursosSeleccionados) {
                Curso curso = cursosClient.findById(Integer.parseInt(cursoId));
                cursos.add(curso);
            }
        }
        estudiante.setCursos(cursos);
        estudianteClient.save(estudiante);


    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Estudiante> estudiantes = estudianteClient.findAll();
        request.setAttribute("estudiantes", estudiantes);
        request.getRequestDispatcher("views/table.jsp").forward(request, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Estudiante estudiante = estudianteClient.findById(Integer.parseInt(id));
        request.setAttribute("cursos", cursosClient.findAll());

        request.setAttribute("estudiante", estudiante);
        request.getRequestDispatcher("views/update.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String[] cursosSeleccionados = request.getParameterValues("cursos");

        // Recuperar el estudiante existente de la base de datos
        Estudiante estudiante = estudianteClient.findById(id);

        // Actualizar las propiedades del estudiante con los nuevos valores
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);

        // Recuperar los cursos existentes del estudiante
        Set<Curso> cursosExistentes = estudiante.getCursos();

        // Crear un conjunto de cursos nuevos
        Set<Curso> cursosNuevos = new HashSet<>();

        // Agregar los cursos seleccionados al conjunto de cursos nuevos
        if (cursosSeleccionados != null) {
            for (String cursoId : cursosSeleccionados) {
                Curso curso = cursosClient.findById(Integer.parseInt(cursoId));
                cursosNuevos.add(curso);
            }
        }

        // Actualizar el conjunto de cursos del estudiante con los cursos nuevos
        cursosExistentes.clear();
        cursosExistentes.addAll(cursosNuevos);

        // Actualizar el estudiante en la base de datos
        estudianteClient.update(estudiante);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        estudianteClient.delete(Integer.parseInt(id));

    }
}

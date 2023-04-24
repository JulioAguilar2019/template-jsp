package controllers;

import entities.ProductosEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.OrdenesClient;
import services.ProductosClient;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProductos", value = "/ServletProductos")
public class ServletProductos extends HttpServlet {
    ProductosClient productosClient = new ProductosClient();
    

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
                break;
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

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio_unitario = request.getParameter("precio_unitario");
        String categoria = request.getParameter("categoria");
        
        double precio_unitarioParsed = Double.parseDouble(precio_unitario);

    
        ProductosEntity productos = new ProductosEntity( nombre, descripcion, precio_unitarioParsed, categoria);
      
        productosClient.save(productos);


    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<ProductosEntity> productos = productosClient.findAll();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("views/table.jsp").forward(request, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        ProductosEntity producto = productosClient.findById(Integer.parseInt(id));

        request.setAttribute("producto", producto);
        request.getRequestDispatcher("views/update.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio_unitario = request.getParameter("precio_unitario");
        String categoria = request.getParameter("categoria");

        double precio_unitarioParsed = Double.parseDouble(precio_unitario);

        ProductosEntity productos = productosClient.findById(id);
        productos.setNombre(nombre);
        productos.setDescripcion(descripcion);
        productos.setPrecioUnitario(precio_unitarioParsed);
        productos.setCategoria(categoria);

        productosClient.update(productos);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        productosClient.delete(Integer.parseInt(id));

    }
}

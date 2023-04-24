package controllers;

import entities.OrdenesEntity;
import entities.ProductosEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.OrdenesClient;
import services.ProductosClient;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ServletOrdenes", value = "/ServletOrdenes")
public class ServletOrdenes extends HttpServlet {
    OrdenesClient ordenesClient = new OrdenesClient();
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
        List<ProductosEntity> productos = productosClient.findAll();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("views/Createorden.jsp").forward(request, response);
    }


    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String idProducto = request.getParameter("IdProducto");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");
        String direccion = request.getParameter("direccion");

        Date fechaParsed = Date.valueOf(fecha);
        int cantidadParsed = Integer.parseInt(cantidad);

        ProductosEntity producto = productosClient.findById(Integer.parseInt(idProducto));

    
        OrdenesEntity ordenes = new OrdenesEntity( producto, cantidadParsed, fechaParsed, direccion);
      
        ordenesClient.save(ordenes);


    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<OrdenesEntity> ordenes = ordenesClient.findAll();
        request.setAttribute("ordenes", ordenes);
        request.getRequestDispatcher("views/tableorden.jsp").forward(request, response);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        OrdenesEntity ordenes = ordenesClient.findById(Integer.parseInt(id));
        request.setAttribute("orden", ordenes);

        List<ProductosEntity> productos = productosClient.findAll();
        request.setAttribute("productos", productos);

        request.getRequestDispatcher("views/updateorden.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String idProducto = request.getParameter("id_producto");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");
        String direccion = request.getParameter("direccion");

        Date fechaParsed = Date.valueOf(fecha);
        int cantidadParsed = Integer.parseInt(cantidad);

        ProductosEntity producto = productosClient.findById(Integer.parseInt(idProducto));

        OrdenesEntity ordenes = ordenesClient.findById(id);
        ordenes.setCantidad(cantidadParsed);
        ordenes.setFechaOrden(fechaParsed);
        ordenes.setDireccionEntrega(direccion);
        ordenes.setProducto(producto);


        ordenesClient.update(ordenes);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        ordenesClient.delete(Integer.parseInt(id));

    }
}

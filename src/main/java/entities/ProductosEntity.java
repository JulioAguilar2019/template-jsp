package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "productos", schema = "laboratorio2")
public class ProductosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int id_producto;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio_unitario")
    private double precio_unitario;
    @Basic
    @Column(name = "categoria")
    private String categoria;

    public ProductosEntity() {
    }

    public ProductosEntity(String nombre, String descripcion, double precio_unitario, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}

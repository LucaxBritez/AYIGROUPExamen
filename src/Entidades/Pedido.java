package Entidades;

import java.util.List;

public class Pedido {

    int numeroDeOrden;
    Usuario usuario;
    List<Producto> productos;
    Estado estado;
    TipoPedido tipo;


    public Pedido(int numeroDeOrden, Usuario usuario, List<Producto> productos, Estado estado, TipoPedido tipo) {
        this.numeroDeOrden = numeroDeOrden;
        this.usuario = usuario;
        this.productos = productos;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Pedido() {
    }

    public int getNumeroDeOrden() {
        return numeroDeOrden;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Estado getEstado() {
        return estado;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setNumeroDeOrden(int numeroDeOrden) {
        this.numeroDeOrden = numeroDeOrden;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }


    public void imprimirPedido(Pedido pedido) {
        System.out.println("Numero de orden: " + getNumeroDeOrden());
        System.out.println("Pedidos: ");
        for (Producto producto : pedido.productos) {
            System.out.println("Nombre producto: " + producto.getNombreProducto());
            System.out.println("Precio producto: " + producto.getPrecioProducto());
            System.out.println("Cantidad producto: " + producto.getCantidadProducto());
        }
        System.out.println("Estado del pedido: " + pedido.estado);
        System.out.println("Tipo de pedido: " + pedido.tipo);
    }

}

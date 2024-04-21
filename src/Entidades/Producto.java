package Entidades;

public class Producto {

    String nombreProducto;
    double precioProducto;
    int unidades;
    int cantidadProducto;

    public Producto(String nombreProducto, double precioProducto, int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public Producto() {
    }



    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }


    public void imprimirProducto(String numero,Producto producto) {
        System.out.println(numero + "| " + "Nombre:" + producto.nombreProducto + " | " +"Precio:" + producto.precioProducto + " | " + "Cantidad:" + producto.cantidadProducto + " |");
    }

    public void sumarProductos(Producto producto){

    }
}

import Entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Pedidos de golosinas:

Un cliente solicita armar una aplicación en la cual existen usuarios que pueden realizar pedidos para proveer
su negocio de golosinas. Para realizar un pedido se debe respetar algunos flujos de aprobación.

Cada pedido tiene los siguientes estados: Borrador, Pend. Aprobación y
Aprobado/Rechazado. Para los pedidos, existen determinadas restricciones, el usuario puede iniciar un
pedido, siendo su primer estado, el “Borrador”, luego al ingresar los datos necesarios pueden enviar a
Aprobar la solicitud, quedando en “Pend. Aprobación”. Ese pedido le llega a otro usuario, un responsable,
y puede aprobarlo o no. Los pedidos pueden ser mayoristas o minoristas.

    •	Crear aplicación Java
    •	Presentar diferentes diagramas para representar la solución
        o	Diagrama de clases
        o	Diagrama representando el proceso de cambio de estado.
    •	Crear un método en el cual se compruebe la restricción de flujo del pedido.

Ejemplo:
Un pedido en estado “Borrador” no puede pasar a un estado Aprobado”. Y ninguno de los estados,
puede volver a un estado anterior.

* */
public class Main {
    public static void main(String[] args) {
        //Creo el scanner que usare como input durante toda la ejecucion del codigo
        Scanner scanner = new Scanner(System.in);

        //region Creacion de la lista de productos
        //Hardcodeo de tres productos a modo de ejemplo
        Producto producto1 = new Producto("Sapito", 190, 1);
        Producto producto2 = new Producto("Conitos de dulce de leche Cachafaz", 1200, 1);
        Producto producto3 = new Producto("Alfajor Guaymallen", 200, 1);
        //endregion


        //region Creacion del usuario Responsable
        //Hardcodeo los datos de usuario responsable/administrador
        Usuario usuarioResponsable = new Usuario(42136997, "Luca", "Britez", RolUsuario.RESPONSABLE);
        //endregion

        //region Instancio Usuario
        //Instancio al futuro usuario, aun no se le asignan sus atributos, primero se debe determinar su rol.
        Usuario usuario = new Usuario();
        //endregion

        //region Solicito DNI.
        System.out.println("Por favor ingrese su DNI: ");
        usuario.setDni(Integer.parseInt(scanner.nextLine()));
        //endregion

        //region Si el dni del usuario ingresado es el dni del usuario responsable, si lo es ingresa como Responsable, sino como cliente

        /*Condicional encargado de determinar el rol del usuario*/
        if (usuario.getDni() == usuarioResponsable.getDni()) {
            //Asigno los datos del usuarioResponsable al usuario que esta ingresando.
            usuario.setNombre(usuarioResponsable.getNombre());
            usuario.setApellido(usuarioResponsable.getApellido());
            usuario.setRol(usuarioResponsable.getRol());

            System.out.println("¡Bienvenido " + usuario.getNombre() + "!");

            //Comienza la ejecucion de las aprobaciones de los pedidos(Considerar usar un excel para tener pedidos que validar)
        } else {


            /*Como no estamos trabajando con una base de datos que pueda validar si el cliente existe o no, asumimos
              que es un cliente por la misma razon y le pedimos los datos como si fuese un cliente nuevo para asignarlos
              al objeto usuario previamente creado.*/


            //region Creacion del usuario cliente

            /*El atributo dni de usuario fue asignado al inicio con la solicitud de este dato.*/
            System.out.println("¡Bienvenido nuevo cliente!");

            System.out.println("Por favor ingrese su nombre: ");
            usuario.setNombre(scanner.nextLine());
            //Podria agregarse una confirmacion aca
            System.out.println("Por favor ingrese su apellido: ");
            usuario.setApellido(scanner.nextLine());
            //Podria agregarse una confirmacion aca

            //Se asigna el rol del usuario
            usuario.setRol(RolUsuario.CLIENTE);
            //endregion

            //region Comienza la creacion del pedido

            /*List que almacena temporalmente los productos seleccionados*/
            List<Producto> productosSeleccionados = new ArrayList<>();

            /*Se instancia el objeto pedido*/
            Pedido pedido = new Pedido();

            //region Seleccion de tipo de pedido
            int opcionTipoDePedido;
            System.out.println("Tipo de pedido: ");
            System.out.println("1-Mayorista");
            System.out.println("2-Minorista");
            opcionTipoDePedido = scanner.nextInt();

            if (opcionTipoDePedido == 1){
                pedido.setTipo(TipoPedido.MAYORISTA);
            }else if(opcionTipoDePedido == 2){
                pedido.setTipo(TipoPedido.MINORISTA);
            }
            //Tal vez deberia haber un else final que haga que la pregunta se ejecute nuevamente si la respuesta no esta contemplada
            //endregion

            //region Seccion donde se muestra la lista de productos
            System.out.println("---------------------------------");
            System.out.println("-Lista de productos disponibles-");
            System.out.println("---------------------------------");
            producto1.imprimirProducto("1-", producto1);

            producto2.imprimirProducto("2-", producto2);

            producto3.imprimirProducto("3-", producto3);
            System.out.println("---------------------------------");
            //endregion


            char deseaAgregar;

            //Bucle Do While para ejecutar la seleccion de productos para el pedido
            do {
                System.out.print("\nIngrese el número del producto que desea agregar al pedido (1-3): ");
                int opcion = scanner.nextInt();

                // Agregar el producto seleccionado a la lista de productos seleccionados
                switch (opcion) {
                    case 1:
                        productosSeleccionados.add(producto1);
                        break;
                    case 2:
                        productosSeleccionados.add(producto2);
                        break;
                    case 3:
                        productosSeleccionados.add(producto3);
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        break;
                }

                // Preguntar al usuario si desea agregar otro producto
                System.out.print("¿Desea agregar otro producto? (s/n): ");
                deseaAgregar = scanner.next().charAt(0);
                /*Al pedido se le agregaron elementos, pero al no estar terminado ni confirmado se le asigna el estado
                    borrador*/
                pedido.setEstado(Estado.BORRADOR);
                scanner.nextLine(); // Limpiar el buffer de entrada

            } while (deseaAgregar == 's' || deseaAgregar == 'S');


            /*El pedido fue confirmado, por lo tanto quedara al pendiente de un responable para su aprobacion o rechazo*/
            pedido.setEstado(Estado.PENDIENTE);
            System.out.println("Su pedido esta en estado " + pedido.getEstado());

            //El numero de orden esta hardcodeado
            pedido.setNumeroDeOrden(1);
            pedido.setUsuario(usuario);
            pedido.setProductos(productosSeleccionados);

            /*Para este punto se asignaron todos los atributos necesarios para un pedido y su estado es Pendiente*/

            pedido.imprimirPedido(pedido);
            //endregion


        }
        //endregion
    }
}
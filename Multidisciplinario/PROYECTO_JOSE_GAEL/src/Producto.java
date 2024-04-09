import java.util.Scanner;
public class Producto {
    private String nombre;
    private int cantidad;
    
    Scanner scanner= new Scanner(System.in);
    
    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void actualizarCantidad(Inventario inventario){
       System.out.println("Ingrese el nombre del producto que desea actualizar: ");
       String nombreProducto=scanner.nextLine();
       System.out.println("Ingresa la nueva cantidad: ");
       int nuevaCantidad= Usuario.leerEntero();
       scanner.nextLine();
       inventario.modificarCantidad(nombreProducto, nuevaCantidad);
       System.out.println("Cantidad actualizada.");
    }

    public void verificarDisponibilidad(Inventario inventario, int cantidad, String nombreProducto){
        for (Producto producto : inventario.getProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (producto.getCantidad() >= cantidad) {
                    System.out.println("Hay suficientes " + producto.getNombre() + " en el inventario.");
                    setCantidad(2);
                } else {
                    System.out.println("No hay suficientes " + producto.getNombre() + " en el inventario.");
                    setCantidad(1);
                }
                return;
            }
        }
        System.out.println("Producto '" + nombreProducto + "' no encontrado en el inventario.");
    }
}


        



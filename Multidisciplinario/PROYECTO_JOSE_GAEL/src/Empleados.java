import java.util.Scanner;
public class Empleados {
    private static Scanner scanner = new Scanner(System.in);    
    Cliente cliente= new Cliente(null, null, null, null);
    private Renta renta= new Renta(null, null, null, 0);
    private Apartado apartado= new Apartado(null);
    private Inventario inventario = new Inventario(); // Instancia de Inventario a nivel de clase
    private  Producto producto = new Producto("", 0); // Instancia genérica de Producto
    private GestorApartados gestorApartado = new GestorApartados(inventario, apartado, cliente, producto);
    private GestorRentas gestorRenta = new GestorRentas(inventario, renta, cliente, producto);
    Reportes report = new Reportes(0,0);

    public void verMenuEmpleado(){
        int em =0 ;
        em++;
        report.setReporteEmpleado(em);
        int opcion;
        System.out.println("Desea ver el menu? \t 1.Si \t 2.No, Cerrar sesion");
            int option= Usuario.leerEntero();
            switch (option) {
                case 1:
                    
            do {
                
        System.out.println("El siguiente menu es del Empleado: \n Eliga una Opcion; ");
            System.out.println("1.Consultar inventario  \n 2.Levantar pedido \n" + //
                            "3.Modificar Renta \n 4.Consultar Cliente  \n" + //
                            "5.Modificar Apartado \n 6.Seguimiento de Renta/Apartado \n 7.Reportes del dia \n 8.Cerrar Sesion");
            opcion= Usuario.leerEntero();
    
            switch (opcion) {
                case 1:
                       
                       inventario.consultarInventario();
                    break;
                case 2:
                cliente.registrarCliente();
                System.out.println(" Desea realizar 1.Renta o 2.apartado?");
                int options = Usuario.leerEntero();
                while (options != 1 && options != 2) {
                    System.out.println(" Opcion invalida, por favor seleccione una opcion correcta, 1.Renta o 2.apartado ");
                    options= Usuario.leerEntero();
                }
                switch (options) {
                   case 1:
                   gestorRenta.crearRenta();
                       break;
                   case 2:
                   gestorApartado.crearApartado();
                        break;
                   default:
                   System.out.println(" ERROR");
                       break;
                }
                break;
                case 3:
                      
                     gestorRenta.modificarRenta();
                break;
                case 4:
                System.out.print("Ingrese el ID del cliente a consultar: ");
                int idConsulta = Usuario.leerEntero();
                cliente.consultarCliente(idConsulta, gestorRenta, gestorApartado);
    
                break;
                case 5:
                        gestorApartado.modificarApartado();
                break;
                case 6:
                System.out.println("\n 1.- Seguimineto de Rentas \n 2.- Seguimiento de Apartado");
                int opcionSeguimiento = Usuario.leerEntero();
                if(opcionSeguimiento > 2 || opcionSeguimiento < 1){
                    System.out.println("Opcion No Valida");
                }
                if(opcionSeguimiento == 1){
                   gestorRenta.seguimientoRentas(); 
                }
                if(opcionSeguimiento == 2){
                    gestorApartado.seguimientoApartados();
                }
                
            
                break;
                case 7:
                      report.reportesDelDia();
                      
                break;
                case 8:
                      
                break;
               
                default:
                
                    break;
          }
        } while (opcion != 8);
    
           
        break;
           
        default:
              
            break;
    }
       }
}

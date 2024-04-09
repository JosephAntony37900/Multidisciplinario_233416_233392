//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class GestorRentas {
// tuve una idea pero me estrese, asi te lo dejo, el inventario es de ayuda para actualizar las cosas como, si se rentaa 5 sillas, se restan de inventario, checa como hacerlo, tuve una idea pero ne
    private Inventario inventario;
    //recordar usar renta y cliente
    private Renta renta;
    private Cliente cliente;
    private Producto producto;
    Scanner sc= new Scanner(System.in);
    public Map<Integer,Renta> rentas = new HashMap<>();


    
    public GestorRentas(Inventario inventario, Renta renta, Cliente cliente, Producto producto) {
        this.inventario = inventario;
        this.renta= renta;
        this.cliente=cliente;
        this.producto=producto;
    }
 
    public Map<Integer,Renta> getRentas(){
        return rentas;
    }


    public void crearRenta(){

        System.out.println("Ingresa la cantidad de sillas a rentar[$31]: ");
        int cantidadSillas = Usuario.leerEntero();
   
        while (cantidadSillas < 0) {
            System.out.println(" La cantidad de sillas no puede ser negativa, por favor ingrese nuevamente la cantidad de sillas[$31]: ");
            cantidadSillas=Usuario.leerEntero();
        }
        //disponibilidad
        producto.verificarDisponibilidad(inventario, cantidadSillas, "Sillas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadSillas= Usuario.leerEntero();
        }
        int sillasPrecioTotal = (cantidadSillas*31);
        System.out.println("Ingresa la cantidad de mesas a rentar[$200]: ");
        int cantidadMesas = Usuario.leerEntero();
        while (cantidadMesas < 0) {
            System.out.println(" La cantidad de mesas no puede ser negativa, por favor ingrese nuevamente la cantidad de mesas[$200]: ");
            cantidadMesas= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadMesas, "Mesas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadMesas= Usuario.leerEntero();
        }
        int mesasPrecioTotal = (cantidadMesas*200);
        System.out.println("Ingresa la cantidad de carpas a rentar[$1200]: ");
        int cantidadCarpas = Usuario.leerEntero();
        while (cantidadCarpas < 0) {
            System.out.println(" La cantidad de carpas no puede ser negativa, por favor ingrese nuevamente la cantidad de carpas[$1200]: ");
            cantidadCarpas= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadCarpas, "Carpas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadCarpas= Usuario.leerEntero();
        }
        int carpasPrecioTotal = (cantidadCarpas*1200);
        System.out.println("Ingresa la cantidad de manteles a rentar[$11]: ");
        int cantidadManteles = Usuario.leerEntero();
        while (cantidadManteles < 0) {
            System.out.println(" La cantidad de manteles no pueder ser negativa, por favor ingrese nuevamente la cantidad de manteles[$11]: ");
            cantidadManteles= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadManteles, "Manteles");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadManteles= Usuario.leerEntero();
        }
        int mantelesPrecioTotal = (cantidadManteles*11);
        System.out.println("Ingresa la fecha de entrega de la renta (YYYY-MM-DD): ");
        String fechaEntrega = sc.next();
        double costoTotalCliente = (sillasPrecioTotal+mesasPrecioTotal+mantelesPrecioTotal+carpasPrecioTotal);
    // 777
        Renta nuevaRenta = new Renta(cantidadSillas, cantidadMesas, cantidadCarpas, cantidadManteles, fechaEntrega, costoTotalCliente);

        inventario.restarCantidad("Carpas", nuevaRenta.getCantidadCarpas());
        inventario.restarCantidad("Sillas", nuevaRenta.getCantidadSillas());
        inventario.restarCantidad("Mesas", nuevaRenta.getCantidadMesas());
        inventario.restarCantidad("Manteles", nuevaRenta.getCantidadManteles()); 
        //rentas.add(nuevaRenta); 
        //logica de dioses, se puede quitar el "Private Renta renta" luego vere bien si no servira para algo, 777
        int id= cliente.getIdCliente();
        rentas.put(id,nuevaRenta);
        renta.setIdRenta(id);
     
        System.out.println("La renta fue aguardada con el id: " + renta.getIdRenta());
        System.out.println("Costo Total "+costoTotalCliente + "$");
    }
    
    public void modificarRenta(){
        System.out.print("Ingrese ID de la renta para modificar: ");
        int idRentaMod = Usuario.leerEntero();
        while (idRentaMod <= 0) {
            System.out.println("El ID no puede ser negativo, por favor ingreselo nuevamnete: ");
            idRentaMod= Usuario.leerEntero();
        }
        if(rentas.containsKey(idRentaMod)){
        Renta rentaMod = rentas.get(idRentaMod);
        

        System.out.println("1.- Agregar 2.- Restar");
        int optModRenta = Usuario.leerEntero();
        if(optModRenta == 1){
        
        System.out.println("Cuantas Desea Agregar?");
        int cantidadACambiar = Usuario.leerEntero();
        while (cantidadACambiar<= 0) {
            System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
            cantidadACambiar= Usuario.leerEntero();
        }
        
        System.out.println("Aplicarlo a: \n 1.- Sillas \n 2.- Mesas \n 3.-Manteles \n 4.-Carpas ");
                    int elementoACambiar = Usuario.leerEntero();
                    switch (elementoACambiar) {
                        case 1:

                        if(cantidadACambiar > inventario.productos.get(0).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadSillas(cantidadACambiar + rentaMod.getCantidadSillas());
                            inventario.restarCantidad("Sillas", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*31)+rentaMod.getCostoTotalCliente());
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }
                        case 2:
                        if(cantidadACambiar > inventario.productos.get(1).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadMesas(cantidadACambiar + rentaMod.getCantidadMesas());
                            inventario.restarCantidad("Mesas", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*200)+rentaMod.getCostoTotalCliente());
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }

                           
                        case 3:

                        if(cantidadACambiar > inventario.productos.get(2).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadManteles(cantidadACambiar + rentaMod.getCantidadManteles());
                            inventario.restarCantidad("Manteles", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*11)+rentaMod.getCostoTotalCliente());
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }

                        case 4:
                        if(cantidadACambiar > inventario.productos.get(3).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadCarpas(cantidadACambiar + rentaMod.getCantidadCarpas());
                            inventario.restarCantidad("Carpas", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*1200)+rentaMod.getCostoTotalCliente());
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }
                        default:
                            break;
                    }
                

            }

            if(optModRenta == 2){

                System.out.println("Cuantas Desea Restar?");
                int cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }
            
                        
                System.out.println("Aplicarlo a: \n 1.- Sillas \n 2.- Mesas \n 3.-Manteles \n 4.-Carpas ");
                            int elementoACambiar = sc.nextInt();
                            switch (elementoACambiar) {
                                case 1:
        
                                if(cantidadACambiar > inventario.productos.get(0).getCantidad() || cantidadACambiar < 0){
                                    System.out.println("Incapaz de Modificar");
                                    break;
                                    
                                }
                                else{
                                    rentaMod.setCantidadSillas(rentaMod.getCantidadSillas() - cantidadACambiar);
                                    inventario.sumarCantidad("Sillas", cantidadACambiar);
                                    rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*31));
                                    //al momento de modificar renta tambien cambia la cantidad a pagar              
                                    break;
                                }
                                case 2:
                                if(cantidadACambiar > inventario.productos.get(1).getCantidad() || cantidadACambiar < 0){
                                    System.out.println("Incapaz de Modificar");
                                    break;
                                    
                                }
                                else{
                                    rentaMod.setCantidadMesas(rentaMod.getCantidadMesas() - cantidadACambiar);
                                    inventario.sumarCantidad("Mesas", cantidadACambiar);
                                    rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*200));
                                    //al momento de modificar renta tambien cambia la cantidad a pagar              
                                    break;
                                }
        
                                   
                                case 3:
        
                                if(cantidadACambiar > inventario.productos.get(2).getCantidad() || cantidadACambiar < 0){
                                    System.out.println("Incapaz de Modificar");
                                    break;
                                    
                                }
                                else{
                                    rentaMod.setCantidadManteles(rentaMod.getCantidadManteles() - cantidadACambiar);
                                    inventario.sumarCantidad("Manteles", cantidadACambiar);
                                    rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*11));
                                    //al momento de modificar renta tambien cambia la cantidad a pagar              
                                    break;
                                }
        
                                case 4:
                                if(cantidadACambiar > inventario.productos.get(3).getCantidad() || cantidadACambiar < 0){
                                    System.out.println("Incapaz de Modificar");
                                    break;
                                    
                                }
                                else{
                                    rentaMod.setCantidadCarpas(rentaMod.getCantidadCarpas() - cantidadACambiar);
                                    inventario.sumarCantidad("Carpas", cantidadACambiar);
                                    rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente() -(cantidadACambiar*1200));
                                    //al momento de modificar renta tambien cambia la cantidad a pagar              
                                    break;
                                }
                                default:
                                    break;
                            }
//porfa checale una revisada a restar y agregar ATTE: Gael Andre Developer Fuckin Genius
            }
        }
        else{
            System.out.println("[NO HUBO RESULTADOS]");
        }
    }

    public void cancelarRenta(int idRentaEliminar) {
        
        boolean encontrado = false;
        if (rentas.containsKey(idRentaEliminar)) {
            Renta rentaEliminada = rentas.get(idRentaEliminar);
                // Actualizar el inventario sumando la cantidad de productos de la renta eliminada
                
                inventario.sumarCantidad("Carpas", rentaEliminada.getCantidadCarpas());
                inventario.sumarCantidad("Sillas", rentaEliminada.getCantidadSillas());
                inventario.sumarCantidad("Mesas", rentaEliminada.getCantidadMesas());
                inventario.sumarCantidad("Manteles", rentaEliminada.getCantidadManteles());
                encontrado = true;
                System.out.println("Renta cancelada con éxito .");
                String fechaEntrega= " Entregado ";
                int cantidadSillas=0;
                int cantidadMesas=0;
                int cantidadCarpas=0;
                int cantidadManteles=0;
                int costoTotalCliente=0;
                Renta nuevaRenta = new Renta(cantidadSillas, cantidadMesas, cantidadCarpas, cantidadManteles, fechaEntrega, costoTotalCliente);
                rentas.put(idRentaEliminar, nuevaRenta);
            }
            if (!encontrado) {
                System.out.println("No se encontró la renta con el ID " + idRentaEliminar);
            }
        }
        
     

    public void seguimientoRentas(){
        for (Integer idRenta: rentas.keySet()) {
            Renta renta = rentas.get(idRenta);
            System.out.println("Id de la Renta " + (idRenta) + ":"); 
            System.out.println("  Sillas: " + renta.getCantidadSillas());
            System.out.println("  Mesas: " + renta.getCantidadMesas());
            System.out.println("  Carpas: " + renta.getCantidadCarpas());
            System.out.println("  Manteles: " + renta.getCantidadManteles());
            System.out.println("  Fecha de entrega o ya entregado: " + renta.getFechaDeEntrega());
            System.out.println("  Costo Total De La Renta: "+renta.getCostoTotalCliente() + "$");
            
        }
    }


}



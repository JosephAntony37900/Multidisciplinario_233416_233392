abstract class Servicios {
    
    protected String fechaDeEntrega;


    public Servicios(String fechaDeEntrega){
      this.fechaDeEntrega=fechaDeEntrega;
    }


   
    public void mostrarDatos(Cliente clientes) {
      
      System.out.println("Total de clientes que han levantado pedidos: " +clientes.getClientes());
    
  }
  
}

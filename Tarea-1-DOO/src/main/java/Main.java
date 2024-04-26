public class Main {
    public static void main(String[] args) {
        // NoHayProductoException

        try {
            Expendedor exp = new Expendedor(7);
            Moneda m = new Moneda1500();
            Comprador c = new Comprador(m, 5, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // PagoIncorrectoException

        try {
            Expendedor exp = new Expendedor(7);
            Comprador c = new Comprador(null,4,exp);
            System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // PagoInsuficienteException

        try {
            Expendedor exp = new Expendedor(7);
            Moneda m = new Moneda100();
            Comprador c = new Comprador(m,3,exp);
            System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Moneda m = new Moneda1000();
        Expendedor exp = new Expendedor(5);
        try
        {
            Comprador com = new Comprador(m, 4, exp);
            System.out.println(com.queConsumiste());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException err){
            System.out.println("Error: " + err.getMessage());
        }
    }
}
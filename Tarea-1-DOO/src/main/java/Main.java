import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // NoHayProductoException
        try {
            Expendedor exp = new Expendedor(7);
            Moneda m = new Moneda500();
            Comprador c = new Comprador(m, 77, exp);
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

    }
}
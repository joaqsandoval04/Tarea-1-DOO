import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // NoHayProductoException
        try {
            Expendedor exp = new Expendedor(7, 200);
            Moneda m = new Moneda500();
            Comprador c = new Comprador(m, 662, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // PagoIncorrectoException
        try {
            Expendedor exp = new Expendedor(7,200);
            Comprador c = new Comprador(null,1,exp);
            System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // PagoInsuficienteException
        try {
            Expendedor exp = new Expendedor(7,200);
            Moneda m = new Moneda100();
            Comprador c = new Comprador(m,1,exp);
            System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
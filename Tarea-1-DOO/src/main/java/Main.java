import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Moneda m = new Moneda1000();
        Expendedor exp = new Expendedor(5, 500);
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
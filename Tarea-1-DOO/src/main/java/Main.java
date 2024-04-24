import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Objetos testeo
        Expendedor exp = new Expendedor(10, 500);
        Moneda m = new Moneda1000();
        Comprador comp = new Comprador(m, 1, exp);  // Ingresar en cualProducto cual producto quieres(ver updates.txt)
        //

        System.out.println(comp.queConsumiste());


    }
}
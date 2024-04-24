import java.util.ArrayList;

class Deposito{
    private ArrayList<Producto> lista;
    private ArrayList<Moneda> monedas;

    public Deposito(){
        lista = new ArrayList<>();
        monedas = new ArrayList<>();
    }

    public void addProducto(Producto p){
        lista.add(p);
    }

    public void addMoneda(Moneda moneda) {
        monedas.add(moneda);
    }

    public Moneda getMoneda() {
        if (monedas.isEmpty())
            return null;
        return monedas.remove(0);
    }

    public Producto getProducto(){
        if (lista.size() != 0){
            Producto p = lista.remove(0);
            return p;
        }else {
            return null;
        }
    }
}
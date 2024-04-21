import java.util.ArrayList;

class Deposito{
    private ArrayList<Bebida> lista;
    private ArrayList<Moneda> monedas;

    public Deposito(){
        lista = new ArrayList<>();
        monedas = new ArrayList<>();
    }

    public void addBebida(Bebida b){
        lista.add(b);
    }

    public void addMoneda(Moneda moneda) {
        monedas.add(moneda);
    }

    public Moneda getMoneda() {
        if (monedas.isEmpty())
            return null;
        return monedas.remove(0);
    }

    public Bebida getBebida(){
        if (lista.size() != 0){
            Bebida b = lista.remove(0);
            return b;
        }else {
            return null;
        }
    }
}
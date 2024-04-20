import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }
}

abstract class Moneda{
    public Moneda(){

    }

    public Moneda getSerie(){
        return this;
    }

    public abstract int getValor();
}

class Moneda1500 extends Moneda{
    public Moneda1500(){
        super();
    }

    public int getValor(){
        return 1500;
    }

}

class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }

    public int getValor(){
        return 1000;
    }

}

class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }

    public int getValor(){
        return 500;
    }

}

class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }

    public int getValor(){
        return 100;
    }

}


abstract class Bebida{
    private int serie;

    public Bebida(int numSerie){
        serie = numSerie;
    }

    public int getSerie(){
        return serie;
    }

    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int s){
        super(s);
    }

    public String beber(){
        return "sprite";
    }

}

class CocaCola extends Bebida{
    public CocaCola(int s){
        super(s);
    }

    public String beber(){
        return "cocacola";
    }

}


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

class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito monVu;
    public static final int COCA=1;
    public static final int SPRITE=2;

    public int precio;

    public Expendedor(int numBebidas, int precioBebidas){
        coca = new Deposito();
        monVu = new Deposito();
        for (int i = 0; i < numBebidas; i++){
            Bebida b = new CocaCola(100+i);
            coca.addBebida(b);
        }

        sprite = new Deposito();
        for (int i = 0; i < numBebidas; i++){
            Bebida b = new Sprite(200+i);
            sprite.addBebida(b);
        }

        precio = precioBebidas;
    }

    public Bebida comprarBebida(Moneda m, int type) {
        Bebida b;
        int vuelto;

        if (m == null)
        {
            return null;
        }

        if (m.getValor() >= precio) {
            if (type == COCA) {
                b = coca.getBebida();
            } else if (type == SPRITE){
                b = sprite.getBebida();
            }else
            {
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addMoneda(new Moneda100());
                    vuelto -= 100;
                }
                return null;
            }

            if (b != null) {

                vuelto = m.getValor() - precio;
                while (vuelto > 0) {
                    monVu.addMoneda(new Moneda100());
                    vuelto -= 100;
                }
            }else{
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addMoneda(new Moneda100());
                    vuelto -= 100;
                }
            }


            return b;
        }
        else
        {
            vuelto = m.getValor();
            while (vuelto > 0) {
                monVu.addMoneda(new Moneda100());
                vuelto -= 100;
            }
            return null;
        }
    }

    public Moneda getVuelto(){
        return monVu.getMoneda();
    }

}

class Comprador{
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){

        int total;

        Bebida BebidaComprada = exp.comprarBebida(m, cualBebida);
        Moneda monedaVuelto;
        if (BebidaComprada != null) {
            sonido = BebidaComprada.beber();
        }else {
            sonido = null;
        }


        total = 0;

        while ((monedaVuelto =exp.getVuelto()) != null) {
            total += monedaVuelto.getValor();
        }


        vuelto = total;

    }

    public int cuantoVuelto(){
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }
}

abstract class Bebida extends Producto{
    private int serie;

    public Bebida(int numSerie){
        super();
        serie = numSerie;
    }

    public int getSerie(){
        return serie;
    }

    public abstract String consumir();
}
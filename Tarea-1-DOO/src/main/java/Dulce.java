abstract class Dulce extends Producto{
    private int serie;
    public Dulce(int numSerie){
        super();
        serie = numSerie;
    }

    public int getSerie(){
        return serie;
    }

    public abstract String comer();
}
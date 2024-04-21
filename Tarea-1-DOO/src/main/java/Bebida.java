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
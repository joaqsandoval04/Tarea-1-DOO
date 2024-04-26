abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){

    }

    public Moneda getSerie(){
        return this;
    }

    public abstract int getValor();

    @Override
    public int compareTo(Moneda otraMoneda){
        return Integer.compare(this.getValor(), otraMoneda.getValor());
    }
}
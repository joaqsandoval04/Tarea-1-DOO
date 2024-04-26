abstract class Moneda implements Comparable<Enum>{
    public Moneda(){

    }

    public Moneda getSerie(){
        return this;
    }

    public abstract int getValor();

    @Override
    public int compareTo(Enum Producto){
        return Integer.compare(this.getValor(), Producto.getValor());
    }
}
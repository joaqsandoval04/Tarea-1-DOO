import java.util.ArrayList;

class Deposito<T>{
    private ArrayList<T> lista;

    public Deposito(){
        lista = new ArrayList<>();
    }

    public void addList(T p){
        lista.add(p);
    }


    public T getMoneda() {
        if (lista.isEmpty())
            return null;
        return lista.removeFirst();
    }

    public T getProducto(){
        if (!lista.isEmpty()){
            return lista.removeFirst();
        }else {
            return null;
        }
    }
}
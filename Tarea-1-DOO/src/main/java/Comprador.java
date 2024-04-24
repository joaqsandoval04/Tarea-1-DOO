class Comprador{
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualProducto, Expendedor exp)throws NoHayProductoException,PagoIncorrectoException,PagoInsuficienteException{
        int total;

        Producto ProductoComprado = exp.comprarProducto(m, cualProducto);
        Moneda monedaVuelto;

        if (ProductoComprado != null) {
            sonido = ProductoComprado.consumir();
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

    public String queConsumiste(){
        return sonido;
    }
}
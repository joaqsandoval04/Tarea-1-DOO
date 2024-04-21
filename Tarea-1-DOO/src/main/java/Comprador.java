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
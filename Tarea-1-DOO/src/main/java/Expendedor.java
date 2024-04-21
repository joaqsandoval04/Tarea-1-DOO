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
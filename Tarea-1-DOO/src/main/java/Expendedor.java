class Expendedor{
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;

    private Deposito<Producto> fanta;

    private Deposito<Producto> snickers;

    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    public static final int COCA=1;
    public static final int SPRITE=2;

    public static final int FANTA=3;

    public static final int SNICKERS=4;

    public static final int SUPER8=5;

    public int precio;

    public Expendedor(int numProductos, int precioProductos){
        monVu = new Deposito<>();

        coca = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new CocaCola(100+i);
            coca.addList(p);
        }

        sprite = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Sprite(200+i);
            sprite.addList(p);
        }

        fanta = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Fanta(300+i);
            fanta.addList(p);
        }

        snickers = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Snickers(400+i);
            snickers.addList(p);
        }

        super8 = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Super8(500+i);
            super8.addList(p);
        }



        precio = precioProductos;
    }


    public Producto comprarProducto(Moneda m, int type) throws NoHayProductoException,PagoIncorrectoException,PagoInsuficienteException {
        Producto p;

        int vuelto;

        if (m == null) {
            throw new PagoIncorrectoException("Pago incorrecto: No se ingresó ninguna moneda");
        }

        if (m.getValor() >= precio) {
            if (type == COCA) {
                p = coca.getProducto();
            } else if (type == SPRITE){
                p = sprite.getProducto();
            }else if (type == FANTA){
                p = fanta.getProducto();
            }else if (type ==  SNICKERS){
                p = snickers.getProducto();
            }else if (type == SUPER8){
                p = super8.getProducto();
            }else{
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addList(new Moneda100());
                    vuelto -= 100;
                }
                throw new NoHayProductoException("No queda el producto solicitado");
            }
            if (p != null) {
                vuelto = m.getValor() - precio;
                while (vuelto > 0) {
                    monVu.addList(new Moneda100());
                    vuelto -= 100;
                }
            }
            else {
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addList(new Moneda100());
                    vuelto -= 100;
                }
            }
            return p;
        }
        else {
            vuelto = m.getValor();
            while (vuelto > 0) {
                monVu.addList(new Moneda100());
                vuelto -= 100;
            }
            throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
        }
    }

    public Moneda getVuelto(){
        return monVu.getMoneda();
    }

}
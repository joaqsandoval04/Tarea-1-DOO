class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private Deposito monVu;
    public int precio;
    public Expendedor(int numProductos){
        monVu = new Deposito();

        coca = new Deposito();
        for (int i = 0; i < numProductos; i++){
            Producto p = new CocaCola(100+i);
            coca.addProducto(p);
        }

        sprite = new Deposito();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Sprite(200+i);
            sprite.addProducto(p);
        }

        fanta = new Deposito();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Fanta(300+i);
            fanta.addProducto(p);
        }

        snickers = new Deposito();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Snickers(400+i);
            snickers.addProducto(p);
        }

        super8 = new Deposito();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Super8(500+i);
            super8.addProducto(p);
        }
    }
    public Producto comprarProducto(Moneda m, int type) throws NoHayProductoException,PagoIncorrectoException,PagoInsuficienteException {
        Producto p;

        int vuelto;

        if (m == null) {
            throw new PagoIncorrectoException("Pago incorrecto: No se ingresó ninguna moneda");
        }

        for (int i = 0; i < Enum.values().length; i++){
            if (!(type == Enum.COCA.getid()|| type == Enum.SPRITE.getid()|| type == Enum.FANTA.getid()|| type == Enum.SNICKERS.getid()|| type == Enum.SUPER8.getid())){
                throw new NoHayProductoException("No existe el producto solicitado");
            }
        }

        switch (Enum.values()[Enum.values().length - 1]) {
            case COCA:
                if (m.getValor() >= Enum.COCA.getvalor()) {
                    p = coca.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - precio;
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case SPRITE:
                if (m.getValor() >= Enum.SPRITE.getvalor()) {
                    p = sprite.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - precio;
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case FANTA:
                if (m.getValor() >= Enum.FANTA.getvalor()) {
                    p = fanta.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - precio;
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case SNICKERS:
                if (m.getValor() >= Enum.SNICKERS.getvalor()) {
                    p = snickers.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - precio;
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case SUPER8:
                if (m.getValor() >= Enum.SUPER8.getvalor()) {
                    p = super8.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - precio;
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addMoneda(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            default:
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addMoneda(new Moneda100());
                    vuelto -= 100;
                }
                throw new NoHayProductoException("No existe el producto solicitado");
        }
    }

       public Moneda getVuelto(){
           return monVu.getMoneda();
       }
}
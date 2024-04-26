class Expendedor{
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    public Expendedor(int numProductos){
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
    }
    public Producto comprarProducto(Moneda m, int type) throws NoHayProductoException,PagoIncorrectoException,PagoInsuficienteException {
        Producto p;

        int vuelto;

        if (m == null) {
            throw new PagoIncorrectoException("Pago incorrecto: No se ingresó ninguna moneda");
        }

        if (!(type == Enum.COCA.getId()|| type == Enum.SPRITE.getId()|| type == Enum.FANTA.getId()|| type == Enum.SNICKERS.getId()|| type == Enum.SUPER8.getId())){
            throw new NoHayProductoException("No existe el producto solicitado");
            }

        int j = 0;
        for (int i = 0; i < Enum.values().length; i++){
            if (type == Enum.values()[i].getId())
                j = i;
            }

        switch (Enum.values()[j]) {
            case COCA:
                if (m.compareTo(Enum.COCA) == 1 || m.compareTo(Enum.COCA) == 0) {
                    p = coca.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.COCA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case SPRITE:
                if (m.compareTo(Enum.SPRITE) == 1 || m.compareTo(Enum.SPRITE) == 0) {
                    p = sprite.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.SPRITE.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case FANTA:
                if (m.compareTo(Enum.FANTA) == 1 || m.compareTo(Enum.FANTA) == 0) {
                    p = fanta.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.FANTA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case SNICKERS:
                if (m.compareTo(Enum.SNICKERS) == 1 || m.compareTo(Enum.SNICKERS) == 0) {
                    p = snickers.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.SNICKERS.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            case SUPER8:
                if (m.compareTo(Enum.SUPER8) == 1 || m.compareTo(Enum.SUPER8) == 0) {
                    p = super8.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.SUPER8.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto");
                }

            default:
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addList(new Moneda100());
                    vuelto -= 100;
                }
                throw new NoHayProductoException("No existe el producto solicitado");
        }
    }
    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}
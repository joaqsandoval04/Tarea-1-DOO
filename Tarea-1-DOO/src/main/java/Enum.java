public enum Enum {
    COCA(1,500),
    SPRITE(2,1000),
    FANTA(76,700),
    SNICKERS(4,400),
    SUPER8(5,100);

    private final int id;
    private final int valor;

    Enum(int id, int valor) {
        this.id = id;
        this.valor = valor;
    }
    public int getid(){
        return id;
    }
        public int getvalor(){
        return valor;
    }
}

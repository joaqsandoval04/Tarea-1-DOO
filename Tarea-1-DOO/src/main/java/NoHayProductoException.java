class NoHayProductoException extends Exception{
    public NoHayProductoException(String errmsg){
        super(errmsg);
    }
}
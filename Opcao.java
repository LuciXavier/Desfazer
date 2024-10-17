public class Opcao {
    String tipo; // "inserir" ou "remover"
    String texto;

    public Opcao(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return tipo + ": " + texto;
    }
}

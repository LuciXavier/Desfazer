public class Elemento {
    Opcao operacao;
    Elemento proximo;

    public Elemento(Opcao operacao) {
        this.operacao = operacao;
        this.proximo = null;
    }
}

public class Pilha {
    Elemento topo;
    int tam;

    public Pilha() {
        this.topo = null;
        this.tam = 0;
    }

    public void push(Opcao operacao) {
        Elemento e = new Elemento(operacao);
        e.proximo = topo;
        topo = e;
        tam++;
    }

    public Opcao pop() {
        if (empty()) {
            System.out.println("Pilha vazia");
            return null;
        }
        Elemento e = topo;
        topo = topo.proximo;
        tam--;
        return e.operacao;
    }

    public int size() {
        return tam;
    }

    public boolean empty() {
        return tam == 0;
    }
}

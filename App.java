import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha desfazer = new Pilha();
        Pilha refazer = new Pilha();
        String texto = "";

        while (true) {
            System.out.println("Texto atual: " + texto);
            System.out.println("Escolha uma opção: (1) Inserir (2) Remover (3) Desfazer (4) Refazer (0) Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o texto para inserir: ");
                    String textoInserido = scanner.nextLine();
                    texto += textoInserido; // Adiciona o texto
                    desfazer.push(new Opcao("inserir", textoInserido));
              
                    refazer = new Pilha();
                    break;

                case 2:
                    if (texto.length() > 0) {
                        String textoRemovido = texto.substring(texto.length() - 1);
                        texto = texto.substring(0, texto.length() - 1);
                        desfazer.push(new Opcao("remover", textoRemovido));
                        refazer = new Pilha();
                    } else {
                        System.out.println("Texto vazio, nada para remover.");
                    }
                    break;

                case 3:
                    Opcao operacaoDesfazer = desfazer.pop();
                    if (operacaoDesfazer != null) {
                        if (operacaoDesfazer.tipo.equals("inserir")) {
                            texto = texto.substring(0, texto.length() - operacaoDesfazer.texto.length());
                            refazer.push(new Opcao("remover", operacaoDesfazer.texto));
                        } else if (operacaoDesfazer.tipo.equals("remover")) {
                            texto += operacaoDesfazer.texto;
                            refazer.push(new Opcao("inserir", operacaoDesfazer.texto));
                        }
                    }
                    break;

                case 4:
                    Opcao operacaoRefazer = refazer.pop();
                    if (operacaoRefazer != null) {
                        if (operacaoRefazer.tipo.equals("inserir")) {
                            texto += operacaoRefazer.texto;
                            desfazer.push(new Opcao("inserir", operacaoRefazer.texto));
                        } else if (operacaoRefazer.tipo.equals("remover")) {
                            texto = texto.substring(0, texto.length() - operacaoRefazer.texto.length());
                            desfazer.push(new Opcao("remover", operacaoRefazer.texto));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção não encontrada, Tente novamente.");
            }
        }
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha desfazer = new Pilha();
        String texto = "";

        while (true) {
            System.out.println("Texto atual: " + texto);
            System.out.println("Escolha uma opção: (1) Inserir (2) Remover (3) Desfazer (0) Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o texto para inserir: ");
                    String textoInserido = scanner.nextLine();
       
                    if (!texto.isEmpty()) {
                        desfazer.push(new Opcao("remover", texto));
                        System.out.println("Texto anterior armazenado para desfazer: " + texto);
                    }

                    texto = textoInserido; 
                    break;

                case 2:
                    if (!texto.isEmpty()) {
                        String textoRemovido = texto;
                        texto = ""; 
                        desfazer.push(new Opcao("remover", textoRemovido));
                        System.out.println("Texto removido: " + textoRemovido);
                    } else {
                        System.out.println("Texto vazio, nada para remover.");
                    }
                    break;

                case 3:
                    Opcao opcaoDesfazer = desfazer.pop();
                    if (opcaoDesfazer != null) {
                        if (opcaoDesfazer.tipo.equals("remover")) {
                            texto = opcaoDesfazer.texto; 
                            System.out.println("Desfazer: Texto restaurado para: " + texto);
                        }
                    } else {
                        System.out.println("Nada para desfazer.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção não encontrada, tente novamente.");
            }
        }
    }
}

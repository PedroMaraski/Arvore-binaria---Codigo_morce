public class ArvoreBinariaCodigoMorse {
    private static class No {
        private char letra;
        private No esquerda;
        private No direita;
    }

    private final No raiz = new No();

    public void inserir(String codigo, char letra) {

        No atual = raiz;
        for (char simbolo : codigo.toCharArray()) {
            if (simbolo == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new No();
                }
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                if (atual.direita == null) {
                    atual.direita = new No();
                }
                atual = atual.direita;
            }
        }
        atual.letra = letra;
    }

        public String buscar(String codigo) {

        String[] codigosDasLetras = codigo.trim().split("\\s+");
        String resultado = "";

        for (String codigoDaLetra : codigosDasLetras) {
            No atual = raiz;
            for (char simbolo : codigoDaLetra.toCharArray()) {
                if (simbolo == '.') {
                    atual = atual.esquerda;
                } else if (simbolo == '-') {
                    atual = atual.direita;
                }
            }
            resultado += atual.letra;
        }

        return resultado;
    }

    //CONTEUDO 100% criado por inteligencia artificial 

    public void exibir() {
    System.out.println("raiz");
    exibir(raiz.esquerda, "", raiz.direita == null, '.');
    exibir(raiz.direita, "", true, '-');
}

private void exibir(No no, String prefixo, boolean ultimo, char simbolo) {
    if (no == null) {
        return;
    }
    String letra = no.letra == '\0' ? "" : " " + no.letra;
    System.out.println(prefixo + (ultimo ? "└── " : "├── ") + simbolo + letra);

    String novoPrefixo = prefixo + (ultimo ? "    " : "│   ");
    exibir(no.esquerda, novoPrefixo, no.direita == null, '.');
    exibir(no.direita, novoPrefixo, true, '-');
}

// Fim do conteúdo criado por inteligencia artificial

    public static void main(String[] args) {
        ArvoreBinariaCodigoMorse arvore = new ArvoreBinariaCodigoMorse(); 
        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir("-----", '0');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');
        

        arvore.exibir();

        System.out.println(arvore.buscar("-..."));
        System.out.println(arvore.buscar("-----"));
        System.out.println(arvore.buscar(".-. . -.-. . -... .-"));
        System.out.println(arvore.buscar("-.. . ...- --- .-.. ...- .-"));
        System.out.println(arvore.buscar("----------"));
    }
}
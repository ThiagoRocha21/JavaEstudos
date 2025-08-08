package Tests.dominio.palindromo.domain;

import java.util.ArrayList;

public class IsPalindrome extends PalindromeMaker {
    ArrayList<String> palindromos = new ArrayList<>();


    public void isPalindrome() {
        for (int i = 0; i < palavras.size(); i++) { //verifica se ha palindromos na lista de palavras 
            if (palavras.get(i).equals(palavrasInversas.get(i)) && palavras.get(i).length() >= 3) {
                palindromos.add(palavras.get(i));
            }
        }
        if (!palindromos.isEmpty()) { //garante que o nao serao apresentados os subpalindromos presentos no palindromo
            for (int i = (palindromos.size() - 1); i > 0 ; i--) {
                String palindromoMaior = palindromos.get(i-1);
                String palindromoMenor = palindromos.get(i);
                if (palindromoMaior.contains(palindromoMenor)) {
                    palindromos.remove(i);
                }
            }
        }
    }


    public void letterSmash() {
        //retira cada caracter da direita para a esquerda, um por um e salva em uma lista as palavras sem os caracteres.
        String textoDigitado = getTexto();
        palavras.add(textoDigitado);
        for (int k = (textoDigitado.length() - 1); k >= 3; k--) {
            String excluir = palavras.getLast();
            if (excluir.length() >= 3) {
                StringBuilder newText = new StringBuilder(excluir);
                newText.deleteCharAt((excluir.length() - 1));
                String alterWord = newText.toString();
                palavras.add(alterWord);
            }
        } //mesma coisa que o for de cima, porém, da esquerda para a direita.
        for (int k = 0; k < (textoDigitado.length() - 3); k++) {
            String excluir = palavras.getLast();
            StringBuilder newText = new StringBuilder(excluir);
            if (excluir.length() > 0) {
                newText.deleteCharAt(0);
                String alterWord = newText.toString();
                palavras.add(alterWord);
            } else {
                break;
            }
        }
    }

    public void letterSmashFrontBack() {
        String textoDigitado = getTexto();
        palavrasEmFormacao.add(textoDigitado);
        while (palavrasEmFormacao.getLast().length() > 3) {
            String excluir = palavrasEmFormacao.getLast();
            StringBuilder excluirLetrasFront = new StringBuilder(excluir);
            excluirLetrasFront.deleteCharAt(0);
            String semChar0 = excluirLetrasFront.toString();
            palavras.add(semChar0);
            palavrasEmFormacao.add(semChar0);
            while (palavras.getLast().length() > 4) {
                String excluirBack = palavras.getLast();
                StringBuilder excluirLetrasBack = new StringBuilder(excluirBack);
                if (excluirBack.length() > 0) {
                    excluirLetrasBack.deleteCharAt(excluirBack.length() - 1);
                    String palavraFinal = excluirLetrasBack.toString();
                    palavras.add(palavraFinal);
                }
            }
        }
    }

    public void searchPalindrome() {
        letterSmash();
        letterSmashFrontBack();
        for (String palavra : palavras) {
            setTexto(palavra);
            destrinchar();
            listaChar.clear();
            listaCharInversa.clear();
        }
        isPalindrome();
        if (palindromos.isEmpty()) {
            System.out.println("Não há palíndromos na palavra.");
        } else {
            for (String palindromo : palindromos) {
                System.out.println("Há um palíndromo na palavra: " + palindromo);
            }
        }
    }
}


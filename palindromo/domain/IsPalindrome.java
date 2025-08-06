package testes.dominio.palindromo.domain;

import java.util.ArrayList;

public class IsPalindrome extends PalindromeMaker {
    ArrayList<String> palindromos = new ArrayList<>();

    public IsPalindrome(String texto) {
        super(texto);
    }

    public void isPalindrome() {
        for (int i = 0; i < palavras.size(); i++) {
            if (palavras.get(i).equals(palavrasInversas.get(i))) {
                palindromos.add(palavras.get(i));
            }
        }
    }


    public void letterSmash() {
        //retira cada caracter da direita para a esquerda, um por um e salva em uma lista as palavras sem os caracteres.
        String textoDigitado = getTexto();
        palavras.add(textoDigitado);
        for (int k = (textoDigitado.length() - 1); k >= 3; k--) {
            String excluir = palavras.getLast();
            StringBuilder newText = new StringBuilder(excluir);
            newText.deleteCharAt((excluir.length() - 1));
            String alterWord = newText.toString();
            palavras.add(alterWord);
        } //mesma coisa que o for de cima, porém, da esquerda para a direita.
        palavras.add(textoDigitado);
        for (int k = 0; k < (textoDigitado.length() - 3); k++) {
            String excluir = palavras.getLast();
            StringBuilder newText = new StringBuilder(excluir);
            newText.deleteCharAt(0);
            String alterWord = newText.toString();
            palavras.add(alterWord);
        }
    }

    public void searchPalindrome() {
        letterSmash();
        for (String palavra : palavras) {
            setTexto(palavra);
            destrinchar();
            lista.clear();
            listaInversa.clear();
            System.out.println(palavras);
            System.out.println(palavrasInversas);
        }
        isPalindrome();
        if(palindromos.isEmpty()){
            System.out.println("Não há palíndromos na palavra.");
        }
        else{
            for(String palindromo : palindromos){
                System.out.println("Há um palíndromo na palavra: "+palindromo);
            }
        }
    }
}
package Tests.dominio.palindromo.domain;

import java.util.ArrayList;

public class PalindromeMaker {
    private  String texto;
    ArrayList<Character> listaChar = new ArrayList<>();
    ArrayList<Character> listaCharInversa = new ArrayList<>();
    ArrayList<String> palavras = new ArrayList<>();
    ArrayList<String> palavrasEmFormacao = new ArrayList<>();
    ArrayList<String> palavrasInversas = new ArrayList<>();


    public void imprimir(){
        System.out.println(getTexto());
    }

    public void destrinchar(){
        //pega cada caracter do texto
        for (int i = 0; i < this.texto.length(); i++) {
            char adicionarCharLista = this.texto.charAt(i);
            this.listaChar.add(adicionarCharLista);
        } //inverte os caracteres do texto
        for (int i = (this.listaChar.size() - 1) ; i >= 0 ; i--) {
            char adicionarCharInverso = this.listaChar.get(i);
            this.listaCharInversa.add(adicionarCharInverso);
        }
        juntaChar();
    }

    public void juntaChar(){ //transforma o array de char em uma string
        StringBuilder juntarInverso = new StringBuilder(); //esse metodo pega caracteres, junta na variavel e transforma em string
        for(char c : listaCharInversa){
            juntarInverso.append(c); //adiciona os caracteres no StringBuilder()
        }
        String palavraFinalInversa = juntarInverso.toString();// passa os caracteres juntos para a String de vez.
        palavrasInversas.add(palavraFinalInversa);
    }



    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return this.texto;
    }
}

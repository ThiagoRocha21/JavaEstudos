package Tests.dominio.SubString.domain;

import java.util.ArrayList;

public class SubString {
    private String texto;
    ArrayList<Character> palavraFinal = new ArrayList<>();
    ArrayList<String> subs = new ArrayList<>();
    private char[] listaDeSubs;

    public SubString(String texto) {
        this.texto = texto;
    }

    public void destrinchar() {
        int k = 0;
        StringBuilder subString = new StringBuilder();
        for (int i = 0; i < this.texto.length(); i++) {
            char caracterTexto = this.texto.charAt(i);
            if(palavraFinal.isEmpty()){
                palavraFinal.add(caracterTexto);
                subString.append(caracterTexto);
                k++;
            }
            else if(!palavraFinal.contains(caracterTexto)){
                palavraFinal.add(caracterTexto);
                k++;
                subString.append(caracterTexto);
            }
            else{
                String sub = subString.toString();
                subs.add(sub);
                subString.setLength(0);
            }
        }
        System.out.println(subs);
    }

    public void tamanhoSub(){
        destrinchar();
        String comparativo = subs.getFirst();
        for(String palavra : subs){
            if(palavra.length() > comparativo.length()) comparativo = palavra;
        }
        System.out.println(comparativo);
    }


    public static void main(String[] args) {
        SubString test = new SubString("pareeluizo");

        test.tamanhoSub();
    }
}

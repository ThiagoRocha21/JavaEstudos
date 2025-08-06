package testes.dominio.palindromo.test;

import testes.dominio.palindromo.domain.IsPalindrome;
import testes.dominio.palindromo.domain.PalindromeMaker;

public class TestPalindromo {
    public static void main(String[] args) {
        PalindromeMaker palindromo = new PalindromeMaker("texto");
        IsPalindrome TorF = new IsPalindrome(palindromo.getTexto());

        //palindromo.destrinchar();
       // palindromo.imprimir();
       // TorF.isPalindrome();
        TorF.searchPalindrome();
    }
}

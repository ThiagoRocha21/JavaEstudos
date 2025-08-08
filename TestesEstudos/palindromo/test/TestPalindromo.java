package Tests.dominio.palindromo.test;


import Tests.dominio.palindromo.domain.IsPalindrome;
import java.util.Scanner;

public class TestPalindromo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        IsPalindrome Test1 = new IsPalindrome();

        System.out.println("Digite a palavra ou frase que você quer encontrar o palindromo: ");
        String texto = scanner.nextLine();
        Test1.setTexto(texto);

        Test1.searchPalindrome();
    }
}

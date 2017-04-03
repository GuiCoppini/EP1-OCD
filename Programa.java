import java.util.Scanner;

public class Programa {
    public static String numero1, numero2;
    public static int decimal1, decimal2;
    static int[] binario1;
    static int[] binario2;
    
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira 1 para inserir um numero em binario, ou 2 para um numero em decimal");
        int numeroEscolhido = Integer.parseInt(scan.nextLine());
        switch (numeroEscolhido) {
            case 1:
                System.out.print("insira o numero em binario, separado por espacos" + "\n");
                numero1 = scan.nextLine();
                System.out.println("insira o numero em binario, por espacos");
                numero2 = scan.nextLine();
                binario1 = operacoes.converteString(numero1);
                binario2 = operacoes.converteString(numero2);
                break;
            case 2:
                decimal1 = Integer.parseInt(scan.nextLine());
                operacoes.converteParaBinario(decimal1);
                System.out.println("Segundo numero: ");
                decimal2 = Integer.parseInt(scan.nextLine());
                operacoes.converteParaBinario(decimal2);
                break;
            default:
                System.out.println("operacao invalida.");
        }
        // ja peguei os numeros em binario.
        // questiono sobre qual operacao devo realizar.
        
        System.out.println("Insira o numero da operacao desejada");
        System.out.println("1) Soma" + "\n" + "2) Subtracao " + "\n" + "3) Multiplicacao" + "\n" + "4) Divisao ");
        int numeroOperacao = Integer.parseInt(scan.next());
        switch (numeroOperacao) {
            case 1:
                System.out.println("soma");
                int[] resultado = operacoes.somaBinarios(binario1, binario2);
                for (int i = 0; i < resultado.length; i++) {
                    System.out.println(resultado[i]);
                }
                break;
            case 2:
                System.out.println("sub");
                break;
            case 3:
                System.out.println("mult");
                break;
            case 4:
                System.out.println("div");
                break;
            default:
                System.out.println("operacao invalida");
        }
        
    }
}

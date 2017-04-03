import java.util.Scanner;

public class Programa {
    public static String binarioEmString1, binarioEmString2;
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
                System.out.print("insira o numero em binario:" + "\n");
                binarioEmString1 = scan.nextLine();
                System.out.println("insira o segundo numero em binario");
                binarioEmString2 = scan.nextLine();
                binario1 = operacoes.converteString(binarioEmString1);
                binario2 = operacoes.converteString(binarioEmString2);
                break;
            case 2:
                System.out.println("Insira o primeiro numero:");
                decimal1 = Integer.parseInt(scan.nextLine());
                binario1 = operacoes.converteParaBinario(decimal1);
                System.out.println("Segundo numero: ");
                decimal2 = Integer.parseInt(scan.nextLine());
                binario2 = operacoes.converteParaBinario(decimal2);
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
                operacoes.imprimeBinario(operacoes.somaBinarios(binario1, binario2));
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

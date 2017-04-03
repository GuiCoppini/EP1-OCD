public class Operacoes extends Conversoes {
    
    int[] somaBinarios(int[] bin1, int[] bin2) {
        int[] resultado = new int[bin1.length + 1];
        for (int i = resultado.length - 1; i > 0; i--) {
            resultado[i] += bin1[i - 1] + bin2[i - 1];
            if (resultado[i] >= 2) {
                resultado[i - 1] = resultado[i] / 2;
                resultado[i] = resultado[i] % 2;
            }
        }
        
        return resultado;
    }
    
    int[] converteParaBinario(int decimal) {
        return null;
    }
    
    int[] converteString(String numero1) {
        String conversao[] = numero1.split(" ");
        int[] binario = new int[conversao.length];
        for (int i = 0; i < conversao.length; i++) {
            binario[i] = Integer.parseInt(conversao[i]);
        }
        return binario;
    }
}

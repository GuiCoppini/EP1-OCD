public class Operacoes extends Conversoes {
    
    int[] somaBinarios(int[] bin1, int[] bin2) {
        int[] binarioCorrigido, resultado;
        if (bin1.length == bin2.length) {
            resultado = new int[bin1.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += bin1[i - 1] + bin2[i - 1];
                if (resultado[i] >= 2) {
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        } else if (max(bin1.length, bin2.length) == bin1.length) {
            binarioCorrigido = new int[bin1.length];
            int j = binarioCorrigido.length - 1;
            for (int i = bin2.length - 1; i >= 0; i--) {
                binarioCorrigido[j] = bin2[i];
                j--;
            }
            resultado = new int[binarioCorrigido.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += bin1[i - 1] + binarioCorrigido[i - 1];
                if (resultado[i] >= 2) {
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        } else {
            binarioCorrigido = new int[bin2.length];
            int j = binarioCorrigido.length - 1;
            for (int i = bin1.length - 1; i >= 0; i--) {
                binarioCorrigido[j] = bin1[i];
                j--;
            }
            resultado = new int[binarioCorrigido.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += binarioCorrigido[i - 1] + bin2[i - 1];
                if (resultado[i] >= 2) {
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        }
        return resultado;
    }
    
    int[] converteParaBinario(int decimal) {
        String binaria = Integer.toBinaryString(decimal);
        return converteString(binaria);
    }    
    int[] converteString(String numero1) {
        String conversao[] = numero1.split(" ");
        int[] binario = new int[conversao.length];
        for (int i = 0; i < conversao.length; i++) {
            binario[i] = Integer.parseInt(conversao[i]);
        }
        return binario;
    }
    void imprimeBinario(int[] binario){
        for (int i = 1; i < binario.length; i++) {
            System.out.println(binario[i]);
        }
    }
}

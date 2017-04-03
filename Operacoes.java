public class Operacoes extends Conversoes {
    
    int[] somaBinarios(int[] bin1, int[] bin2) {
        int[] resultado, binarioCorrigido;
        binarioCorrigido = igualaBits(bin1, bin2);
        if (bin1.length == bin2.length) {
            resultado = new int[bin1.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += bin1[i - 1] + bin2[i - 1];
                if (resultado[i] >= 2) {
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        } else if (binarioCorrigido.length == bin1.length) {
            resultado = new int[binarioCorrigido.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += bin1[i - 1] + binarioCorrigido[i - 1];
                if (resultado[i] >= 2) {
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        } else {
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
        String conversao[] = numero1.split("");
        int[] binario = new int[conversao.length];
        for (int i = 0; i < conversao.length; i++) {
            binario[i] = Integer.parseInt(conversao[i]);
        }
        return binario;
    }
    
    void imprimeBinario(int[] binario) {
        for (int i = 0; i < binario.length; i++) {
            System.out.print(binario[i] + " ");
        }
    }
    
    int[] complementoDe2(int[] binario) {
        for (int i = 0; i <= binario.length - 1; i++) {
            if (binario[i] == 0) {
                binario[i] = 1;
            } else {
                binario[i] = 0;
            }
        }
        binario[binario.length - 1]++;
        if (binario[binario.length - 1] >= 2) {
            binario[binario.length - 2] = binario[binario.length - 1] / 2;
            binario[binario.length - 1] = binario[binario.length - 1] % 2;
            
        }
        return binario;
    }
    
    int[] igualaBits(int[] bin1, int[] bin2) {
        int[] binarioCorrigido;
        
        if (max(bin1.length, bin2.length) == bin1.length) {
            binarioCorrigido = new int[bin1.length];
            int j = binarioCorrigido.length - 1;
            for (int i = bin2.length - 1; i >= 0; i--) {
                binarioCorrigido[j] = bin2[i];
                j--;
            }
        } else {
            binarioCorrigido = new int[bin2.length];
            int j = binarioCorrigido.length - 1;
            for (int i = bin1.length - 1; i >= 0; i--) {
                binarioCorrigido[j] = bin1[i];
                j--;
            }
        }
        return binarioCorrigido;
    }
    
    public int[] subtracaoBinarios(int[] binario1, int[] binario2) {
        // binario1 - binario2, ja definido pelo usuario
        // binario2 negativo.
        int[] binarioComSinal1, binarioComSinal2, subtracao;
        binarioComSinal1 = new int[binario1.length + 1];
        binarioComSinal2 = new int[binario2.length + 1];
        for (int i = binario1.length - 1; i >= 0; i--) { // adiciona bit do //
            // sinal
            binarioComSinal1[i + 1] = binario1[i];
        }
        for (int i = binario2.length - 1; i >= 0; i--) {
            binarioComSinal2[i + 1] = binario2[i];
        }
        binarioComSinal2 = complementoDe2(binarioComSinal2);
        subtracao = somaBinarios(binarioComSinal1, binarioComSinal2);
        if (subtracao[1] == 1) { // eh negativo, precisa de complemento de 2
            
            subtracao[0] = 1;
            subtracao = complementoDe2(subtracao);
            
        } else if (subtracao[0] == 1) {
            subtracao[0] = 0;
        }
        return subtracao;
    }
    
}

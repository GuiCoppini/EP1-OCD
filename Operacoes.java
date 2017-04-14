public class Operacoes extends Conversoes {
    
    int[] somaBinarios(int[] bin1, int[] bin2, boolean subtracao) {
        int[] resultado, binarioCorrigido;
        binarioCorrigido = igualaBits(bin1, bin2);
        if (bin1.length == bin2.length) {
            resultado = new int[bin1.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += bin1[i - 1] + bin2[i - 1];
                if (resultado[i] >= 2) {
                    if (i == 1) {
                        if (subtracao == true) {
                            resultado[i] = resultado[i] % 2;
                        }
                    }
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        } else if (binarioCorrigido.length == bin1.length) {
            resultado = new int[binarioCorrigido.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += bin1[i - 1] + binarioCorrigido[i - 1];
                if (resultado[i] >= 2) {
                    if (i == 1)
                        if (subtracao == true) {
                            resultado[i] = resultado[i] % 2;
                        }
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        } else {
            resultado = new int[binarioCorrigido.length + 1];
            for (int i = resultado.length - 1; i > 0; i--) {
                resultado[i] += binarioCorrigido[i - 1] + bin2[i - 1];
                if (resultado[i] >= 2) {
                    if (i == 1)
                        if (subtracao == true) {
                            resultado[i] = resultado[i] % 2;
                        }
                    resultado[i - 1] = resultado[i] / 2;
                    resultado[i] = resultado[i] % 2;
                }
            }
        }
        return corrige0(resultado);
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
        }System.out.println();
    }
    
    int[] complementoDe2(int[] binario) {
        for (int i = 0; i <= binario.length - 1; i++) {
            if (binario[i] == 0) {
                binario[i] = 1;
            } else {
                binario[i] = 0;
            }
        }
        int[] numero1 = { 0, 1 };
        
        binario = somaBinarios(binario, numero1, true);
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
        int[] resultado = { 0 };
        if (numerosIguais(binario1, binario2) == true) {
            return resultado;
        }
        
        if (numerosIguais(comparaMaior(binario1, binario2), binario1) == true) {
            int[] aux;
            aux = binario1;
            binario1 = binario2;
            binario2 = aux;
        }
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
        subtracao = somaBinarios(binarioComSinal1, binarioComSinal2, true);
        if (subtracao[0] == 1)
            subtracao = complementoDe2(subtracao);
        return corrige0(subtracao);
    }
    
    private boolean numerosIguais(int[] binario1, int[] binario2) {
        if (comparaMaior(binario1, binario2) != null)
            return false;
        for (int i = 0; i < min(binario1.length, binario2.length); i++) {
            if (binario1[i] != binario2[i])
                return false;
        }
        return true;
    }
    
    private int[] comparaMaior(int[] binario1, int[] binario2) {
        if (binario1.length > binario2.length) {
            return binario1;
        } else if (binario2.length > binario1.length)
            return binario2;
        for (int i = 0; i < min(binario1.length, binario2.length); i++) {
            if (binario1[i] == 0 && binario2[i] == 1) {
                return binario2;
            } else if (binario2[i] == 0 && binario1[i] == 1)
                return binario1;
        }
        return null; // sao iguais
    }
    
    public int[] corrige0(int[] binario) {
        int j = 0;
        for (int i = 0; i < binario.length; i++) {
            if (binario[i] == 0) {
                j++;
            }
            if (binario[i] == 1)
                break;
        }
        if (j == binario.length)
            return binario;
        int[] binarioSem0 = new int[binario.length - j];
        for (int i = 0; i < binarioSem0.length; i++) {
            binarioSem0[i] = binario[j];
            j++;
        }
        return binarioSem0;
    }
    
    public int[] divisaoBinario(int[] dividendo, int[] divisor) {
        if(verificaZero(divisor) == true)
            return null;
        if (comparaMaior(dividendo, divisor) == divisor)
            return null;
        int[] resto, antecessor;
        int[] numero1 = { 1 };
        int[] quociente = { 0 };
        resto = subtracaoBinarios(dividendo, divisor);
        quociente = somaBinarios(quociente, numero1, false);
        while (verificaZero(resto) == false && comparaMaior(resto, divisor) == resto) {
            quociente = somaBinarios(quociente, numero1, false);
            resto = subtracaoBinarios(resto, divisor);
            if (comparaMaior(resto, divisor) == divisor)
                resto = somaBinarios(resto, divisor, false);
        }
        if (comparaMaior(resto, divisor) == null) {
            resto = subtracaoBinarios(resto, divisor);
            quociente = somaBinarios(quociente, numero1, false);
        }
        imprimeBinario(resto);
        return quociente;
    }
    
    private boolean verificaZero(int[] resto) {
        for (int i = 0; i < resto.length; i++) {
            if (resto[i] == 1)
                return false;
        }
        return true;
    }
}

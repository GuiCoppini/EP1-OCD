public class Operacoes extends Aux {
    
    int[] somaBinarios(int[] bin1, int[] bin2, boolean subtracao, boolean booth) {
        int[] resultado, binarioCorrigido;
        binarioCorrigido = Aux.igualaBits(bin1, bin2);
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
        if (booth == false)
            return Aux.corrige0(resultado);
        if (booth == true && resultado[0] == 0)
            return Aux.corrigePrimeiraCasa(resultado);
        return resultado;
    }
    
    void imprimeBinario(int[] binario) {
        for (int i = 0; i < binario.length; i++) {
            System.out.print(binario[i] + " ");
        }
        System.out.println();
    }
    
    int[] complementoDe2(int[] binario) {
        int[] binarioComplemento = binario;
        for (int i = 0; i <= binario.length - 1; i++) {
            if (binarioComplemento[i] == 0) {
                binarioComplemento[i] = 1;
            } else {
                binarioComplemento[i] = 0;
            }
        }
        int[] numero1 = { 0, 1 };
        
        binarioComplemento = somaBinarios(binarioComplemento, numero1, true, false);
        return binarioComplemento;
    }
    
    public int[] subtracaoBinarios(int[] binario1, int[] binario2) {
        // binario1 - binario2, ja definido pelo usuario
        // binario2 negativo.
        int[] resultado = { 0 };
        if (Aux.numerosIguais(binario1, binario2) == true) {
            return resultado;
        }
        
        if (Aux.numerosIguais(Aux.comparaMaior(binario1, binario2), binario1) == true) {
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
        subtracao = somaBinarios(binarioComSinal1, binarioComSinal2, true, false);
        if (subtracao[0] == 1)
            subtracao = complementoDe2(subtracao);
        return Aux.corrige0(subtracao);
    }
    
    public int[] divisaoBinario(int[] dividendo, int[] divisor) {
        if (Aux.verificaZero(divisor) == true)
            return null;
        if (Aux.comparaMaior(dividendo, divisor) == divisor)
            return null;
        int[] resto;
        int[] numero1 = { 1 };
        int[] quociente = { 0 };
        resto = subtracaoBinarios(dividendo, divisor);
        quociente = somaBinarios(quociente, numero1, false, false);
        while (Aux.verificaZero(resto) == false && Aux.comparaMaior(resto, divisor) == resto) {
            quociente = somaBinarios(quociente, numero1, false, false);
            resto = subtracaoBinarios(resto, divisor);
        }
        if (Aux.comparaMaior(resto, divisor) == null) {
            resto = subtracaoBinarios(resto, divisor);
            quociente = somaBinarios(quociente, numero1, false, false);
        }
        imprimeBinario(resto);
        return quociente;
    }
    
    public int[] booth(int[] multiplicando, int[] multiplicador) {
        if (comparaMaior(multiplicando, multiplicador) == multiplicador) {
            int[] aux = multiplicando;
            multiplicando = multiplicador;
            multiplicador = aux;
        }
        int[] bits = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] igualaBitsMultiplicando = igualaBits(multiplicando, bits);
        int[] igualaBitsMultiplicador = igualaBits(multiplicador, bits);
        int comprimento = igualaBitsMultiplicando.length;
        int[] binarioParaBooth = new int[(comprimento * 2) + 1];
        // linha 1 (o multiplicando nos 8 primeiros bits, e o resto 0)
        for (int i = 0; i < igualaBitsMultiplicando.length; i++) {
            binarioParaBooth[i] = igualaBitsMultiplicando[i];
        }
        int[] binarioParaBooth2 = new int[(comprimento * 2) + 1];
        // linha 2 ( complemento de 2 do multiplicando, e todo o resto 0)
        int[] complementoDe2 = complementoDe2(igualaBitsMultiplicando);
        for (int i = 0; i < complementoDe2.length; i++) {
            binarioParaBooth2[i] = complementoDe2[i];
        }
        int[] produto = new int[(comprimento * 2) + 1];
        int controlador = produto.length - comprimento - 1;
        for (int i = 0; i < igualaBitsMultiplicador.length; i++) {
            produto[controlador] = igualaBitsMultiplicador[i];
            controlador++;
        }
        while (comprimento > 0) {
            if (produto[produto.length - 1] == 0 && produto[produto.length - 2] == 0) {
                produto = moveParaDireita(produto);
            } else if (produto[produto.length - 1] == 1 && produto[produto.length - 2] == 1) {
                produto = moveParaDireita(produto);
            } else if (produto[produto.length - 1] == 0 && produto[produto.length - 2] == 1) { // caso
                produto = somaBinarios(produto, binarioParaBooth2, true, true);
                produto = moveParaDireita(produto);
            } else if (produto[produto.length - 1] == 1 && produto[produto.length - 2] == 0) {
                produto = somaBinarios(produto, binarioParaBooth, true, true);
                produto = moveParaDireita(produto);
            }
            comprimento--;
        }
        return corrige0(removeZeroAdireita(produto));
    }
    int[] removeZeroAdireita(int[] vetor){
        int[] novoVetor = new int[vetor.length-1];
        for (int i = 0; i < novoVetor.length; i++) {
            novoVetor[i] = vetor[i];
        }
        return novoVetor;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Comuns;

import Interfaces.Imprimivel;
import Pacote1.*;

/**
 *
 * @author Marondo
 * Exibe relatorios das contas cadastradas
 * 
 */
public class Relatorio {
/**gerar relatório para cada conta criada
 * 
 * @param imp 
 */
    public void gerarRelatório(Imprimivel imp) {
        imp.mostrarDados();
        if (imp instanceof Conta_Poupaca) {
            new Conta_Poupaca().mostrarDados();
        } else {
            new Conta_Corrente().mostrarDados();
        }
    }
}

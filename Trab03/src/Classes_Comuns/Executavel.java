/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Comuns;

import Pacote1.Conta_Corrente;
import Pacote1.Conta_Poupaca;

/**
 *
 * @author Marondo
 */
public class Executavel {

    Conta_Corrente cc = new Conta_Corrente();
    Conta_Poupaca cp = new Conta_Poupaca();
    Relatorio rel = new Relatorio();

    public Executavel() {
        cc.depositar(123.53);
        cc.sacar(100);

        cp.depositar(300);
        cp.sacar(350);

        rel.gerarRelatório(cc);
        rel.gerarRelatório(cp);
    }
}

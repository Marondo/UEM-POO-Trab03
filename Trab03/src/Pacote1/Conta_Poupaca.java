/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote1;

import Classes_Comuns.Datas_e_Horas;
import Interfaces.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo
 *
 * possui um atributo limite que d� credito a mais para o correntista caso ele
 * precise sacar mais que o saldo. Neste caso, o saldo pode ficar negativo desde
 * que n�o ultrapasse o limite. Herda da classe a baixo
 * @see ContaBancaria
 */
public class Conta_Poupaca extends ContaBancaria implements Imprimivel {

    /**
     * Eh um valor padrao maximo que o usuario pode emprestar ao banco caso na
     * tenha saldo suficiente
     */
    private double limite = 100;

    Datas_e_Horas dh;

    public Conta_Poupaca() {
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * Invoca o super ToString da classe pai
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Implementacao dum metodo abstrato do pai
     *
     * @param valor
     * @return
     */
    @Override
    public double depositar(double valor) {
        dh = new Datas_e_Horas();
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            this.setHistorico("*CP+"+valor+"" + dh.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O valor a depositar deve ser maior que zero!");
        }
        return 0;
    }

    /**
     * Implementacao dum metodo abstrato do pai. Faz o saque tendo em conta o
     * limite que a instituicao predefiniu
     *
     * @param valor
     * @return
     */
    @Override
    public double sacar(double valor) {
        dh = new Datas_e_Horas();
        double limiteAux = this.getLimite();
        if (valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            this.setHistorico("*CP-"+valor+"" + dh.toString());
            return 1;
        } else {
            double divida = this.getSaldo() - valor;
            if ((divida * (-1)) <= limiteAux) {
                this.setSaldo(divida);
                this.setHistorico("*CP-"+valor+"" + dh.toString());
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Erro!\nExcedeu o limite de divida!");
                return 0;
            }
        }
    }

    /**
     * Iplementa ainterface
     */
    @Override
    public void mostrarDados() {
        JOptionPane.showMessageDialog(null, toString());
    }
}

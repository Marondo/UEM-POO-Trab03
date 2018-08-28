package Pacote1;

import Classes_Comuns.Datas_e_Horas;
import Interfaces.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo Extende de
 * @see ContaBancaria Possui um atributo taxaDeOpera��o que � descontado sempre
 * que um saque e um dep�sito s�o feitos. e implementa a inteface
 * @see Imprimivel
 */
public class Conta_Corrente extends ContaBancaria implements Imprimivel {

    /** implements Serializable
     * A percentagem de desconto sempre que se efectua saque
     */
    private double taxaDeOperacao = 0.05;

    Datas_e_Horas dh;

    public Conta_Corrente() {
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    /**
     * Invoca o to string do pai.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Faz um deposito na conta actual
     *
     * @param valor
     * @return
     */
    @Override
    public double depositar(double valor) {
        dh = new Datas_e_Horas();
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor - (valor * getTaxaDeOperacao()));
            this.setHistorico("*CC+"+valor+"" + dh.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O valor a depositar deve ser maior que zero!");
        }
        return 0;
    }

    /**
     * Faz o saque tendo em conta o desconto por transacao
     *
     * @param valor
     * @return
     */
    @Override
    public double sacar(double valor) {
        dh = new Datas_e_Horas();
        double aDescontar = (valor * getTaxaDeOperacao()) + valor;
        double saldoActual = this.getSaldo() - aDescontar;
        if (valor <= saldoActual) {
            this.setSaldo(saldoActual);
            this.setHistorico("*CC-"+valor+"" + dh.toString());
            return 1;
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!" + saldoActual);
            return 0;
        }
    }

    /**
     * Implementacao do metodo da classe imprimivel
     *
     */
    @Override
    public void mostrarDados() {
        JOptionPane.showMessageDialog(null, toString());
    }

}

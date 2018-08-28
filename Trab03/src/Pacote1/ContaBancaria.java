package Pacote1;

import Classes_Comuns.Banco;
import Classes_Comuns.Datas_e_Horas;
import Conexao.Conexao;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo contém como atributos o numero da conta, saldo e historico e
 * como métodos abstratos sacar e depositar que recebem um parâmetro do tipo
 * double.
 */
public abstract class ContaBancaria implements Serializable {

    /**
     * Numero de conta do usuario
     */
    protected int nrConta;
    /**
     * Saldo do usuario
     */
    protected double saldo;
    /**
     * Historico do usuario
     */
    protected String historico;

    Datas_e_Horas dh;

    public ContaBancaria() {
    }

    public abstract double depositar(double valor);

    public abstract double sacar(double valor);

    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * Retorna as strings dos dados da conta do usuario
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nr. da Conta: " + nrConta + ", Saldo: " + saldo + ", Historico: " + historico;
    }

    /**
     * Transfere um dado valor para um destino informado vindo da conta dum
     * cliente logado
     *
     * @param valor
     * @param destino
     */
    Banco bc = new Banco();

    public void transferir(double valor, ContaBancaria destino) throws ClassNotFoundException {
        dh = new Datas_e_Horas();
        destino.depositar(valor);
        destino.setHistorico("*Tr+" + valor + ":" + dh.toString());
        this.sacar(valor);
        this.setHistorico("*Tr-" + valor + ":" + dh.toString());
        JOptionPane.showMessageDialog(null, "Transferido!");
    }
}

/** Este pacote contem classe comuns, siples.
 *
 */
package Classes_Comuns;

import Conexao.Conexao;
import Pacote1.ContaBancaria;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo possui um arraylist de contas bancárias e implemente os
 * métodos inserir, remover e procurarConta.
 */
public class Banco implements Serializable {

    /**
     * Todas contas criadas estarao aqui armazenadas
     *
     */
    public ArrayList<ContaBancaria> lista_de_Contas = new ArrayList<>();
     Conexao con = new Conexao();
    public String caminho = "Contas_Bancarias.txt";

    public Banco() {
    }

    public ArrayList<ContaBancaria> getLista_de_Contas() {
        lista_ARQ();
        return lista_de_Contas;
    }

    /**
     * Insere uma conta criada a lista.
     *
     * @param conta
     */
    public void inserir(ContaBancaria conta) {
        try {
            lista_de_Contas.add(conta);
            con.cmd_Salvar_Conta(caminho, conta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No banco(mtd-inserir), erro de gravacao no ficheiro");
        }
    }

    public void lista_ARQ() {
        try {
            lista_de_Contas = con.cmd_le_Contas(caminho);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BC-[mtd-lstARQ], Erro: " + e);
        }
    }


    /**
     * Remove uma conta da lista
     *
     * @param conta
     */
    public void remover(ContaBancaria conta) {
        if (conta != null) {
            try {
                lista_de_Contas.remove(conta);
                con.cmd_Salva_Conta_Actualizado(caminho,lista_de_Contas);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No banco(mtd-remover), erro de gravacao no ficheiro");
            }
        }
    }

    /**
     * Pesquisa por uma conta e a retorna. Caso nao exita, retorna vazio
     *
     * @param nrConta
     * @return
     */
    public ContaBancaria procurarConta(int nrConta) throws ClassNotFoundException {
        ContaBancaria conta = null;
        for (ContaBancaria ob : getLista_de_Contas()) {
            if (ob.getNrConta() == nrConta) {
                conta = ob;
                break;
            }
        }
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta nao encontra!");
        }
        return conta;
    }
}

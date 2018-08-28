/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import Pacote1.ContaBancaria;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo
 */
public class Conexao implements Serializable {

    List<ContaBancaria> lista_de_Contas = new ArrayList<>();

    /**
     *
     * @param caminho Este caminho indica a localizacao fisica do ficheiro no
     * disco.
     *
     * @param conta Eh o objeco da classe Modelo_Carro
     *
     * @throws ClassNotFoundException AJUDA NO LANCAMENTO DE ESCEPCOES Criar
     * ficheiro e salvaar
     */
    public void cmd_Salvar_Conta(String caminho, ContaBancaria conta)
            throws ClassNotFoundException {
        try {
            if (conta != null) {
                ObjectOutputStream oos;
                lista_de_Contas.add(conta);
                oos = new ObjectOutputStream(new FileOutputStream(caminho));
                oos.writeObject(lista_de_Contas);
                oos.close();
            } else {
                System.out.println("A conta a gravar nao deve ser nulo!");
            }
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "No cmd_Salvar_Conta_A: " + fnf);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "No cmd_Salvar_Conta_B: " + ioe);
        }
    }

    /**
     *
     * @param caminho
     * @return
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException
     *
     *
     */
    public ArrayList<ContaBancaria> cmd_le_Contas(String caminho)
            throws ClassNotFoundException, FileNotFoundException, IOException {
        ArrayList<ContaBancaria> lista = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho));
        lista_de_Contas = (ArrayList<ContaBancaria>) ois.readObject();
        int i = 0;
        try {
            for (ContaBancaria obj : lista_de_Contas) {
                lista.add(obj);
                i++;
            }

        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "No cmd_leitura_de_Contas: " + ioe);
        } finally {
            ois.close();
        }
        return lista;
    }

    /**
     *
     * @param caminho Este caminho indica a localizacao fisica do ficheiro no
     * disco
     *
     * @param lista
     *
     * @throws ClassNotFoundException
     */
    public void cmd_Salva_Conta_Actualizado(String caminho, List<ContaBancaria> lista) throws
            ClassNotFoundException {
        try {
            if (lista != null) {
                ObjectOutputStream oos;
                oos = new ObjectOutputStream(new FileOutputStream(caminho));
                oos.reset();
                oos.writeObject(lista);
                oos.close();
            } else {
                System.out.println("A conta a actualizar nao deve ser nulo!");
            }
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "Na classe conexao_A: " + fnf);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Na classe conexao_B: " + ioe);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import model.ModelProdutos;

/**
 *
 * @author Rafael Silva
 */
public class DaoProdutos extends ConexaoMySql {

    /**
     * Cadastrar um produto no Banco de Dados
     * @param pModelProdutos
     * @return 
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {

        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto ("
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProNome() + "',"
                    + "'" + pModelProdutos.getProValor() + "',"
                    + "'" + pModelProdutos.getProEstoque() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Excluir um produto do Banco de Dados
     * @param pIdProduto
     * @return boolean
     */
    public boolean excluirProduto(int pIdProduto) {

        try {

            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
    aula 08 12:04
    
}

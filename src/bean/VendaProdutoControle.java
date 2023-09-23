/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author art16
 */
public class VendaProdutoControle extends AbstractTableModel{
    
    private List lista;

    public void setList(List lista) {
    this.lista = lista;
    };
    
    public RccVendaProduto getBean(int linha) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (RccVendaProduto) lista.get(linha); //converte o object que o get retorna em um Venda_produto
    }

    @Override
    public int getRowCount() { //pegar quantidade de linhas
        return lista.size(); //quantas linhas tem na lista / bean / BD
    }

    @Override
    public int getColumnCount() { //pegar quantidade de colunas; o numero de colunas não se altera
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //pegar valor de => das células
        RccVendaProduto rccVendaProduto = (RccVendaProduto) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return rccVendaProduto.getRccFkProduto();
        }
        if (columnIndex == 1) {
            return rccVendaProduto.getRccQuantidade();
        }
        if (columnIndex == 2) {
            return rccVendaProduto.getRccValorUni();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Produto";
        }
        if (column == 1) {
            return "Quantidade";
        }
        if (column == 2) {
            return "Valor uni.";
        }
        
        return "";
    }
    
}

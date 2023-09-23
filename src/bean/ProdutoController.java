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
public class ProdutoController extends AbstractTableModel{ //modelo de tabela abstrato
    
    private List lista;

    public void setList(List lista) {
    this.lista = lista;
    this.fireTableDataChanged();
    };
    
    public RccProduto getBean(int linha) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (RccProduto) lista.get(linha); //converte o object que o get retorna em Usuario
    }

    @Override
    public int getRowCount() {
        return lista.size(); //quantas linhas tem na lista / bean / BD
    }

    @Override
    public int getColumnCount() {
        return 5;
   }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //pegar valor de => das células
        RccProduto rccProduto = (RccProduto) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return rccProduto.getRccIdProduto();
        }
        if (columnIndex == 1) {
            return rccProduto.getRccNomeProduto();
        }
        if (columnIndex == 2) {
            return rccProduto.getRccCategoria();
        }
        if (columnIndex == 3) {
            return rccProduto.getRccDescricao();
        }
        if (columnIndex == 4) {
            return rccProduto.getRccPreco();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Nome do Produto";
        }
        if (column == 2) {
            return "Categoria";
        }
        if (column == 3) {
            return "Descrição";
        }
        if (column == 4) {
            return "Preço";
        }
        
        return "";
    }
    
}

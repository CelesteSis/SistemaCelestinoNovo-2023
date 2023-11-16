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
public class VendaControle extends AbstractTableModel{
    
    private List lista;

    public void setList(List lista) {
    this.lista = lista;
    };
    
    public RccVenda getBean(int linha) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (RccVenda) lista.get(linha); //converte o object que o get retorna em Venda
    }

    @Override
    public int getRowCount() { //pegar quantidade de linhas
        return lista.size(); //quantas linhas tem na lista / bean / BD
    }

    @Override
    public int getColumnCount() { //pegar quantidade de colunas; o numero de colunas não se altera
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //pegar valor de => das células
        RccVenda rccVenda = (RccVenda) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return rccVenda.getRccIdVenda();
        }
        if (columnIndex == 1) {
            return rccVenda.getRccDataVenda();
        }
        if (columnIndex == 2) {
            return rccVenda.getRccValorTotal();
        }
        if (columnIndex == 3) {
            return rccVenda.getRccFkCliente();
        }
        if (columnIndex == 4) {
            return rccVenda.getRccFkVendedor();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Data Venda";
        }
        if (column == 2) {
            return "Valor Total";
        }
        if (column == 3) {
            return "Cliente";
        }
        if (column == 4) {
            return "Vendedor";
        }
        
        return "";
    }
    
}

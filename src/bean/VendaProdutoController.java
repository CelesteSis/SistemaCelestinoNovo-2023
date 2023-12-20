/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author art16
 */
public class VendaProdutoController extends AbstractTableModel{ //modelo de tabela abstrato
   
    
    List lista = new ArrayList();

    public void setList(List lista) {
    this.lista = lista;
    this.fireTableDataChanged();
    };
    
    public RccVendaProduto getBean(int index) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (RccVendaProduto) lista.get(index); //converte o object que o get retorna em Usuario
    }
    
    public void addBean(RccVendaProduto rccVendaProduto) {
        lista.add(rccVendaProduto);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int index) {
        lista.remove(index);
        this.fireTableDataChanged();
    }
    
    public void updateBean(int index, RccVendaProduto rccVendaProduto) {
        lista.set(index, rccVendaProduto);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size(); //quantas linhas tem na lista / bean / BD
    }

    @Override
    public int getColumnCount() {
        return 4;
   }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //pegar valor de => das células
        RccVendaProduto rccVendaProduto = (RccVendaProduto) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return rccVendaProduto.getRccIdVendaProduto();
        }
        if (columnIndex == 1) {
            return rccVendaProduto.getRccQuantidade();
        }
        if (columnIndex == 2) {
            return rccVendaProduto.getRccValorUni();
        }
        if (columnIndex == 3) {
            return rccVendaProduto.getRccQuantidade() * rccVendaProduto.getRccValorUni();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Quantidade";
        }
        if (column == 2) {
            return "Valor Uni.";
        }
        if (column == 3) {
            return "Valor Total";
        }
        
        return "";
    }
    
}

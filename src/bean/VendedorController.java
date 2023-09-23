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
public class VendedorController extends AbstractTableModel{ //modelo de tabela abstrato
    
    private List lista;

    public void setList(List lista) {
    this.lista = lista;
    this.fireTableDataChanged();
    };
    
    public RccVendedor getBean(int linha) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (RccVendedor) lista.get(linha); //converte o object que o get retorna em Usuario
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
        RccVendedor rccVendedor = (RccVendedor) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return rccVendedor.getRccIdVendedor();
        }
        if (columnIndex == 1) {
            return rccVendedor.getRccNome();
        }
        if (columnIndex == 2) {
            return rccVendedor.getRccSalario();
        }
        if (columnIndex == 3) {
            return rccVendedor.getRccEmail();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Salario";
        }
        if (column == 3) {
            return "E-mail";
        }
        
        return "";
    }
    
}

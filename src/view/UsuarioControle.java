/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;   
/**
 *
 * @author art16
 */
public class UsuarioControle extends AbstractTableModel{ //modelo de tabela abstrato
    
    private List lista;

    public void setList(List lista) {
    this.lista = lista;
    this.fireTableDataChanged();
    };
    
    public Usuario getBean(int linha) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (Usuario) lista.get(linha); //converte o object que o get retorna em Usuario
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
        Usuario usuario = (Usuario) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return usuario.getId_usuario();
        }
        if (columnIndex == 1) {
            return usuario.getNome();
        }
        if (columnIndex == 2) {
            return usuario.getApelido();
        }
        if (columnIndex == 3) {
            return usuario.getCpf();
        }
        if (columnIndex == 4) {
            return usuario.getNivel();
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
            return "Apelido";
        }
        if (column == 3) {
            return "Cpf";
        }
        if (column == 4) {
            return "Nivel";
        }
        
        return "";
    }
    
}

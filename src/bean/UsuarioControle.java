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
public class UsuarioControle extends AbstractTableModel{ //modelo de tabela abstrato
    
    private List lista;

    public void setList(List lista) {
    this.lista = lista;
    };
    
    public RccUsuario getBean(int linha) { //aciona o bean para saber a posição de acordo com a linha na lista
        return (RccUsuario) lista.get(linha); //converte o object que o get retorna em Usuario
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
        RccUsuario rccUsuario = (RccUsuario) lista.get(rowIndex); //quando fazer uma lista generica o polimosfismo volta o object
        if (columnIndex == 0) {
            return rccUsuario.getRccIdUsuario();
        }
        if (columnIndex == 1) {
            return rccUsuario.getRccNome();
        }
        if (columnIndex == 2) {
            return rccUsuario.getRccApelido();
        }
        if (columnIndex == 3) {
            return rccUsuario.getRccCpf();
        }
        if (columnIndex == 4) {
            return rccUsuario.getRccNivel();
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

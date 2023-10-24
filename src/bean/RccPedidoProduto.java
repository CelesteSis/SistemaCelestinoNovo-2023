/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author art16
 */
@Entity
@Table(name="rcc_pedido_produto"
    ,catalog="db_rebeca_celestino"
)
public class RccPedidoProduto implements java.io.Serializable{
    
    private int rccIdPedidoProduto;
     private int rccQuantidade;
     private double rccValorUni;
     private int rccFkPedido;
     private int rccFkProduto;
     
    public RccPedidoProduto() {
    }

    public RccPedidoProduto(int rccQuantidade, double rccValorUni, int rccFkPedido, int rccFkProduto) {
       this.rccQuantidade = rccQuantidade;
       this.rccValorUni = rccValorUni;
       this.rccFkPedido = rccFkPedido;
       this.rccFkProduto = rccFkProduto;
    }
    
    @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="rcc_id_venda_produto", unique=true, nullable=false)
    public int getRccIdPedidoProduto() {
        return this.rccIdPedidoProduto;
    }
    
    public void setRccIdPedidoProduto(int rccIdPedidoProduto) {
        this.rccIdPedidoProduto = rccIdPedidoProduto;
    }

    
    @Column(name="rcc_quantidade", nullable=false)
    public int getRccQuantidade() {
        return this.rccQuantidade;
    }
    
    public void setRccQuantidade(int rccQuantidade) {
        this.rccQuantidade = rccQuantidade;
    }

    
    @Column(name="rcc_valor_uni", nullable=false, precision=7)
    public double getRccValorUni() {
        return this.rccValorUni;
    }
    
    public void setRccValorUni(double rccValorUni) {
        this.rccValorUni = rccValorUni;
    }

    
    @Column(name="rcc_fk_venda", nullable=false)
    public int getRccFkPedido() {
        return this.rccFkPedido;
    }
    
    public void setRccFkPedido(int rccFkPedido) {
        this.rccFkPedido = rccFkPedido;
    }

    
    @Column(name="rcc_fk_produto", nullable=false)
    public int getRccFkProduto() {
        return this.rccFkProduto;
    }
    
    public void setRccFkProduto(int rccFkProduto) {
        this.rccFkProduto = rccFkProduto;
    }
    
}

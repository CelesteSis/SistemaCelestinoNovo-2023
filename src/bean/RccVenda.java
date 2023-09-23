package bean;
// Generated 19/09/2023 11:40:58 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RccVenda generated by hbm2java
 */
@Entity
@Table(name="rcc_venda"
    ,catalog="db_rebeca_celestino"
)
public class RccVenda  implements java.io.Serializable {


     private int rccIdVenda;
     private Date rccDataVenda;
     private double rccFrete;
     private double rccValorTotal;
     private String rccDescricaoItens;
     private int rccFkCliente;
     private int rccFkVendedor;

    public RccVenda() {
    }

    public RccVenda(Date rccDataVenda, double rccFrete, double rccValorTotal, String rccDescricaoItens, int rccFkCliente, int rccFkVendedor) {
       this.rccDataVenda = rccDataVenda;
       this.rccFrete = rccFrete;
       this.rccValorTotal = rccValorTotal;
       this.rccDescricaoItens = rccDescricaoItens;
       this.rccFkCliente = rccFkCliente;
       this.rccFkVendedor = rccFkVendedor;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="rcc_id_venda", unique=true, nullable=false)
    public int getRccIdVenda() {
        return this.rccIdVenda;
    }
    
    public void setRccIdVenda(int rccIdVenda) {
        this.rccIdVenda = rccIdVenda;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="rcc_data_venda", nullable=false, length=19)
    public Date getRccDataVenda() {
        return this.rccDataVenda;
    }
    
    public void setRccDataVenda(Date rccDataVenda) {
        this.rccDataVenda = rccDataVenda;
    }

    
    @Column(name="rcc_frete", nullable=false, precision=7)
    public double getRccFrete() {
        return this.rccFrete;
    }
    
    public void setRccFrete(double rccFrete) {
        this.rccFrete = rccFrete;
    }

    
    @Column(name="rcc_valor_total", nullable=false, precision=7)
    public double getRccValorTotal() {
        return this.rccValorTotal;
    }
    
    public void setRccValorTotal(double rccValorTotal) {
        this.rccValorTotal = rccValorTotal;
    }

    
    @Column(name="rcc_descricao_itens", nullable=false, length=200)
    public String getRccDescricaoItens() {
        return this.rccDescricaoItens;
    }
    
    public void setRccDescricaoItens(String rccDescricaoItens) {
        this.rccDescricaoItens = rccDescricaoItens;
    }

    
    @Column(name="rcc_fk_cliente", nullable=false)
    public int getRccFkCliente() {
        return this.rccFkCliente;
    }
    
    public void setRccFkCliente(int rccFkCliente) {
        this.rccFkCliente = rccFkCliente;
    }

    
    @Column(name="rcc_fk_vendedor", nullable=false)
    public int getRccFkVendedor() {
        return this.rccFkVendedor;
    }
    
    public void setRccFkVendedor(int rccFkVendedor) {
        this.rccFkVendedor = rccFkVendedor;
    }




}



package bean;
// Generated 20/12/2023 19:07:26 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RccProduto generated by hbm2java
 */
@Entity
@Table(name="rcc_produto"
    ,catalog="db_rebeca_celestino"
)
public class RccProduto  implements java.io.Serializable {


     private int rccIdProduto;
     private String rccNomeProduto;
     private Double rccPreco;
     private String rccTamanho;
     private String rccComprimento;
     private String rccLargura;
     private String rccTipoMaterial;
     private String rccDescricao;
     private String rccMarca;
     private String rccAno;
     private String rccCategoria;
     private String rccCor;

    public RccProduto() {
    }

	
    public RccProduto(String rccNomeProduto, Double rccPreco, String rccTamanho, String rccComprimento, String rccLargura, String rccTipoMaterial, String rccDescricao, String rccMarca, String rccAno, String rccCategoria, String rccCor) {
       this.rccNomeProduto = rccNomeProduto;
       this.rccPreco = rccPreco;
       this.rccTamanho = rccTamanho;
       this.rccComprimento = rccComprimento;
       this.rccLargura = rccLargura;
       this.rccTipoMaterial = rccTipoMaterial;
       this.rccDescricao = rccDescricao;
       this.rccMarca = rccMarca;
       this.rccAno = rccAno;
       this.rccCategoria = rccCategoria;
       this.rccCor = rccCor;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="rcc_id_produto", unique=true, nullable=false)
    public int getRccIdProduto() {
        return this.rccIdProduto;
    }
    
    public void setRccIdProduto(int rccIdProduto) {
        this.rccIdProduto = rccIdProduto;
    }

    
    @Column(name="rcc_nome_produto", nullable=false, length=60)
    public String getRccNomeProduto() {
        return this.rccNomeProduto;
    }
    
    public void setRccNomeProduto(String rccNomeProduto) {
        this.rccNomeProduto = rccNomeProduto;
    }

    
    @Column(name="rcc_preco", nullable=false, precision=7)
    public Double getRccPreco() {
        return this.rccPreco;
    }
    
    public void setRccPreco(Double rccPreco) {
        this.rccPreco = rccPreco;
    }

    
    @Column(name="rcc_tamanho", length=4)
    public String getRccTamanho() {
        return this.rccTamanho;
    }
    
    public void setRccTamanho(String rccTamanho) {
        this.rccTamanho = rccTamanho;
    }

    
    @Column(name="rcc_comprimento", length=10)
    public String getRccComprimento() {
        return this.rccComprimento;
    }
    
    public void setRccComprimento(String rccComprimento) {
        this.rccComprimento = rccComprimento;
    }

    
    @Column(name="rcc_largura", length=10)
    public String getRccLargura() {
        return this.rccLargura;
    }
    
    public void setRccLargura(String rccLargura) {
        this.rccLargura = rccLargura;
    }

    
    @Column(name="rcc_tipo_material", nullable=false, length=100)
    public String getRccTipoMaterial() {
        return this.rccTipoMaterial;
    }
    
    public void setRccTipoMaterial(String rccTipoMaterial) {
        this.rccTipoMaterial = rccTipoMaterial;
    }

    
    @Column(name="rcc_descricao", nullable=false, length=100)
    public String getRccDescricao() {
        return this.rccDescricao;
    }
    
    public void setRccDescricao(String rccDescricao) {
        this.rccDescricao = rccDescricao;
    }

    
    @Column(name="rcc_marca", nullable=false, length=30)
    public String getRccMarca() {
        return this.rccMarca;
    }
    
    public void setRccMarca(String rccMarca) {
        this.rccMarca = rccMarca;
    }

    
    @Column(name="rcc_ano", nullable=false, length=20)
    public String getRccAno() {
        return this.rccAno;
    }
    
    public void setRccAno(String rccAno) {
        this.rccAno = rccAno;
    }

    
    @Column(name="rcc_categoria", nullable=false, length=30)
    public String getRccCategoria() {
        return this.rccCategoria;
    }
    
    public void setRccCategoria(String rccCategoria) {
        this.rccCategoria = rccCategoria;
    }

    
    @Column(name="rcc_cor", length=30)
    public String getRccCor() {
        return this.rccCor;
    }
    
    public void setRccCor(String rccCor) {
        this.rccCor = rccCor;
    }

     @Override
    public String toString() {
        return getRccNomeProduto();
    }
    
     @Override
    public boolean equals(Object object) { //o equals recebe um object
        if (object instanceof RccProduto) { //esse object é um produto
            RccProduto rccProduto = (RccProduto) object; //esse produto é o mesmo do método beanView
            if (this.getRccIdProduto() == rccProduto.getRccIdProduto()) { //this => jCbo == produto => que esta sendo passado
                return true;
            }
        }
        return false;
    };


}



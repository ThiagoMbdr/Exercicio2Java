package Entidades;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq", allocationSize=1)
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_id")
	private Long id;
	
	private String nome;
	
	@Transient
	private int prioridade;
	
	@Embedded
	private Endereco endereco;
	
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}



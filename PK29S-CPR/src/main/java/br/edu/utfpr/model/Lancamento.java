package br.edu.utfpr.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate lancamento;
    private LocalDate vencimento;
    private Double valor;
    private TipoLancamento tipo;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Categoria categoria;

    public Lancamento() {
    }

    public Lancamento(Long id, String descricao, LocalDate lancamento, LocalDate vencimento, Double valor, TipoLancamento tipo, Usuario usuario, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.lancamento = lancamento;
        this.vencimento = vencimento;
        this.valor = valor;
        this.tipo = tipo;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Lancamento{" + "id=" + id + ", descricao=" + descricao + ", lancamento=" + lancamento + ", vencimento=" + vencimento + ", valor=" + valor + ", tipo=" + tipo + ", usuario=" + usuario + ", categoria=" + categoria + '}';
    }
}
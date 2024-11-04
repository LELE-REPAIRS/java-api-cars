package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class TiposServicoTO {
    private Long idServico;
    @NotNull
    private String tpServico;
    @NotNull private String dsServico;
    @NotNull private Double vlPreco;

    public TiposServicoTO() {
    }

    public TiposServicoTO(Long idServico, @NotNull String tpServico, @NotNull String dsServico, @NotNull Double vlPreco) {
        this.idServico = idServico;
        this.tpServico = tpServico;
        this.dsServico = dsServico;
        this.vlPreco = vlPreco;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public @NotNull String getTpServico() {
        return tpServico;
    }

    public void setTpServico(@NotNull String tpServico) {
        this.tpServico = tpServico;
    }

    public @NotNull String getDsServico() {
        return dsServico;
    }

    public void setDsServico(@NotNull String dsServico) {
        this.dsServico = dsServico;
    }

    public @NotNull Double getVlPreco() {
        return vlPreco;
    }

    public void setVlPreco(@NotNull Double vlPreco) {
        this.vlPreco = vlPreco;
    }
}

package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class OficinaTO {
    private Long idOficina;
    @NotNull private String nmOficina;
    @NotNull private Long nmCnpj;
    @NotNull private int nrDeMcanicos;

    public OficinaTO() {
    }

    public OficinaTO(Long idOficina, @NotNull String nmOficina, @NotNull Long nmCnpj, @NotNull int nrDeMcanicos) {
        this.idOficina = idOficina;
        this.nmOficina = nmOficina;
        this.nmCnpj = nmCnpj;
        this.nrDeMcanicos = nrDeMcanicos;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }

    public @NotNull String getNmOficina() {
        return nmOficina;
    }

    public void setNmOficina(@NotNull String nmOficina) {
        this.nmOficina = nmOficina;
    }

    public @NotNull Long getNmCnpj() {
        return nmCnpj;
    }

    public void setNmCnpj(@NotNull Long nmCnpj) {
        this.nmCnpj = nmCnpj;
    }

    @NotNull
    public int getNrDeMcanicos() {
        return nrDeMcanicos;
    }

    public void setNrDeMcanicos(@NotNull int nrDeMcanicos) {
        this.nrDeMcanicos = nrDeMcanicos;
    }
}

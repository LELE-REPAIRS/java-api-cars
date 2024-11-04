package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ClienteTO {
    private long idCliente;
    @NotNull private String nmCliente;
    @NotNull private long nrCpf;
    @NotNull private String txEmail;
    @NotNull private String txSenha;

    public ClienteTO() {
    }

    public ClienteTO(@NotNull String txSenha, @NotNull String txEmail, @NotNull long nrCpf, @NotNull String nmCliente,long idCliente) {
        this.txSenha = txSenha;
        this.txEmail = txEmail;
        this.nrCpf = nrCpf;
        this.nmCliente = nmCliente;
        this.idCliente = idCliente;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente( long idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(@NotNull String nmCliente) {
        this.nmCliente = nmCliente;
    }

    @NotNull
    public long getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(@NotNull long nrCpf) {
        this.nrCpf = nrCpf;
    }

    public @NotNull String getTxEmail() {
        return txEmail;
    }

    public void setTxEmail(@NotNull String txEmail) {
        this.txEmail = txEmail;
    }

    public @NotNull String getTxSenha() {
        return txSenha;
    }

    public void setTxSenha(@NotNull String txSenha) {
        this.txSenha = txSenha;
    }
}

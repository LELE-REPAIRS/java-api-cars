package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CarroTO {
    private Long idCarro;
    @NotNull private Long kmRodado;
    @NotNull
    private LocalDate ano;
    @NotNull private String marca;
    @NotNull private String modelo;
    @NotNull private String placa;

    public CarroTO() {
    }

    public CarroTO(Long idCarro, @NotNull Long kmRodado, @NotNull LocalDate ano, @NotNull String marca, @NotNull String modelo, @NotNull String placa) {
        this.idCarro = idCarro;
        this.kmRodado = kmRodado;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull Long getKmRodado() {
        return kmRodado;
    }

    public void setKmRodado(@NotNull Long kmRodado) {
        this.kmRodado = kmRodado;
    }

    public @NotNull LocalDate getAno() {
        return ano;
    }

    public void setAno(@NotNull LocalDate ano) {
        this.ano = ano;
    }

    public @NotNull String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull String marca) {
        this.marca = marca;
    }

    public @NotNull String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull String modelo) {
        this.modelo = modelo;
    }

    public @NotNull String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotNull String placa) {
        this.placa = placa;
    }
}

package com.lab.entity.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Nota {
    private Double valor;

    public Nota (Double valor) {
        this.validateValor(valor);
        this.valor=valor;

    }

    public void setValor(Double valor){
        this.validateValor(valor);
        this.valor=valor;
    }

    public Boolean disponible(){
        return valor==null;
    }

    private void validateValor(Double valor){
        if (valor != null && (valor < 0 || valor > 10)) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
    }

}

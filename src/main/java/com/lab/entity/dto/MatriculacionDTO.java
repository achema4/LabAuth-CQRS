package com.lab.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculacionDTO {

    private String id;
    private String nombre;
    private int creditos;
    private NotaDTO nota;
}

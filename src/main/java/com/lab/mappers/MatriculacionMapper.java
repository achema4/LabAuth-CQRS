package com.lab.mappers;

import com.lab.entity.dominio.Matriculacion;
import com.lab.entity.dominio.Nota;
import com.lab.entity.dto.MatriculacionDTO;
import com.lab.write.entity.MatriculacionEntity;
import com.lab.write.entity.StudentEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculacionMapper {

    public Matriculacion dtoToDomain(MatriculacionDTO dto) {

        if (dto == null) {
            return null;
        }

        Nota nota = null;

        if (dto.getNota() != null) {
            nota = new Nota((double) dto.getNota().getValor());
        }

        return new Matriculacion(
                dto.getId(),
                dto.getNombre(),
                dto.getCreditos(),
                nota
        );
    }


    public MatriculacionEntity domainToEntity(
            Matriculacion matriculacion,
            StudentEntity studentEntity) {

        if (matriculacion == null) {
            return null;
        }

        Double nota = null;

        if (matriculacion.getNota() != null) {
            nota = matriculacion.getNota().getValor();
        }


        return new MatriculacionEntity(
                matriculacion.getNombre(),
                matriculacion.getCreditos(),
                studentEntity,
                nota
        );
    }
}
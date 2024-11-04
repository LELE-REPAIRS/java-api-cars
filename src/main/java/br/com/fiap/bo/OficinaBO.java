package br.com.fiap.bo;

import br.com.fiap.dao.OficinaDAO;
import br.com.fiap.to.OficinaTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class OficinaBO {
    private OficinaDAO oficinaDAO;
    public ArrayList<OficinaTO> findAll(){
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.findAll();
    }

    public OficinaTO findByCodigo(Long idOficina){
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócio
        return oficinaDAO.findByCodigo(idOficina);
    }

    public OficinaTO save(OficinaTO oficina){
        oficinaDAO = new OficinaDAO();
        // Validação de CNPJ
        if (oficina.getNmCnpj() == 14) {
            throw new IllegalArgumentException("CNPJ inválido, deve conter 14 dígitos.");
        }

        // Validação do número de mecânicos
        if (oficina.getNrDeMcanicos() < 0) {
            throw new IllegalArgumentException("O número de mecânicos não pode ser negativo.");
        }
        return oficinaDAO.save(oficina);
    }

    public boolean delete(Long idOficina) {
        oficinaDAO = new OficinaDAO();
        // aqui se implementa a regra de negócios
        return oficinaDAO.delete(idOficina);
    }

    public OficinaTO update(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        //aqui se implementa as regras de negocio
        return oficinaDAO.update(oficina);

    }
}

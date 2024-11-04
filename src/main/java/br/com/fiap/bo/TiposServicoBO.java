package br.com.fiap.bo;

import br.com.fiap.dao.TiposServicoDAO;
import br.com.fiap.to.TiposServicoTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class TiposServicoBO {
    private TiposServicoDAO tiposServicoDAO;
    public ArrayList<TiposServicoTO> findAll(){
        tiposServicoDAO = new TiposServicoDAO();
        // aqui se implementa a regra de negócios
        return tiposServicoDAO.findAll();
    }

    public TiposServicoTO findByCodigo(Long idServico){
        tiposServicoDAO = new TiposServicoDAO();
        // aqui se implementa a regra de negócio
        return tiposServicoDAO.findByCodigo(idServico);
    }

    public TiposServicoTO save(TiposServicoTO tiposServico){
        tiposServicoDAO = new TiposServicoDAO();
        // Validação do preço
        if (tiposServico.getVlPreco() == null || tiposServico.getVlPreco() < 0) {
            throw new IllegalArgumentException("O preço do serviço deve ser positivo.");
        }
        return tiposServicoDAO.save(tiposServico);
    }

    public boolean delete(Long idServico) {
        tiposServicoDAO = new TiposServicoDAO();
        // aqui se implementa a regra de negócios
        return tiposServicoDAO.delete(idServico);
    }

    public TiposServicoTO update(TiposServicoTO tiposServico) {
        tiposServicoDAO = new TiposServicoDAO();
        //aqui se implementa as regras de negocio
        return tiposServicoDAO.update(tiposServico);

    }
}

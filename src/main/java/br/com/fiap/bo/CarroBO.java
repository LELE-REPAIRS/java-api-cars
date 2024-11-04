package br.com.fiap.bo;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class CarroBO {
    private CarroDAO carroDAO;
    public ArrayList<CarroTO> findAll(){
        carroDAO = new CarroDAO();
        // aqui se implementa a regra de negócios
        return carroDAO.findAll();
    }

    public CarroTO findByCodigo(Long idCarro){
        carroDAO = new CarroDAO();
        // aqui se implementa a regra de negócio
        return carroDAO.findByCodigo(idCarro);
    }

    public CarroTO save(CarroTO carro){
        carroDAO = new CarroDAO();
        // Validação de ano
        if (carro.getAno().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("O ano do carro não pode ser uma data futura.");
        }

        // Validação de quilometragem
        if (carro.getKmRodado() < 0) {
            throw new IllegalArgumentException("A quilometragem não pode ser negativa.");
        }

        return carroDAO.save(carro);
    }

    public boolean delete(Long idCarro) {
        carroDAO = new CarroDAO();
        // aqui se implementa a regra de negócios
        return carroDAO.delete(idCarro);
    }

    public CarroTO update(CarroTO carro) {
        carroDAO = new CarroDAO();
        //aqui se implementa as regras de negocio
        return carroDAO.update(carro);

    }
}

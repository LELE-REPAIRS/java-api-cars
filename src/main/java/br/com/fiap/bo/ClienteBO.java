package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteBO {
    private ClienteDAO clienteDAO;
    public ArrayList<ClienteTO> findAll(){
        clienteDAO = new ClienteDAO();
        // aqui se implementa a regra de negócios
        return clienteDAO.findAll();
    }

    public ClienteTO findByCodigo(Long idCliente){
        clienteDAO = new ClienteDAO();
        // aqui se implementa a regra de negócio
        return clienteDAO.findByCodigo(idCliente);
    }

    public ClienteTO findByEmail(String txEmail) {
        clienteDAO = new ClienteDAO();
        // Aqui se implementa a regra de negócio
        return clienteDAO.findByEmail(txEmail);
    }

    public ClienteTO save(ClienteTO cliente){
        clienteDAO = new ClienteDAO();
        // Validação do CPF
        if (cliente.getNrCpf() == 11) {
            throw new IllegalArgumentException("CPF inválido, deve conter 11 dígitos.");
        }

        // Verificar se o CPF já existe
        if (clienteDAO.findByCodigo(cliente.getNrCpf()) != null) {
            throw new IllegalArgumentException("Já existe um cliente com esse CPF.");
        }

        return clienteDAO.save(cliente);
    }

    public boolean delete(Long idCliente) {
        clienteDAO = new ClienteDAO();
        // aqui se implementa a regra de negócios
        return clienteDAO.delete(idCliente);
    }

    public ClienteTO update(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        //aqui se implementa as regras de negocio
        return clienteDAO.update(cliente);

    }
}

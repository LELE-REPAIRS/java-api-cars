package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends Repository {
    public ArrayList<ClienteTO> findAll(){
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "select * from T_LELE_CLIENTE order by id_cliente";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    ClienteTO cliente = new ClienteTO();
                    cliente.setIdCliente(rs.getLong("id_cliente"));
                    cliente.setNmCliente(rs.getString("nm_cliente"));
                    cliente.setNrCpf(rs.getLong("nr_cpf"));
                    cliente.setTxEmail(rs.getString("tx_email"));
                    cliente.setTxSenha(rs.getString("tx_senha"));
                    clientes.add(cliente);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return clientes;


    }

    public ClienteTO findByCodigo (Long idCliente){
        ClienteTO cliente = new ClienteTO();
        String sql = "SELECT * from T_LELE_CLIENTE where id_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idCliente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente.setNmCliente(rs.getString("nm_cliente"));
                cliente.setNrCpf(rs.getLong("nr_cpf"));
                cliente.setTxEmail(rs.getString("tx_email"));
                cliente.setTxSenha(rs.getString("tx_senha"));
            }else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return cliente;
    }

    public ClienteTO save(ClienteTO cliente){
        String sql = "insert into T_LELE_CLIENTE(nm_cliente,nr_cpf,tx_email,tx_senha) values (?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getNmCliente());
            ps.setLong(2,cliente.getNrCpf());
            ps.setString(3, cliente.getTxEmail());
            ps.setString(4, cliente.getTxSenha());
            if (ps.executeUpdate() > 0){
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idCliente) {
        String sql = "delete from T_LELE_CLIENTE where id_cliente = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public ClienteTO update(ClienteTO cliente) {
        String sql = "update T_LELE_CLIENTE set nm_cliente=?, nr_cpf=?, tx_email=?, tx_senha=? where id_cliente=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getNmCliente());
            ps.setLong(2,cliente.getNrCpf());
            ps.setString(4, cliente.getTxEmail());
            ps.setString(5, cliente.getTxSenha());
            ps.setLong(6, cliente.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}

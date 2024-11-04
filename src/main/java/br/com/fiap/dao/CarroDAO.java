package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository{
    public ArrayList<CarroTO> findAll(){
        ArrayList<CarroTO> carros = new ArrayList<CarroTO>();
        String sql = "select * from T_LELE_CARRO order by id_carro";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    CarroTO carro = new CarroTO();
                    carro.setIdCliente(rs.getLong("T_LELE_CLIENTE_ID_CLIENTE"));
                    carro.setIdCarro(rs.getLong("id_carro"));
                    carro.setKmRodado(rs.getLong("km_rodado"));
                    carro.setAno(rs.getDate("ano").toLocalDate());
                    carro.setMarca(rs.getString("marca"));
                    carro.setModelo(rs.getString("modelo"));
                    carro.setPlaca(rs.getString("placa"));
                    carros.add(carro);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return carros;


    }

    public CarroTO findByCodigo (Long idCarro){
        CarroTO carro = new CarroTO();
        String sql = "SELECT * from T_LELE_CARRO where id_carro = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idCarro);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                carro.setIdCliente(rs.getLong("T_LELE_CLIENTE_ID_CLIENTE"));
                carro.setKmRodado(rs.getLong("km_rodado"));
                carro.setAno(rs.getDate("ano").toLocalDate());
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPlaca(rs.getString("placa"));
            }else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return carro;
    }

    public CarroTO findByCodigoCliente(Long idCliente){
        CarroTO carro = new CarroTO();
        String sql = "SELECT * from T_LELE_CARRO where T_LELE_CLIENTE_ID_CLIENTE = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idCliente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                carro.setIdCarro(rs.getLong("id_carro"));
                carro.setKmRodado(rs.getLong("km_rodado"));
                carro.setAno(rs.getDate("ano").toLocalDate());
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPlaca(rs.getString("placa"));
            }else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return carro;
    }

    public CarroTO save(CarroTO carro){
        String sql = "insert into T_LELE_CARRO(T_LELE_CLIENTE_ID_CLIENTE, km_rodado,ano,marca,modelo,placa) values (?,?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, carro.getIdCliente());
            ps.setLong(2, carro.getKmRodado());
            ps.setDate(3,Date.valueOf(carro.getAno()));
            ps.setString(4, carro.getMarca());
            ps.setString(5, carro.getModelo());
            ps.setString(6, carro.getPlaca());
            if (ps.executeUpdate() > 0){
                return carro;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idCarro) {
        String sql = "delete from T_LELE_CARRO where id_carro = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idCarro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public CarroTO update(CarroTO carro) {
        String sql = "update T_LELE_CARRO set km_rodado=?, ano=?, marca=?, modelo=?, placa=? where id_carro=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, carro.getKmRodado());
            ps.setDate(2,Date.valueOf(carro.getAno()));
            ps.setString(3, carro.getMarca());
            ps.setString(4, carro.getModelo());
            ps.setString(5, carro.getPlaca());
            ps.setLong(6, carro.getIdCarro());
            if (ps.executeUpdate() > 0) {
                return carro;
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

package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository {
    public ArrayList<OficinaTO> findAll(){
        ArrayList<OficinaTO> oficinas = new ArrayList<OficinaTO>();
        String sql = "select * from T_LELE_OFICINA order by id_oficina";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    OficinaTO oficina = new OficinaTO();
                    oficina.setIdOficina(rs.getLong("id_oficina"));
                    oficina.setNmOficina(rs.getString("nm_oficina"));
                    oficina.setNmCnpj(rs.getLong("nm_cnpj"));
                    oficina.setNrDeMcanicos(rs.getInt("nr_de_mecanicos"));
                    oficinas.add(oficina);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return oficinas;


    }

    public OficinaTO findByCodigo (Long idOficina){
        OficinaTO oficina = new OficinaTO();
        String sql = "SELECT * from T_LELE_OFICINA where id_oficina = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idOficina);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                oficina.setIdOficina(rs.getLong("id_oficina"));
                oficina.setNmOficina(rs.getString("nm_oficina"));
                oficina.setNmCnpj(rs.getLong("nm_cnpj"));
                oficina.setNrDeMcanicos(rs.getInt("nr_de_mecanicos"));
            }else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return oficina;
    }

    public OficinaTO save(OficinaTO oficina){
        String sql = "insert into T_LELE_OFICINA(nm_oficina,nm_cnpj,nr_de_mecanicos) values (?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, oficina.getNmOficina());
            ps.setLong(2,oficina.getNmCnpj());
            ps.setInt(3,oficina.getNrDeMcanicos());
            if (ps.executeUpdate() > 0){
                return oficina;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idOficina) {
        String sql = "delete from T_LELE_OFICINA where id_oficina = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idOficina);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public OficinaTO update(OficinaTO oficina) {
        String sql = "update T_LELE_OFICINA set nm_oficina=?, nm_cnpj=?, nr_de_mecanicos=? where id_oficina=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNmOficina());
            ps.setLong(2,oficina.getNmCnpj());
            ps.setInt(3,oficina.getNrDeMcanicos());
            ps.setLong(4, oficina.getIdOficina());
            if (ps.executeUpdate() > 0) {
                return oficina;
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

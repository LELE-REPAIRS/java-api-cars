package br.com.fiap.dao;

import br.com.fiap.to.TiposServicoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TiposServicoDAO extends Repository{
    public ArrayList<TiposServicoTO> findAll(){
        ArrayList<TiposServicoTO> tiposServicos = new ArrayList<TiposServicoTO>();
        String sql = "select * from T_LELE_TIPOS_SERVICOS order by id_servico";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    TiposServicoTO tiposServico = new TiposServicoTO();
                    tiposServico.setIdServico(rs.getLong("id_servico"));
                    tiposServico.setTpServico(rs.getString("tp_servico"));
                    tiposServico.setDsServico(rs.getString("ds_servico"));
                    tiposServico.setVlPreco(rs.getDouble("vl_preco"));
                    tiposServicos.add(tiposServico);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return tiposServicos;


    }

    public TiposServicoTO findByCodigo (Long codigo){
        TiposServicoTO tiposServico = new TiposServicoTO();
        String sql = "SELECT * from T_LEL_TIPOS_SERVICOS where id_servico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tiposServico.setIdServico(rs.getLong("id_servico"));
                tiposServico.setTpServico(rs.getString("tp_servico"));
                tiposServico.setDsServico(rs.getString("ds_servico"));
                tiposServico.setVlPreco(rs.getDouble("vl_preco"));
            }else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return tiposServico;
    }

    public TiposServicoTO save(TiposServicoTO tiposServico){
        String sql = "insert into T_LELE_TIPOS_SERVICOS(tp_servico,ds_servico,vl_preco) values (?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, tiposServico.getTpServico());
            ps.setString(2,tiposServico.getDsServico());
            ps.setDouble(3,tiposServico.getVlPreco());
            if (ps.executeUpdate() > 0){
                return tiposServico;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql:" + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idServico) {
        String sql = "delete from T_LELE_TIPOS_SERVICOS where id_servico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idServico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public TiposServicoTO update(TiposServicoTO tiposServico) {
        String sql = "update T_LELE_TIPOS_SERVICOS set tp_servico=?, ds_servico=?, vl_servico=? where id_srvico=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, tiposServico.getTpServico());
            ps.setString(2,tiposServico.getDsServico());
            ps.setDouble(3,tiposServico.getVlPreco());
            ps.setLong(4, tiposServico.getIdServico());
            if (ps.executeUpdate() > 0) {
                return tiposServico;
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

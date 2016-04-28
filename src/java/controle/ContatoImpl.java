package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ContatoDao;
import dao.ConnectionFactory;
import modelo.Contato;

public class ContatoImpl implements ContatoDao {
	
	Connection conn = ConnectionFactory.getConnection();
	PreparedStatement stmt;
	ResultSet rs;

	@Override
	public void salvar(Contato contato) {
		try {
			String sql = "insert into contato (nome, telefone) values(?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
                        stmt.setString(2, contato.getTelefone());
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Contato autor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Contato autor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contato> getListAll() {
		List<Contato> list = new ArrayList<Contato>();
		try {
			String sql = "select id, nome, telefone from contato";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(notNull(rs.getString("nome")));
                                contato.setTelefone(notNull(rs.getString("telefone")));
				
				list.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Contato findById(int id) {
		String sql = "select id, nome, telefone from contato where id = ?";
                Contato contato = new Contato();
                try{
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, id);
                    rs = stmt.executeQuery();
                    rs.next();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(notNull(rs.getString("nome")));
                    contato.setTelefone(notNull(rs.getString("telefone")));
                }catch (SQLException e) {
			e.printStackTrace();
		}
		return contato;
	}
        
        private String notNull(String v){
            if(v == null)
                return "";
            return v;
        }

}

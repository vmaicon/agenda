package dao;

import java.util.List;

import modelo.Contato;

public interface ContatoDao {
	
	public void salvar(Contato autor);
	public void atualizar(Contato autor);
	public void remover(Contato autor);
	public List<Contato> getListAll();
	public Contato findById(int id);

}

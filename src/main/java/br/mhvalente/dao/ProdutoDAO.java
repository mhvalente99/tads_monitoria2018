package br.mhvalente.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.hibernate.Session;

import br.mhvalente.domain.Produto;

public class ProdutoDAO {
	private EntityManager em;
	private Session session;
	
	public ProdutoDAO() {
		em = Conexao.getConnection();
		session = em.unwrap(Session.class);
	}
	
	public Produto setProduto(Produto produto) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		
		transacao.begin();
		
		try {
			produto = em.merge(produto);
			transacao.commit();
			
			return produto;
		} catch (Exception e) {
			transacao.rollback();
			throw e;
		}
	}
}

package br.mhvalente.monitoria_maven;

import java.util.Date;

import javax.swing.JOptionPane;

import br.mhvalente.dao.ProdutoDAO;
import br.mhvalente.domain.Produto;

public class App 
{
    public static void main( String[] args )
    {
    		Produto p1 = new Produto();
    		p1.setDescricao("Cabo de Vassoura");
    		p1.setData(new Date());
    		p1.setValor(15.50);
    		
    		ProdutoDAO daoProduto = new ProdutoDAO();
    		
    		try {
				p1 = daoProduto.setProduto(p1);
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso ! Codigo : " + p1.getCodigo());
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto .." + e.getMessage());
			}
    }
}

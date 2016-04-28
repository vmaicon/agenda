package dao;

import controle.ContatoImpl;
import java.util.List;
import java.util.Scanner;

import modelo.Contato;

public class Main {

	public static void main(String[] args) {
                ContatoImpl contatoImpl = new ContatoImpl();
		List<Contato> list = contatoImpl.getListAll();
                Scanner in = new Scanner(System.in);
                for (int i = 0; i < 3; i++) {
                    Contato c = new Contato();
                    System.out.print("Nome: ");
                    c.setNome(in.next());
                    
                    System.out.print("Telefone: ");
                    c.setTelefone(in.next());
                    
                    contatoImpl.salvar(c);
                }
                
		String msg = ("ID\t"+f("Nome")+"\t"+f("Telefone"));
		System.out.println(msg);
		for (int i = 0; i < msg.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
		out(list);
		
                System.out.print("Escolha um id para pesquisa: ");
		Contato a = contatoImpl.findById(in.nextInt());
		
		System.out.println("\n"+msg);
		for (int i = 0; i < msg.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(a.getId()+"\t"+f(a.getNome()));
	}

	private static String f(String s) {
			for (int i = s.length(); i < 30; i++) {
				s+=" ";
			}
		return s;
	}

	private static void out(List<Contato> list) {
		for (Contato autor : list) {
			System.out.println(autor.getId()+"\t"+f(autor.getNome())+"\t"+autor.getTelefone());
		}
		
	}

}









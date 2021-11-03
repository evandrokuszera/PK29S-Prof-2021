/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author evand
 */
public class TestePU {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PK29S-PU");
        EntityManager em = emf.createEntityManager();
        
        //inserirUsuario(em);
        //buscarUsuario(em, 1L);
        //alterarUsuario(em, 1L);
        //removerUsuario(em, 1L);
        //buscarUsuario(em, 1L);
        
        //inserirCategoria(em);
        
        inserirLancamento(em);
        
        em.close();
        emf.close();
    }
    
    private static void inserirLancamento(EntityManager em){
        Usuario user2 = new Usuario(2L, null, null, null, true);
        Categoria cat1 = new Categoria(1L, null, null);
        Lancamento lanc1 = new Lancamento(null, "Colégio", LocalDate.now(), LocalDate.now(), 1200.00, TipoLancamento.PAGAR, user2, cat1);
        em.getTransaction().begin();
        em.persist(lanc1);
        em.getTransaction().commit();
    }
    
    private static void inserirCategoria(EntityManager em){
        Usuario user2 = new Usuario(2L, null, null, null, true);
        Categoria cat1 = new Categoria(null, "Educação", user2);
        em.getTransaction().begin();
        em.persist(cat1);
        em.getTransaction().commit();
    }
    
    private static void inserirUsuario(EntityManager em){
        Usuario user1 = new Usuario(null, "Administrador", "admin", "admin", true);
        
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();
    }
    
    private static void alterarUsuario(EntityManager em, Long id){
        Usuario user1 = em.find(Usuario.class, id);
        if (user1 != null){
            user1.setNome("Administrador do Sistema");
            em.getTransaction().begin();
            em.merge(user1);
            em.getTransaction().commit();
        }
    }
    
    private static void removerUsuario(EntityManager em, Long id){
        Usuario user1 = em.find(Usuario.class, id);
        if (user1 != null){
            em.getTransaction().begin();
            em.remove(user1);
            em.getTransaction().commit();
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }
    
    private static void buscarUsuario(EntityManager em, Long id){
        Usuario user1 = em.find(Usuario.class, id);
        if (user1 != null){
            System.out.println(user1);
        }
    }
}

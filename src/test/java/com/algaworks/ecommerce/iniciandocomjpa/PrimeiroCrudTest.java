// CRUD - Create Read Update Delete

package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro() {
        Cliente cliente = new Cliente();

       // cliente.setId(3); Comentado porque estamos utilizando IDENTITY
        cliente.setNome("José Lucas");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setCpf("333");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void buscarRegistro() {
        Cliente clienteVerificacao = entityManager.find(Cliente.class, 15);

        Assert.assertNotNull(clienteVerificacao);
        Assert.assertEquals("Sirlene Gonçalves", clienteVerificacao.getNome());
    }

    @Test
    public void atualizarRegistro() {
        Cliente cliente = new Cliente();

        cliente.setId(1);
        cliente.setNome( "Fernando Medeiros Silva");
        cliente.setCpf("000");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals("Fernando Medeiros Silva", clienteVerificacao.getNome());
    }

    @Test
    public void removerRegistro() {
        Cliente cliente = new Cliente();
       // cliente.setId(3);

        Cliente cliente1 = entityManager.find(Cliente.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente1);
        entityManager.getTransaction().commit();

        // Obs: entityManager remove da Base de Dados e da Memória...
        // entityManager.clear(); Não é necessário na asserção para
        // operação de remoção.

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 3);
        Assert.assertNull(clienteVerificacao);
    }
}

//      @Test
//       public void atualizarRegistro() {
//        Cliente cliente = entityManager.find(Cliente.class, 15);
//
//        entityManager.getTransaction().begin();
//        cliente.setNome("Sirlene Gonçalves");
//        entityManager.getTransaction().commit();
//
//        entityManager.clear();
//
//        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
//        Assert.assertEquals("Sirlene Gonçalves", clienteVerificacao.getNome());
// }


package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Atributo;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ElementCollectionTest extends EntityManagerTest {

    @Test
    public void aplicarTags(){
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setTags(Arrays.asList("ebook", "Notebook Dell"));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertFalse(produtoVerficacao.getTags().isEmpty());
    }

    @Test
    public void aplicarAtriburos(){
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setAtributos(Arrays.asList(new Atributo("tela","320x600")));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertFalse(produtoVerficacao.getAtributos().isEmpty());
    }

    @Test
    public void aplicarContato(){
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 1);
        cliente.setContatos(Collections.singletonMap("email", "fernando@email.com"));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerficacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals(
                "fernando@email.com", clienteVerficacao.getContatos().get("email"));
    }
}

package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContextoDePersistenciaTest extends EntityManagerTest {

    @Test
    public void usarContextoPersistencia() {
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setPreco(new BigDecimal(100.0));

        Produto produto2 = new Produto();
        produto2.setDataCriacao(LocalDateTime.now());
        produto2.setNome("Caneca para café");
        produto2.setPreco(new BigDecimal(10.0));
        produto2.setDescricao("Boa caneca para café");
        entityManager.persist(produto2);

        Produto produto3 = new Produto();
        produto3.setDataCriacao(LocalDateTime.now());
        produto3.setNome("Caneca para chá");
        produto3.setPreco(new BigDecimal(10.0));
        produto3.setDescricao("Boa caneca para chá");
        entityManager.persist(produto3);

        Produto produto4 = new Produto();
        produto4.setDataCriacao(LocalDateTime.now());
        produto4.setNome("garrafa Térmica de café");
        produto4.setPreco(new BigDecimal(50.0));
        produto4.setDescricao("Aço Inox");
        entityManager.persist(produto4);

        entityManager.flush();

        produto4.setDescricao(("Alterar descrição"));

        entityManager.getTransaction().commit();
    }
}

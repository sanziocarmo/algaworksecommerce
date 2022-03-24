package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void impedirOperacaoComBancoDeDados() {
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto); //Obs: Método DETACH desanexa uma instância que está na
        //memória do entityManager ou seja o mesmo impede que a operação com o Banco de Dados ocorra...

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());
    }

    @Test
    public void mostrarDiferencaPersistMerge() {
        Produto produtoPersist = new Produto();

 //     produtoPersist.setId(13); Comentado porque estamos utilizando IDENTITY
        produtoPersist.setNome("Smartphone S21 One Plus");
        produtoPersist.setDescricao("O mais atual.");
        produtoPersist.setPreco(new BigDecimal(2000));
        produtoPersist.setDataCriacao(LocalDateTime.now());


        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);   //OBS: persist só serve para persistir
        produtoPersist.setNome("Smartphone S21 One Plus");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);

        Produto produtoMerge = new Produto();

//      produtoMerge.setId(6);
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O melhor da categoria.");
        produtoMerge.setPreco(new BigDecimal(2000));
        produtoMerge.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        produtoMerge = entityManager.merge(produtoMerge);   // OBS: O Método persist serve apenas para persistir
        produtoMerge.setNome("Notebook Dell 2");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);
    }

    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();

        produto.setId(4);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A melhor qualidade de som.");
        produto.setPreco(new BigDecimal(1000));
        produto.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        Produto produtoSalvo = entityManager.merge(produto);   //OBS: O método MERGE pode ser usado tanto para inserir quanto para atualizar
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void inserirObjetoComMerge2() {
        Produto produto = new Produto();

        produto.setId(12);
        produto.setNome("Air Fryer Eletrolux");
        produto.setDescricao("A mais indicada.");
        produto.setPreco(new BigDecimal(1600.22));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle Paperwhite 2ª Geração", produtoVerificacao.getNome());
    }

    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("kindle Paperwhite");
        produto.setDescricao("Conheça o novo Kindle");
        produto.setPreco(new BigDecimal(599));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    // entityManager = Gerente de Entidade

    @Test
    public void removerObjeto() {
        Produto produto = new Produto();
        produto.setId(3);

        Produto produto1 = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto1);
        entityManager.getTransaction().commit();

        // Obs: entityManager remove da Base de Dados e da Memória...
        // entityManager.clear(); Não é necessário na asserção para
        // operação de remoção.

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirOPrimeiroObjeto() {
        Produto produto = new Produto();

    //  produto.setId(2); Comentado porque estamos utilizando IDENTITY
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos.");
        produto.setPreco(new BigDecimal(5000));
        produto.setDataCriacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void abrirEFecharATransacao() {
        // Produto produto = new Produto(); // Somente para o método não mostrar erros.

        entityManager.getTransaction().begin();

//   1º  ROTINAS ANTERIORES DA AULA 2.8
//   Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
//   Assert.assertNotNull(produtoVerificacaoPersist);

// entityManager.flush();

// Comando flush Serve para forçar o que está na memória do entityManager
// para o Banco de Dados.

// OBS: Para fazer uma uma inserção é necessário uma transação...e precisa que uma
// operação esteja dentro da transação. 17/01/2022...Janete


        //  entityManager.persist(produto);
        //  entityManager.merge(produto);
        //  entityManager.remove(produto);

        //   entityManager.getTransaction().commit();
    }
}


package com.teste.primeiroexemlo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiroexemlo.model.Produto;

@Repository

public class ProdutoRepository {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     *metodo para  retornar uma lista de produtos
     * @return
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
    
    /**
     * metodo que  Retorna o produto encontrado pelo seu Id
     * @param id do produto que será localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();

    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto que será adicionado
     * @return retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * metodo que deleta um produto por id
     * @param id produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }
    
    /**
     * Metodo para atualizar produto na lista
     * @param produto atualiza produto
     * @return retorna produto atualizado
     */
    public Produto atualizar(Produto produto){
        // primeiro remover um produto da lista para adiconar um novo
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);
       
        return produto;
    }
}

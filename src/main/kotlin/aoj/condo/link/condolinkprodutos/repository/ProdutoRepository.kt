package aoj.condo.link.condolinkprodutos.repository

import aoj.condo.link.condolinkprodutos.model.Produto
import org.springframework.data.mongodb.repository.MongoRepository

interface ProdutoRepository : MongoRepository<Produto, String>

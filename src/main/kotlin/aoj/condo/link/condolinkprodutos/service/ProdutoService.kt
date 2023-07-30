package aoj.condo.link.condolinkprodutos.service

import aoj.condo.link.condolinkprodutos.model.Produto
import aoj.condo.link.condolinkprodutos.repository.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val productRepository: ProdutoRepository) {
    fun registerProduct(name: String, description: String, price: Double): Produto {
        val product = Produto(name = name, description = description, price = price)
        return productRepository.save(product)
    }

    fun getAllProducts(): List<Produto> {
        return productRepository.findAll()
    }

    fun getProductById(id: String): Produto? {
        return productRepository.findById(id).orElse(null)
    }
}

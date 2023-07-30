package aoj.condo.link.condolinkprodutos.controller

import aoj.condo.link.condolinkprodutos.model.Produto
import aoj.condo.link.condolinkprodutos.service.ProdutoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProdutoController(private val productService: ProdutoService) {
    @PostMapping("/register")
    fun registerProduct(
            @RequestParam name: String,
            @RequestParam description: String,
            @RequestParam price: Double
    ): Produto {
        return productService.registerProduct(name, description, price)
    }

    @GetMapping("/all")
    fun getAllProducts(): List<Produto> {
        return productService.getAllProducts()
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): Produto? {
        return productService.getProductById(id)
    }
}

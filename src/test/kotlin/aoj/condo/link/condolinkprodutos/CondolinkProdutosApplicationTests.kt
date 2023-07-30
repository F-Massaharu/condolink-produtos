package aoj.condo.link.condolinkprodutos

import aoj.condo.link.condolinkprodutos.model.Produto
import aoj.condo.link.condolinkprodutos.repository.ProdutoRepository
import aoj.condo.link.condolinkprodutos.service.ProdutoService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

class ProductServiceTest {
	private val produtoRepository: ProdutoRepository = mockk()
	private val produtoService = ProdutoService(produtoRepository)

	@BeforeEach
	fun setUp() {
		// Define o comportamento padrão do mock para o método findAll()
		every { produtoRepository.findAll() } returns listOf(
				Produto(id = "1", name = "Produto 1", description = "Description 1", price = 10.0),
				Produto(id = "2", name = "Produto 2", description = "Description 2", price = 15.0)
		)
	}

	@Test
	fun testRegisterProduct() {
		val newProduct = Produto(name = "Novo Produto", description = "New Description", price = 20.0)
		val savedProduct = Produto(id = "3", name = "Novo Produto", description = "New Description", price = 20.0)

		every { produtoRepository.save(newProduct) } returns savedProduct

		val registeredProduct = produtoService.registerProduct("Novo Produto", "New Description", 20.0)

		assertEquals(savedProduct, registeredProduct)
	}

	@Test
	fun testGetAllProducts() {
		val allProducts = produtoService.getAllProducts()

		assertEquals(2, allProducts.size)
	}

	@Test
	fun testGetProductById() {
		val productId = "1"
		val product = Produto(id = productId, name = "Product 1", description = "Description 1", price = 10.0)

		every { produtoRepository.findByIdOrNull(productId) } returns product

		val retrievedProduct = produtoService.getProductById(productId)

		assertEquals(product, retrievedProduct)
	}

	@Test
	fun testGetProductById_NonExistentId() {
		val nonExistentId = "9999"

		every { produtoRepository.findByIdOrNull(nonExistentId) } returns null

		val retrievedProduct = produtoService.getProductById(nonExistentId)

		assertEquals(null, retrievedProduct)
	}
}


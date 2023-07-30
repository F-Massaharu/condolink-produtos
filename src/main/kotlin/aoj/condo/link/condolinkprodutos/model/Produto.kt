package aoj.condo.link.condolinkprodutos.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class Produto(
        @Id val id: String? = null,
        val name: String,
        val description: String,
        val price: Double
)
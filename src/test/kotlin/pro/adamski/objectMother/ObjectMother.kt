package pro.adamski.objectMother

import kotlin.random.Random

object ObjectMother {
    fun customer(
        id: Int = Random.nextInt(),
        name: String = "John Doe${Random.nextInt()}",
        email: String = "info-${Random.nextInt()}@example.com"
    ): Customer {
        return Customer(id, name, email)
    }

    fun product(
        id: Int = Random.nextInt(),
        name: String = "The ${Random.nextInt()}th laptop",
        price: Double = Random.nextDouble(1000.0, 5000.0)
    ): Product {
        return Product(id, name, price)
    }

    fun order(
        id: Int = Random.nextInt(),
        customer: Customer = customer(),
        products: List<Product> = listOf(product())
    ): Order {
        return Order(id, customer, products)
    }

    fun largeOrder(id: Int = Random.nextInt(), customer: Customer = customer()): Order {
        val products = List(100) { product(id = it, name = "Product$it") }
        return Order(id, customer, products)
    }
}

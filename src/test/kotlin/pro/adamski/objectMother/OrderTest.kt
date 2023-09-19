package pro.adamski.objectMother

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun testCustomOrder() {
        // Given
        val customProduct = ObjectMother.product(name = "Custom Laptop", price = 2000.0)

        // When
        val customOrder = ObjectMother.order(products = listOf(customProduct))

        // Then
        assertOrderProduct(customOrder.products.first(), "Custom Laptop", 2000.0)
    }

    @Test
    fun testRandomLargeOrder() {
        // When
        val largeOrder = ObjectMother.largeOrder()

        // Then
        assertOrderProducts(largeOrder, 100, 1000.0..5000.0)
    }

    @Test
    fun testCustomOrderJava() {
        // Given
        val customProduct = ObjectMotherJava.product().withName("Custom Laptop").withPrice(2000.0).build()

        // When
        val customOrder = ObjectMotherJava.order().withProducts(listOf(customProduct)).build()

        // Then
        assertOrderProduct(customOrder.products.first(), "Custom Laptop", 2000.0)
    }

    @Test
    fun testRandomLargeOrderJava() {
        // When
        val largeOrder = ObjectMotherJava.largeOrder()

        // Then
        assertOrderProducts(largeOrder, 100, 1000.0..5000.0)
    }

    private fun assertOrderProducts(
        largeOrder: Order,
        numberOfProducts: Int,
        priceRange: ClosedFloatingPointRange<Double>
    ) {
        assertThat(largeOrder.products).hasSize(numberOfProducts)
        assertThat(largeOrder.products).allMatch {
            it.price in priceRange
        }
    }

    private fun assertOrderProduct(firstProduct: Product, name: String, price: Double) {
        assertThat(firstProduct.name).isEqualTo(name)
        assertThat(firstProduct.price).isEqualTo(price)
    }
}
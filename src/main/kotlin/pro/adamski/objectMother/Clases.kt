package pro.adamski.objectMother

data class Customer(val id: Int, val name: String, val email: String)

data class Product(val id: Int, val name: String, val price: Double)

data class Order(val id: Int, val customer: Customer, val products: List<Product>)

package com.ipsmeet.retrofitwithcompose.ecommerce.dataclass

data class EcommerceMainDataClass(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
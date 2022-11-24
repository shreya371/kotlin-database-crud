package com.axis.service

import com.axis.model.Product
import com.axis.util.ProductUtil

class ProductService {
    var productUtil=ProductUtil()

    fun insertUserProduct(product:Product){
        var records=productUtil.insertUserInput(product)
        if (records>0) println("$records rows inserted successfully")
        else println("record not found")
    }

    fun displayAllProducts(){
        var productsres = productUtil.selectAllProducts()
    }

    fun updateProduct(productId:Int,productName:String){
        var records=productUtil.update(productId,productName)
        if (records>0) println("$records rows updated successfully")
        else println("record not found")
    }

    fun deleteProduct(productId:Int){
        var records=productUtil.delete(productId)
        if (records>0) println("$records rows deleted successfully")
        else println("record not found")
    }
}
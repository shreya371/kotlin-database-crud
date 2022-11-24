package com.axis.util

import com.axis.app.DbConnection
import com.axis.model.Product
import java.util.*

class ProductUtil {

    var dbConnection= DbConnection()
    var connection=dbConnection.connect()



    fun insertUserInput(product:Product):Int{

        val prepareStmt=connection.prepareStatement("insert into product values(?,?,?,?)")
        prepareStmt.setInt(1,product.productId)
        prepareStmt.setString(2,product.productName)
        prepareStmt.setDouble(3,product.productPrice)
        prepareStmt.setInt(4,product.productQuantity)
        val rows = prepareStmt.executeUpdate()

        return rows
    }


    fun selectAllProducts(){
        var products= mutableListOf<Product>()
        val query = connection.prepareStatement("select * from product")
        val result = query.executeQuery()

        while(result.next()){
            val productId = result.getInt("productId")
            val productName= result.getString("productName")
            val productPrice= result.getDouble("productPrice")
            val productQuantity= result.getInt("productQuantity")
            products.add(Product(productId,productName,productPrice,productQuantity))
        }

        for(product in products) {
            println(product)
        }

    }

    fun update(productId:Int,productName:String):Int{


        var prepareStmt = connection.prepareStatement("update product set productName=? where productId=?")
        prepareStmt.setString(1,productName)
        prepareStmt.setInt(2,productId)

        var rows=prepareStmt.executeUpdate()

        return rows
    }



    fun delete(productId:Int):Int{
        val prepareStmt=connection.prepareStatement("delete from product where productId=?")
        prepareStmt.setInt(1,productId)
        var rows=prepareStmt.executeUpdate()
        return rows
    }


}
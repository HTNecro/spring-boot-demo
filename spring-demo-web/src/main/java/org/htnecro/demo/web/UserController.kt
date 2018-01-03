package org.htnecro.demo.web

import org.htnecro.demo.mapper.OrderMapper
import org.htnecro.demo.mapper.UserMapper
import org.htnecro.demo.meta.Order
import org.htnecro.demo.meta.User
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

/**
 * @author Haitao.Wu (HTNecro@gmail.com)
 */
@RestController
@RequestMapping("/users")
class UserController {

    @Resource
    private lateinit var userMapper: UserMapper

    @Resource
    private lateinit var orderMapper: OrderMapper

    @GetMapping
    fun list(): List<User> {
        return userMapper.listAll()
    }
    
    @GetMapping("/{userId}/orders")
    fun listOrder(@PathVariable userId: Long): List<Order> {
        return orderMapper.listByUserId(userId)
    }

}
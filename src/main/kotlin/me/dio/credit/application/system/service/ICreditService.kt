package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit): Credit

    //    listar todas as solitações de créditos do customer a partir da Id
    fun findAllByCustomer(customerId: Long): List<Credit>

    //    encontrar o crádito pelo id
    fun findByCreditCode(creditCode: UUID): Credit
}
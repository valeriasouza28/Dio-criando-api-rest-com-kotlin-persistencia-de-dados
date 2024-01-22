package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "The credit value is mandatory") val creditValue: BigDecimal,
    @field:Future val dayFirstInstallment: LocalDate,
    val numberOfInstallment: Int,
    @field:NotNull(message = "The customer id is mandatory")val customerId: Long,
    @field:CPF(message = "This is invalid CPF") val cpf: String

) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}
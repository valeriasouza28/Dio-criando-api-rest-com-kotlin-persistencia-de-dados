package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "The first name is mandatory") val firstName: String,
    @field:NotEmpty(message = "The last name is mandatory") val lastName: String,
    @field:CPF(message = "This is invalid CPF") val cpf: String,
    @field:NotNull(message = "The income is mandatory") val income: BigDecimal,
    @field:Email(message = "This is Invalid email")
    @field:NotEmpty(message = "The email is mandatory") val email: String,
    @field:NotEmpty(message = "The password is mandatory") val password: String,
    @field:NotEmpty(message = "The zipCode is mandatory") val zipCode: String,
    @field:NotEmpty(message = "The street is mandatory") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
        )

}

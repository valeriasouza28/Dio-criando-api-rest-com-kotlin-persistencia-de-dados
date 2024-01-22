package me.dio.credit.application.system.impl

import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.exception.BusinessException
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
//    cria constante as referecia da interface CustomerRepository
    private val customerRepository: CustomerRepository
): ICustomerService {
//    implementa o método save onde ele recebe como parâmetro customer que será do tipo Customer,
    //    e ele vai ter como retorno o tipo Customer
//    ele chama o método save da interface customerRepository passando como argumento customer
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow{ throw BusinessException("Id $id not found")
        }

//    deleta customer pela entity e não pelo id
    override fun delete(id: Long) {
//        passa a entidade para a variável customer
        val customer: Customer = this.findById(id)
//    passamos como argumento para exclui a entidade e não o id
    this.customerRepository.delete(customer)
    }

}
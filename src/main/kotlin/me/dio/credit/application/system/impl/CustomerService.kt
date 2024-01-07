package me.dio.credit.application.system.impl

import me.dio.credit.application.system.entity.Customer
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

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)

}
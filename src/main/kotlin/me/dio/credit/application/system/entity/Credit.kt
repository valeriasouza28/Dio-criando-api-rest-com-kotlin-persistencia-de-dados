package me.dio.credit.application.system.entity

import jakarta.persistence.*
import me.dio.credit.application.system.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
//@Table(name = "Credito")
data class Credit(
    // **UUID.randomUUID()** para gerar id automaticamente
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    // **?** para que inicie como null para que também possa ser verificado se esse costumer exite no banco de dados
    @ManyToOne var customer: Customer? = null,
    // esse id vai referenciar a primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)

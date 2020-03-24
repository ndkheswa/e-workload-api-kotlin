package com.learncoding.eworkloadapi.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.sun.istack.NotNull
import java.time.LocalDate
import java.time.Period
import java.util.*
import javax.persistence.*

@Entity
data class Client(
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="api_seq", initialValue=205, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    var id: Long,

    @NotNull var firstName: String,

    @NotNull var lastName: String,

    var email: String,

    @NotNull var phone: String,

    @NotNull var occupation: Occupation,

    @NotNull var gender: Gender,

    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    var birthdate: LocalDate,

    @NotNull var age: Int) {

    enum class Gender {
        MALE, FEMALE, OTHER
    }

    enum class Occupation {
        STUDENT, SCHOLAR, SALARIED_EMPLOYEE, SELF_EMPLOYED, BUSINESS_OWNER, UNEMPLOYED
    }

    private fun calculateAge(birthDate: LocalDate) : Int =
        if (birthDate != null) Period.between(birthDate, LocalDate.now()).years else 0

    fun setAge(birthDate: LocalDate) : Unit {
        this.age = calculateAge(birthDate)
    }



}
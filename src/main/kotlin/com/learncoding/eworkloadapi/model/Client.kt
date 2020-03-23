package com.learncoding.eworkloadapi.model

import com.sun.istack.NotNull
import java.time.LocalDate
import java.time.Period
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Client(@Id @GeneratedValue var id: Long,
                  @NotNull var firstName: String,
                  @NotNull var lastName: String,
                  var email: String,
                  @NotNull var phone: String,
                  @NotNull var occupation: Occupation,
                  @NotNull var gender: Gender,
                  @NotNull private var age: Int) {

    enum class Gender {
        MALE, FEMALE, OTHER
    }

    enum class Occupation {
        STUDENT, SCHOLAR, SALARIED_EMPLOYEE, SELF_EMPLOYED, BUSINESS_OWNER, UNEMPLOYED
    }

    private fun calculateAge(birthDate: LocalDate, currentDate: LocalDate) : Int =
        if (birthDate != null && currentDate != null) Period.between(birthDate, currentDate).years else 0

    private fun setAge(birthDate: LocalDate, currentDate: LocalDate) : Unit {
        this.age = calculateAge(birthDate, currentDate)
    }



}
package com.learncoding.eworkloadapi.repository

import com.learncoding.eworkloadapi.model.Client
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface ClientRepository: PagingAndSortingRepository<Client, Long>, JpaSpecificationExecutor<Client> {
}
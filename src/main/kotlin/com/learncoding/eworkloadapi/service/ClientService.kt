package com.learncoding.eworkloadapi.service

import com.learncoding.eworkloadapi.ClientRepository
import com.learncoding.eworkloadapi.exception.BadResourceException
import com.learncoding.eworkloadapi.exception.ResourceAlreadyExistsException
import com.learncoding.eworkloadapi.exception.ResourceNotFoundException
import com.learncoding.eworkloadapi.model.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class ClientService(@Autowired val clientRepository: ClientRepository) {

    fun existById(id: Long) : Boolean = clientRepository.existsById(id);

    fun findById(id: Long) : Client {

        val client: Client? = clientRepository.findByIdOrNull(id)

        if ( client == null) {
            throw ResourceNotFoundException("Cannot find client with id $id")
        } else {
            return client
        }
    }

    fun findAll(pageNumber: Int, rowsPerPage: Int): Page<Client> {
        return clientRepository.findAll(PageRequest.of(pageNumber - 1, rowsPerPage))
    }

    fun save(client: Client): Client {
        if (!StringUtils.isEmpty(client.lastName)) {
            if (client.lastName != null && this.existById(client.id)) {
                throw ResourceAlreadyExistsException("Client with id ${client.id} " +
                        "already exists")
            }
            return clientRepository.save(client)
        } else {
            val e: BadResourceException = BadResourceException("Could not save client")
            e.addErrorMessage("Client is null or empty")
            throw  e
        }
    }
}
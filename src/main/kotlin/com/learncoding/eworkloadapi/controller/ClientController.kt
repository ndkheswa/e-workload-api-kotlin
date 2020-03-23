package com.learncoding.eworkloadapi.controller

import com.learncoding.eworkloadapi.exception.BadResourceException
import com.learncoding.eworkloadapi.exception.ResourceAlreadyExistsException
import com.learncoding.eworkloadapi.model.Client
import com.learncoding.eworkloadapi.service.ClientService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*
import javax.validation.Valid
import kotlin.collections.ArrayList

@RestController
@RequestMapping("/api/v1")
class ClientController {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    private val rowsPerPage: Int = 10

    @Autowired
    var clientService: ClientService? = null

    @GetMapping(value = ["/clients"], produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findAll(
        @RequestParam(value = "page", defaultValue = "1") pageNumber: Int,
        @RequestParam(required = false) lastName: String?
    ) : ResponseEntity<Page<Client>> {
        return ResponseEntity.ok(clientService!!.findAll(pageNumber, rowsPerPage))
    }

    @PostMapping("/clients")
    fun addClient(@Valid @RequestBody client: Client) : ResponseEntity<Client> {
        try {
            var newClient: Client? = clientService?.save(client)
            return ResponseEntity.created(URI("/api/v1/clients ${newClient?.id}")).body(client)
        } catch (ex: ResourceAlreadyExistsException) {
            logger.error(ex.message)
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        } catch (ex: BadResourceException) {
            logger.error(ex.message)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }

}
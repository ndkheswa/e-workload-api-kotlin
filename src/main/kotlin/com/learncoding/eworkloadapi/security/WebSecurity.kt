package com.learncoding.eworkloadapi.security

/**
 * import com.auth0.spring.security.api.JwtWebSecurityConfigurer
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class WebSecurity : WebSecurityConfigurerAdapter() {

@Value("\${auth0.audience}")
private val audience: String? = null

@Value("\${auth0.issuer}")
private val issuer: String? = null

@Throws(Exception::class)
override fun configure(http: HttpSecurity) {
http.authorizeRequests()
.anyRequest().authenticated()

JwtWebSecurityConfigurer
.forRS256(audience, issuer!!)
.configure(http)
}
}
 */

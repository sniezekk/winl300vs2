package com.winl300.demo.boot

import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import com.netflix.graphql.dgs.webmvc.autoconfigure.DgsWebMvcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * This class wires in the graphql Netflix DGS and registers a scalar not included in GraphQL by default
 *
 * @Author Korey Sniezek
 * @Date 05April2022
 */
@Import(
    DgsWebMvcAutoConfiguration::class,
    DgsAutoConfiguration::class
)
@Configuration
class GraphQLConfiguration {
    @Bean
    fun scalarRegistration(): RuntimeScalarRegistration {
        return RuntimeScalarRegistration()
    }
}
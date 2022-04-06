package com.winl300.demo.services.drug.spring

import com.fasterxml.jackson.databind.ObjectMapper
import com.winl300.demo.services.drug.DrugService
import com.winl300.demo.services.drug.graphql.DrugDataFetcher
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * This class contains configuration for Drug services, input arguments are autowired
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@Configuration
class DrugConfiguration(
    private val graphTraversalSource: GraphTraversalSource,
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun drugService(): DrugService {
        return DrugService(graphTraversalSource, objectMapper)
    }

    @Bean
    fun drugDataFetcher(): DrugDataFetcher {
        return DrugDataFetcher(drugService())
    }
}
package com.winl300.demo.services.symptom.spring

import com.fasterxml.jackson.databind.ObjectMapper
import com.winl300.demo.services.symptom.SymptomService
import com.winl300.demo.services.symptom.graphql.SymptomDataFetcher
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
/**
 * This class contains the configuration for symptom services
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@Configuration
class SymptomConfiguration(
    private val graphTraversalSource: GraphTraversalSource,
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun symptomService(): SymptomService {
        return SymptomService(graphTraversalSource, objectMapper)
    }

    @Bean
    fun symptomDataFetcher(): SymptomDataFetcher {
        return SymptomDataFetcher(symptomService())
    }
}
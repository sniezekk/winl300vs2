package com.winl300.demo.services.condition.spring

import com.fasterxml.jackson.databind.ObjectMapper
import com.winl300.demo.services.condition.ConditionService
import com.winl300.demo.services.condition.graphql.ConditionDataFetcher
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
/**
 * This class holds the configuration for condition services, input arguments are autowired
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@Configuration
class ConditionConfiguration(
    private val graphTraversalSource: GraphTraversalSource,
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun conditionService(): ConditionService {
        return ConditionService(graphTraversalSource, objectMapper)
    }

    @Bean
    fun conditionDataFetcher(): ConditionDataFetcher {
        return ConditionDataFetcher(conditionService())
    }
}
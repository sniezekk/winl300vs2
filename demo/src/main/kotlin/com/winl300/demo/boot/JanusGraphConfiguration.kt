package com.winl300.demo.boot

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.commons.configuration.MapConfiguration
import org.apache.tinkerpop.gremlin.jsr223.ConcurrentBindings
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.groovy.engine.GremlinExecutor
import org.apache.tinkerpop.gremlin.structure.util.GraphFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * This class contains coniguration and Beans for JanusGraph Connectivity
 *
 * @Author Korey Sniezek
 * @Date 05April2022
 */

@Configuration
class JanusGraphConfiguration {

    // this is referenced for all functions that operate on the graph
    @Bean
    fun graph(): Graph {
        return GraphFactory.open(embeddedGraphConfiguration())
    }

    // all graph traversals will start with this bean
    @Bean
    fun graphTraversalSource(): GraphTraversalSource {
        return graph().traversal()
    }

    //this function executes Gremlin queries against the database
    @Bean
    fun gremlinExecutor(): GremlinExecutor {
        return GremlinExecutor
            .build()
            .evaluationTimeout(10_000)
            .globalBindings(ConcurrentBindings(mapOf("g" to graphTraversalSource())))
            .create()
    }

    //universal object mapper, gremlin returns individual items as an array size 1, must be unwrapped
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
            .configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true)
            .registerKotlinModule()
    }

    /**
     * This function contains the connection configuration to whatever instance of JanusGraph you are running
     *
     * As my supervising company already has a Janusgraph Instance running on ScyllaDB for the official POC, I connected to that.
     *
     * This will need to be edited to point to the local version of JanusGraph you may run for testing purposes
     */
    private fun embeddedGraphConfiguration(): org.apache.commons.configuration.Configuration {
        return MapConfiguration(
            mapOf(
                "gremlin.graph" to "org.janusgraph.core.JanusGraphFactory",
                "storage.backend" to "cql",
                "storage.hostname" to "scylladb-poc.qa.aws.redacted.com",
                "storage.cql.keyspace" to "poc_schema",
                "storage.lock.wait-time" to 10000,
                "schema.default" to "none",
                "schema.constraints" to true,
                "cache.db-cache" to true
            )
        )
    }
}

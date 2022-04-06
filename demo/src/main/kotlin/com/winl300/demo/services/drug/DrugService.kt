package com.winl300.demo.services.drug

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.winl300.demo.services.common.TraversalConstants
import com.winl300.demo.services.condition.ConditionConstants
import com.winl300.demo.services.drug.graphql.Drug
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
/**
 * This class represents the Drug service, and uses the graph traversal source to query the database
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */

//this function wires in properties on the vertex common to all drug queries
private fun <T, U> GraphTraversal<T, U>.drugFields(): GraphTraversal<T, Map<Any, Any>> {
    return this.valueMap(
        DrugConstants.GENERIC_NAME,
        DrugConstants.BRAND_NAMES,
        DrugConstants.DOC_IDS,
        DrugConstants.PRECAUTIONS,
        DrugConstants.DOSAGE,
        DrugConstants.APPLICATION_ROUTES
    )
}

class DrugService(
    private val g: GraphTraversalSource,
    private val objectMapper: ObjectMapper
) {
    //get drug by name
    fun getDrug(name: String): Drug {
        val drug = g.V()
            .has(DrugConstants.GENERIC_NAME, name)
            .hasLabel(DrugConstants.DRUG_LABEL)
            .drugFields()
            .toList()

        return objectMapper.convertValue(drug, Drug::class.java)
    }
    
    fun getDrugsThatTreat(conditionName: String): List<Drug> {
        val drugs = g.V()
            .has(ConditionConstants.CONDITION_NAME, conditionName)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .`in`(TraversalConstants.TREATS)
            .hasLabel(DrugConstants.DRUG_LABEL)
            .drugFields()
            .toList()

        return objectMapper.convertValue(drugs, jacksonTypeRef())
    }

    fun getDrugsThatAreContraindicatedForCondition(conditionName: String): List<Drug> {
        val drugs = g.V()
            .has(ConditionConstants.CONDITION_NAME, conditionName)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .both(TraversalConstants.CONTRAINDICATED_FOR)
            .hasLabel(DrugConstants.DRUG_LABEL)
            .drugFields()
            .toList()

        return objectMapper.convertValue(drugs, jacksonTypeRef())
    }
}
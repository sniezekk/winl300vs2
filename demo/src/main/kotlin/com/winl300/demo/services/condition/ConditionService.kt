package com.winl300.demo.services.condition


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.winl300.demo.services.common.CommonConstants
import com.winl300.demo.services.common.TraversalConstants
import com.winl300.demo.services.condition.graphql.Condition
import com.winl300.demo.services.drug.DrugConstants
import com.winl300.demo.services.symptom.SymptomConstants
import org.apache.tinkerpop.gremlin.process.traversal.P.within
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

/**
 * This class represents the condition service, and executes queries against the database using the traversal source,
 * it also calls the object mapper to map back to a Kotlin object
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */

// extension function that injects repeated traversal steps common to all condition queries
private fun <T, U> GraphTraversal<T, U>.conditionFields(): GraphTraversal<T, Map<String, Any>> {
    return this.project<Any>(CommonConstants.NAME).by(ConditionConstants.CONDITION_NAME)
}

class ConditionService(
    private val g: GraphTraversalSource,
    private val objectMapper: ObjectMapper
) {
    //get condition by name
    fun getCondition(conditionName: String): Condition {
        val condition = g.V()
            .has(ConditionConstants.CONDITION_NAME, conditionName)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .conditionFields()
            .toList()

        return objectMapper.convertValue(condition, Condition::class.java)
    }

    fun getConditionsBySymptoms(symptoms: List<String>): List<Condition> {
        val conditions = g.V()
            .has(SymptomConstants.SYMPTOM_NAME, within(symptoms))
            .hasLabel(SymptomConstants.SYMPTOM_LABEL)
            .`in`(TraversalConstants.HAS_SYMPTOM)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .conditionFields()
            .toList()

        return objectMapper.convertValue(conditions, jacksonTypeRef())
    }

    // get conditions that a drug treats
    fun drugTreats(drugName: String): List<Condition> {
        val conditions = g.V()
            .has(DrugConstants.GENERIC_NAME, drugName)
            .hasLabel(DrugConstants.DRUG_LABEL)
            .out(TraversalConstants.TREATS)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .conditionFields()
            .toList()

        return objectMapper.convertValue(conditions, jacksonTypeRef())
    }

    fun getContraindicationsForDrug(drugName: String): List<Condition> {
        val contraindications = g.V()
            .has(DrugConstants.GENERIC_NAME, drugName)
            .hasLabel(DrugConstants.DRUG_LABEL)
            .both(TraversalConstants.CONTRAINDICATED_FOR)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .conditionFields()
            .toList()

        return objectMapper.convertValue(contraindications, jacksonTypeRef())
    }
}
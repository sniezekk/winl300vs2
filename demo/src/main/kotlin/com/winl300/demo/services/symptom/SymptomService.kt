package com.winl300.demo.services.symptom

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.winl300.demo.services.common.CommonConstants
import com.winl300.demo.services.common.TraversalConstants
import com.winl300.demo.services.condition.ConditionConstants
import com.winl300.demo.services.drug.DrugConstants
import com.winl300.demo.services.symptom.graphql.Symptom
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
/**
 * This class is the symptom service, that performs all symptom related queries to the graph
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
// this extension function wires in all commom properties to all symptom queries
private fun <T, U> GraphTraversal<T, U>.symptomFields(): GraphTraversal<T, Map<String, Any>> {
    return this.project<Any>(CommonConstants.NAME).by(SymptomConstants.SYMPTOM_NAME)
}


class SymptomService(
    private val g: GraphTraversalSource,
    private val objectMapper: ObjectMapper
) {
    fun getSymptomsByConditionName(name: String): List<Symptom> {
        val symptoms = g.V()
            .has(ConditionConstants.CONDITION_NAME, name)
            .hasLabel(ConditionConstants.CONDITION_LABEL)
            .out(TraversalConstants.HAS_SYMPTOM)
            .hasLabel(SymptomConstants.SYMPTOM_LABEL)
            .symptomFields()
            .toList()

        return objectMapper.convertValue(symptoms, jacksonTypeRef())
    }

    fun getSideEffectsOfDrug(drugName: String): List<Symptom> {
        val sideEffects = g.V()
            .has(DrugConstants.GENERIC_NAME, drugName)
            .hasLabel(DrugConstants.DRUG_LABEL)
            .out(TraversalConstants.HAS_SIDE_EFFECT)
            .hasLabel(SymptomConstants.SYMPTOM_LABEL)
            .symptomFields()
            .toList()

        return objectMapper.convertValue(sideEffects, jacksonTypeRef())
    }
}

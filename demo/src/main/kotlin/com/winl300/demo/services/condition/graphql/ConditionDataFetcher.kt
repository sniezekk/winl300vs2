package com.winl300.demo.services.condition.graphql

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import com.winl300.demo.services.condition.ConditionService
import com.winl300.demo.services.drug.graphql.Drug
import graphql.schema.DataFetchingEnvironment

/**
 * This class fetches data for conditions, and acts as the wiring between the schema and the condition service
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@DgsComponent
class ConditionDataFetcher(
    private val conditionService: ConditionService
) {
    @DgsQuery
    fun condition(@InputArgument name: String): Condition {
        return conditionService.getCondition(name)
    }

    // gets possible conditions by the list of symptoms, ranks results
    @DgsQuery
    fun possibleConditions(@InputArgument symptoms: List<String>): List<Condition> {
        return conditionService.getConditionsBySymptoms(symptoms)
    }

    // gets the conditions that a drug may treat
    @DgsQuery
    fun treats(dfe: DataFetchingEnvironment): List<Condition> {
        val drug = dfe.getSource<Drug>()

        return conditionService.drugTreats(drug.genericName)
    }

    //returns any conditions that indicate a drug should not be used
    @DgsQuery
    fun contraindications(dfe: DataFetchingEnvironment): List<Condition> {
        val drug = dfe.getSource<Drug>()

        return conditionService.getContraindicationsForDrug(drug.genericName)
    }
}
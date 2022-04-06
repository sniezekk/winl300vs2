package com.winl300.demo.services.symptom.graphql

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.winl300.demo.services.condition.graphql.Condition
import com.winl300.demo.services.drug.graphql.Drug
import com.winl300.demo.services.symptom.SymptomService
import graphql.schema.DataFetchingEnvironment
/**
 * This class actsas the wiring between the schema and the symptom service
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@DgsComponent
class SymptomDataFetcher(
    private val symptomService: SymptomService
) {
    //get the symptoms for the condition that this is called on
    @DgsQuery
    fun symptoms(dfe: DataFetchingEnvironment): List<Symptom> {
        val condition = dfe.getSource<Condition>()

        return symptomService.getSymptomsByConditionName(condition.name)
    }

    // get the symptoms that represent side effects for this drug
    @DgsQuery
    fun sideEffects(dfe: DataFetchingEnvironment): List<Symptom> {
        val drug = dfe.getSource<Drug>()

        return symptomService.getSideEffectsOfDrug(drug.genericName)
    }
}

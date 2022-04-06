package com.winl300.demo.services.drug.graphql

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import com.winl300.demo.services.condition.graphql.Condition
import com.winl300.demo.services.drug.DrugService
import graphql.schema.DataFetchingEnvironment

/**
 * This class acts as the wiring between the schema and the drug service
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@DgsComponent
class DrugDataFetcher(
    private val drugService: DrugService
) {
    //get drug by name
    @DgsQuery
    fun drug(@InputArgument name: String): Drug {
        return drugService.getDrug(name)
    }

    // use a condition to get drugs that can treat it
    @DgsQuery
    fun treatedBy(dfe: DataFetchingEnvironment): List<Drug> {
        val conditionName = dfe.getSource<Condition>().name

        return drugService.getDrugsThatTreat(conditionName)
    }

    //get drugs that may indicate that this drug should not be taken
    @DgsQuery
    fun contraindicated(dfe: DataFetchingEnvironment): List<Drug> {
        val conditionName = dfe.getSource<Condition>().name

        return drugService.getDrugsThatAreContraindicatedForCondition(conditionName)
    }
}

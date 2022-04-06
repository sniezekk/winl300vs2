package com.winl300.demo.services.drug.graphql

/**
 * This class represents a Drug, and it's properties
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */

data class Drug (
    // represents a drug's generic name, not to be confused with chemical formula
    val genericName: String,

    // known brands for the drug
    val brandNames: List<String>,

    // document ids that represent documents associated with this drug
    val docIds: List<Long>,

    // precautions when using this drug
    val precautions: List<String>,

    // dose instructions, varies by age, health, etc.
    val dosage: List<String>
)
package com.winl300.demo.services.condition.graphql

import com.winl300.demo.services.symptom.graphql.Symptom

/**
 * This class represents Health conditions
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
data class Condition(
    // the name of the condition
    val name: String,

    //A list of symptoms for the condition
    val symptoms: List<Symptom>,
)
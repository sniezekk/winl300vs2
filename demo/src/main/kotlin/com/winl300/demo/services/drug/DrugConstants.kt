package com.winl300.demo.services.drug

/**
 * This class acts as a source of truth for vertex property names for all Drug vertexes in the graph
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
object DrugConstants {
    const val DRUG_LABEL = "Drug"
    const val GENERIC_NAME = "genericName"
    const val BRAND_NAMES = "brandNames"
    const val DOC_IDS = "docIds"
    const val PRECAUTIONS = "precautions"
    const val DOSAGE = "dosage"
    const val APPLICATION_ROUTES = "applicationRoutes"
}
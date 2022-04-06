package com.winl300.demo.services.common

/**
 * This class acts as a source of truth for edge names in the graph, used in traversals
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
object TraversalConstants {
    const val TREATS = "TREATS"
    const val CONTRAINDICATED_FOR = "CONTRAINDICATED_FOR"
    const val HAS_SYMPTOM = "HAS_SYMPTOM"
    const val HAS_SIDE_EFFECT = "HAS_SIDE_EFFECT"
}
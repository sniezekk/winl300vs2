package com.winl300.demo.boot

import com.winl300.demo.services.condition.spring.ConditionConfiguration
import com.winl300.demo.services.drug.spring.DrugConfiguration
import com.winl300.demo.services.symptom.spring.SymptomConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * This class wires the separate spring configuration classes together to be loaded in GraphDbDemoApplication
 *
 * @Author Korey Sniezek
 * @Date 05April2022
 */
@Import(
    value = [
        JanusGraphConfiguration::class,
        GraphQLConfiguration::class,
        ConditionConfiguration::class,
        DrugConfiguration::class,
        SymptomConfiguration::class
    ]
)
@Configuration
class SpringConfiguration
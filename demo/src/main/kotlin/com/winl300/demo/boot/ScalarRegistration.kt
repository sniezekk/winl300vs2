package com.winl300.demo.boot

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.Scalars
import graphql.schema.idl.RuntimeWiring

/**
 * This class assists in wiring the GraphQLLong Scalar at runtime
 *
 * @author Korey Sniezek
 * @Date 05April2022
 */
@DgsComponent
class RuntimeScalarRegistration {

    @DgsRuntimeWiring
    fun addScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder {
        return builder.scalar(Scalars.GraphQLLong)
    }
}
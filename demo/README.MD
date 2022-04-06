
# GraphDB Demo For WINL300
## Project Information
### Author:
Korey Sniezek
### Project Name:
GraphDB Demo For WINL300
### Project Tech:
Built with IntelliJ, using Maven package manager.
Uses Kotlin, Java, GraphQL, SpringBoot, and NetflixDGS, JanusGraph, Gremlin, Jackson's FasterXml

Adjacent tech used: Cassandra on the back end, Gremlin-visualizer for graph troubleshooting
### Project Purpose:
This demo project represents a recreation of a Graph DB POC
### Project Description:
This project is a recreation of a poof of concept drug repository that allows for the dynamic linking of drugs 
to conditions, side effects, etc, with minimal database calls. This is done using a graph database, which can organically 
represent the related data
### RUN INSTRUCTIONS
Download and install JanusGraph from:
https://docs.janusgraph.org/getting-started/installation/

Change run configuration settings in JanusGraphConfiguration

Run Gremlin Console and load sample-data.groovy, included in the project resource files

This is powered by springboot. Run the main class in "GraphDBDemoApplication.kt", make sure that your IDE has the
associated maven plugin installed (This was built on intelliJ, so that is ideal. Alternatively, you can go to the
command line and run mvn spring-boot:run, assuming that you have mvn installed.

Use a browser to access localhost:8080/graphiql for the graphical user interface

## References/Citations
#### Spring-Boot project was initialized with the Spring-Boot initializer at https://start.spring.io/
#### NetflixDGS Initial Setup Instructions: https://netflix.github.io/dgs/getting-started/
#### General Tutorial for GraphQL: https://www.howtographql.com/
#### JanusGraph reference https://docs.janusgraph.org/getting-started/installation/
#### Gremlin tutorial and docs https://docs.janusgraph.org/getting-started/gremlin/
#### Gremlin visualizer (used in graph demo) https://github.com/prabushitha/gremlin-visualizer

## Future Development:
The original purpose for this poc was to expand it in such a way to more easily create informed websites about drugs and conditions
As well as allow for dynamic end-user searching of relevant data. This could be expanded nearly endlessly using real world
data. Indexing would allow for quick searches, caches could be implemented, etc. 
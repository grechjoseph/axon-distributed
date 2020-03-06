1. Four different modules:
    a. Axon Commons: Will contain common classes, such as Commands, Events, Data types, and Queries.
    b. Axon Command: Will contain command-related classes, being Aggregates (having @CommandHandlers and @EventSourcingHandlers) and Command-submitting endpoints (REST Controller).
    c. Axon Query One: Will contain query-related classes, being a Service which has @EventHandlers and @QueryHandlers.
    d. Axon Query Two: Will also contain query-related classes, as Axon Query One.
    
2. Axon Commons: 
    a. api
        i. commands: Classes that represent commands that the application will support, eg: CreatePersonCommand to created a Person. This must contain the generated ID for the Person, along with the First Name and Last Name being set.
        ii. data: Classes to represent data objects, eg: Person.
        iii. events: Events that our fired by a Command. These should contain the concerned changed fields so that they are relevant to the services consuming them.
        iv. queries: Classes that represent queries that the application will support, eg: FindPersonsQuery to find persons by a given set of criteria.
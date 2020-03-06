1. Four different modules:
    a. Axon Commons: Will contain common classes, such as Commands, Events, Data types, and Queries.
    b. Axon Command: Will contain command-related classes, being Aggregates (having @CommandHandlers and @EventSourcingHandlers) and Command-submitting endpoints (REST Controller).
    c. Axon Query One: Will contain query-related classes, being a Service which has @EventHandlers and @QueryHandlers.
    d. Axon Query Two: Will also contain query-related classes, as Axon Query One.
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
        
3. Axon Commands:
    a. aggregates: Classes that represent Aggregates. An aggregate is the so-called processor of Commands. An overloaded constructor is created with the Command that will instatiate the Aggregate (typically a Create command) annotated with @CommandHandler. This then fires a Created Event, which is handled by the @EventSourcingHandler to decide how to change the state of the Aggregate. The Aggregate must also have a default constructor. This is used when a new event comes in later. The Framework replays all events for that Aggregate, starting from a new instance using the Default Constructor, and replayig each event on it (not commands).
    b. controllers: Classes that represent REST Controllers. The Controller uses a CommandGateway to dispatch commands, which are picked up by the relevant Aggregate handling the command in any of its @CommandHandlers. This is done asynchronously, so a .join() is required to wait for the task to complete.
    
4. Axon Query One:
    a. controllers: Classes that represent REST Controllers. The Controller uses a QueryGateway to dispatch queries, which are picked up by the relevant @Service handling the query in any of its @QueryHandlers. It is then up to the service on how to service this query.
    b. services: Classes that represent Services that have code to execute on @EventHandlers (fired by Aggregates' @EventSourcingHandlers and re-executed on application startup unless modified not do using a trace token), and handles @QueryHandlers.
    
5. Axon Query Two: Same as Axon Query One, but can freely handle @EventHandlers and @QueryHandlers differently. Also receives events in Event Handlers in addition to Axon Query One receiving them. @QueryHandlers are load balanced between the two (default: Round Robin).
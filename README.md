## Mockito embeded with Spring.

This application uses mockito to unit test the application. Mockito is used for testing the layers.


### This application has these libraries.

1. Spring boot - To build rest api application.
2. Mockito -  To Unit test the application.
3. H2 database - Inbuild database to store the data.
4. JPA - To access the database.


### Structure of the application.

1. Web layer which exposes the API's
2. Service layer which is used by web-layer, this service-layer talks to data-layer to access the database.
3. Data layer which user JPARepo's to access the H2 database.


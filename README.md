This repo contains tests for the javax <--> jakarta handshake protocol used in EJB client.

The interoperability handshake establishes an agreed version (1 or 2) between client and server and the 
version is used to determine which marshallers to provide: the legacy marshaller or the interoperability marshaller.

It contains the following modules:
* sampleApp - a module containing a sample EJB application to be deployed on the server side
* legacy2Current - a module which starts a current Wildfly server and runs legacy EJB client tests against it
* current2Legacy - a module which starts a legacy Wildfly server and runs current EJB client tests against it

Here:
* legacy - Wildfly 26.1.3 (Wildfly HTTP client 1.1.12.Final, penultimate release without the interoperability handshake)
* current - Wildfly 28.0.0 (Wildfly HTTP client 2.0.2.Final, first release with the interoperability handshake)
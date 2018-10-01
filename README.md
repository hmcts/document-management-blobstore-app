# Performance Test DM BLOB Store

## To Run:

- Specify the environment against which to test. The list of supported environments and their required configuration is in src/test/resources/application.conf

    ```
    export ENVIRONMENT={enviroment_name}
    ```
    e.g: 
    
    ```
    export ENVIRONMENT=cnp
    ```
    
- Depending on the specific environment, open required ssh tunnels (Idam, Bastion host...)
    
- To run all the performance tests:
    
    ```
    mvn clean gatling:test
    ```
    
- To run a specific simulation
    ```
    mvn clean gatling:test -Dgatling.simulationClass={simulation_class_name}
    ```
    e.g: 
    ```
    mvn clean gatling:test -Dgatling.simulationClass=uk.gov.hmcts.ccd.simulation.DMPTSimulation
    ```
    
## LICENSE

This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for details.

# Pokemon Soap

Link: [GitHub-pokemon-soap](https://github.com/PMSXAA/pokemon)

Author(s): - Jose Juan Zapote Baltazar

Last updated: 2024.12

## Content

- Overview
- Architecture
- Dependencies
- Run Soap
- Run PokemonApplication
- Sonarqube
- Swagger documentation
- Jacoco Documentation

## Overview

- Soap to get basic , get information by soap client.

## Architecture

- Use Java 17 version
- Use Maven 4.0.0
- Use spring boot 3.4.0 version
- Use jacoco 0.8.10 version for Testing and for documentation microservice
- Use swagger 3.0.0 version for documentation microservice

## Dependencies

- am-tb-soap-pnr          https://github.com/EC-AMX/am-tb-soap-pnr/tree/develop  or
- am-tb-pnr               https://github.com/EC-AMX/am-tb-pnr/tree/develop
- am-tb-airports-info     https://github.com/EC-AMX/am-tb-airports-info/tree/develop
- am-tb-fare-family       https://github.com/EC-AMX/am-tb-fare-family/tree/develop
- am-tb-timezone          https://github.com/EC-AMX/am-tb-timezone/tree/develop
- am-tb-region            https://github.com/EC-AMX/am-tb-region/tree/develop
- am-tb-employee-standby  https://github.com/EC-AMX/am-tb-employee-standby/tree/develop
- am-tb-pnt-list          https://github.com/EC-AMX/am-tb-pnr-list/tree/develop
- am-tb-update-pnr        https://github.com/EC-AMX/am-tb-update-pnr/tree/develop

## Run Microservice

### Run AmTcPnrApplication

1. Run the maven command `mvn clean install` or `mvn clean install -DSkipTests` in the project path.
2. Run the maven `mvn spring-boot:run` command to start a microservice instance or using the tools provided by the IDE

## SonarQube

    For execute sonarqube need:
        - Sonarqube-10.1.0.73491 version
        - Complexity coverage is 90% or high

## Swagger documentation

To see the swagger ui, run the **AmTcPnrApplication** and open in the browser the
link http://localhost:8085/swagger-ui/index.html

## Jacoco documentation

    For view jacoco documentation:
        - Execute mvn clean install for build project, after build is generate folder apidocs:
        - In (root)\am-tc-region\target\apidocs\index.html
            - Click in index.html for view documentation of microservice
        - In (root)\am-tc-region\target\site\jacoco\index.html
            - Click in index.html for view jacoco information of microservice

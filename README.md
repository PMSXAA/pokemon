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

- Soap to get basic abilities, base_experience, held_items, id, name, location_area_encounters by soap client.

## Architecture

- Use Java 17 version
- Use Maven 4.0.0
- Use spring boot 3.4.0 version
- Use jacoco 0.8.10 version for Testing and for documentation microservice
- Use swagger 3.0.0 version for documentation microservice

## Dependencies

- Pokemon Api         https://pokeapi.co/](https://pokeapi.co/api/v2/pokemon/

## Run Soap

### Run PokemonApplication

1. Run the maven command `mvn clean install` or `mvn clean install -DSkipTests` in the project path.
2. Run the maven `mvn spring-boot:run` command to start a microservice instance or using the tools provided by the IDE

## SonarQube

    For execute sonarqube need:
        - Sonarqube-10.8 version
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

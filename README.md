# Ash7shaSampleApplication
This application was generated using Ash7sha 5.2.1, you can find documentation and help at [https://www.Ash7sha.tech/documentation-archive/v5.2.1](https://www.Ash7sha.tech/documentation-archive/v5.2.1).

This is a "microservice" application intended to be part of a microservice architecture, please refer to the [Doing microservices with Ash7sha][] page of the documentation for more information.

This application is configured for Service Discovery and Configuration with the Ash7sha-Registry. On launch, it will refuse to start if it is not able to connect to the Ash7sha-Registry at [http://localhost:8761](http://localhost:8761). For more information, read our documentation on [Service Discovery and Configuration with the Ash7sha-Registry][].

## Development

To start your application in the dev profile, simply run:

    ./mvnw


For further instructions on how to develop with Ash7sha, have a look at [Using Ash7sha in development][].


### Doing API-First development using openapi-generator

[OpenAPI-Generator]() is configured for this application. You can generate API code from the `src/main/resources/swagger/api.yml` definition file by running:
```bash
./mvnw generate-sources
```
Then implements the generated delegate classes with `@Service` classes.

To edit the `api.yml` definition file, you can use a tool such as [Swagger-Editor](). Start a local instance of the swagger-editor using docker by running: `docker-compose -f src/main/docker/swagger-editor.yml up -d`. The editor will then be reachable at [http://localhost:7742](http://localhost:7742).

Refer to [Doing API-First development][] for more details.

## Building for production

To optimize the Ash7shaSampleApplication application for production, run:

    ./mvnw -Pprod clean package

To ensure everything worked, run:

    java -jar target/*.war


Refer to [Using Ash7sha in production][] for more details.

## Testing

To launch your application's tests, run:

    ./mvnw clean test

For more information, refer to the [Running tests page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your Ash7sha development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

    docker-compose -f src/main/docker/mysql.yml up -d

To stop it and remove the container, run:

    docker-compose -f src/main/docker/mysql.yml down

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

    ./mvnw verify -Pprod dockerfile:build dockerfile:tag@version dockerfile:tag@commit

Then run:

    docker-compose -f src/main/docker/app.yml up -d

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`Ash7sha docker-compose`), which is able to generate docker configurations for one or several Ash7sha applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`Ash7sha ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration][] page for more information.

[Ash7sha Homepage and latest documentation]: https://www.Ash7sha.tech
[Ash7sha 5.2.1 archive]: https://www.Ash7sha.tech/documentation-archive/v5.2.1
[Doing microservices with Ash7sha]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/microservices-architecture/
[Using Ash7sha in development]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/development/
[Service Discovery and Configuration with the Ash7sha-Registry]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/microservices-architecture/#Ash7sha-registry
[Using Docker and Docker-Compose]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/docker-compose
[Using Ash7sha in production]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/production/
[Running tests page]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/running-tests/
[Setting up Continuous Integration]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/setting-up-ci/


[OpenAPI-Generator]: https://openapi-generator.tech
[Swagger-Editor]: http://editor.swagger.io
[Doing API-First development]: https://www.Ash7sha.tech/documentation-archive/v5.2.1/doing-api-first-development/

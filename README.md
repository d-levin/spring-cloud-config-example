# java-spring-cloud-config-example

Spring Cloud Config Server reads a configuration from a _git_ repository.
The repository can be located on the local machine.

To run this project, initialize a _git_ repository in `config-repo`:

```bash
cd config-repo/
git init
```

Then commit the content:

```bash
git commit -m "Initial commit"
```

Update the location of the `config-repo` directory 
in `config-server/src/main/resources/application.yml`
```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: file://abs/path/to/config-repo
```

## Build and Run `config-server`
Runs on port 8888

```bash
cd config-server/
mvn clean install
mvn spring-boot:run
```

## Build and Run `config-client`
Runs on port 9001

```bash
cd config-client/
mvn clean install
mvn spring-boot:run
```

If the client is run without specifying a profile, the configuration
in `config-client.yml` will be used.
Some properties are not defined in the default file. To access these properties, the
config-client needs to be run with a different profile, e.g. `dev` or `prod`.
Both the default configuration and the profile-specific configuration will be loaded.

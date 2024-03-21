# quarkus-demo-jwt-producer

Quarkus demo project showing how to : 
- produce a jwt
- create a rest client
- consume a jwt

## Project creation

```bash
mvn io.quarkus:quarkus-maven-plugin:3.8.3:create \
-DprojectGroupId=org.fugerit.java.demo \
-DprojectArtifactId=quarkus-demo-jwt-producer \
-Dextensions='resteasy-reactive-jackson,quarkus-arc,quarkus-config-yaml,junit5,smallrye-jwt-build'
```
## Requirement

- java 21+
- maven 3.9.6+

## Quickstart

1. Open first terminal

```bash
clone https://github.com/fugerit-sec/quarkus-demo-jwt-consumer
cd quarkus-demo-jwt-consumer
mvn quarkus:dev
```

2. open second terminal

```bash
clone https://github.com/fugerit-sec/quarkus-demo-jwt-producer
cd quarkus-demo-jwt-producer
mvn quarkus:dev
```

3. open third terminal

```bash
curl -X 'GET' \
  'http://localhost:8082/produce/jwt/tux' \
  -H 'accept: */*';echo
```

## Documentation

[Quarkus security JWT](https://quarkus.io/guides/security-jwt)

Especially key creation : 

```bash
openssl genrsa -out rsaPrivateKey.pem 2048
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem
```
[Quarkus security JWT Build](https://quarkus.io/guides/security-jwt-build)


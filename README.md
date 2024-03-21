# quarkus-demo-jwt-producer

Quarkus Demo JWT Producer

## Project creation

```bash
mvn io.quarkus:quarkus-maven-plugin:3.8.3:create \
-DprojectGroupId=org.fugerit.java.demo \
-DprojectArtifactId=quarkus-demo-jwt-producer \
-Dextensions='resteasy-reactive-jackson,quarkus-arc,quarkus-config-yaml,junit5,smallrye-jwt-build'
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
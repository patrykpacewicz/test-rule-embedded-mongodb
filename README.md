test-rule-embedded-mongodb
==========================

[![Build Status](https://travis-ci.org/patrykpacewicz/test-rule-embedded-mongodb.svg)](https://travis-ci.org/patrykpacewicz/test-rule-embedded-mongodb)

test-rule-embedded-mongodb is a jUnit @ClassRule wrapper of 
[de.flapdoodle.embed.mongo](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo)
supporting jUnit and Spock. 

At the beginning of the tests it fires mongoDb server and when the tests come to an end it stops mongoDb.

Binaries
--------

Example for Mavan:

```xml
<dependency>
  <groupId>pl.patrykpacewicz</groupId>
  <artifactId>test-rule-embedded-mongodb</artifactId>
  <version>0.1.0</version>
  <scope>test</scope>
</dependency>
```

and for Gradle:

```groovy
repositories {
    jcenter()
}
dependencies {
    testCompile 'pl.patrykpacewicz:test-rule-embedded-mongodb:0.1.0'
}
```

How to use
----------

The following examples in jUnit and Spock shows how to use test-rule-embedded-mongodb.
If you need a more accurate test cases look insite the `src/test` directory

#### jUnit

```java
class ExampleSpockSpec extends Specification {
    @Shared @ClassRule
    EmbeddedMongoDbRule embeddedMongoDbRule

    [...]
}
```

#### Spock framework

```groovy
public class ExampleJunitTest {

    @ClassRule
    public static EmbeddedMongoDbRule embeddedMongoDbRule = new EmbeddedMongoDbRule();
    
    [...]
}
```

Supported parameters
--------------------

EmbeddedMongoDbRule class supports setting port and mongoDb version

```java
embeddedMongoDbRule.setPort(...)
embeddedMongoDbRule.setVersion(...)
```

package pl.patrykpacewicz.test.rule
import com.mongodb.MongoClient
import de.flapdoodle.embed.mongo.distribution.Version
import org.junit.ClassRule
import spock.lang.Shared
import spock.lang.Specification

class EmbeddedMongoDbRuleNotDefaultSpec extends Specification {

    @Shared @ClassRule
    EmbeddedMongoDbRule embeddedMongoDbRule = new EmbeddedMongoDbRule()
        .setPort(55546)
        .setVersion(Version.Main.V2_6)

    def "should run embedded mongoDb with setted port and version"() {
        given:
        def mongoClient = new MongoClient("localhost", 55546);

        expect:
        !mongoClient.databaseNames.empty
    }

    def "should store version" () {
        expect:
        embeddedMongoDbRule.version == Version.Main.V2_6
    }

    def "should store port" () {
        expect:
        embeddedMongoDbRule.port == 55546
    }
}

package pl.patrykpacewicz.test.rule
import com.mongodb.MongoClient
import de.flapdoodle.embed.mongo.distribution.Version
import org.junit.ClassRule
import spock.lang.Shared
import spock.lang.Specification

class EmbeddedMongoDbRuleSpec extends Specification {

    @Shared @ClassRule
    EmbeddedMongoDbRule embeddedMongoDbRule

    def "should run embedded mongoDb"() {
        given:
        def mongoClient = new MongoClient("localhost", embeddedMongoDbRule.getPort());

        expect:
        !mongoClient.databaseNames.empty
    }

    def "should set default version to PRODUCTION" () {
        expect:
        embeddedMongoDbRule.version == Version.Main.PRODUCTION
    }

    def "should set default port to 27017" () {
        expect:
        embeddedMongoDbRule.port == 27017
    }
}

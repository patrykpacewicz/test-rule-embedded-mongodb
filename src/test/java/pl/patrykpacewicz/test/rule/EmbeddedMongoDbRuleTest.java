package pl.patrykpacewicz.test.rule;

import com.mongodb.MongoClient;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmbeddedMongoDbRuleTest {

    @ClassRule
    public static EmbeddedMongoDbRule embeddedMongoDbRule = new EmbeddedMongoDbRule();

    @Test
    public void shouldRunEmbeddedMongoDb() throws Exception {
        //given:
        MongoClient mongoClient = new MongoClient("localhost", embeddedMongoDbRule.getPort());

        //expect:
        assertThat(mongoClient.getDatabaseNames()).isNotEmpty();
    }
}
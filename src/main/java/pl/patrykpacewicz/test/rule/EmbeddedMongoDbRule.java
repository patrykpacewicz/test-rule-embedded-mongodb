package pl.patrykpacewicz.test.rule;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.IFeatureAwareVersion;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.rules.ExternalResource;

import java.io.IOException;

public class EmbeddedMongoDbRule extends ExternalResource {
    private MongodExecutable mongodExecutable;
    private Integer port = 27017;
    private IFeatureAwareVersion version = Version.Main.PRODUCTION;

    @Override
    protected void before() throws Throwable {
        mongodExecutable = MongodStarter.getDefaultInstance().prepare(buildMongodConfig());
        mongodExecutable.start();
    }

    @Override
    protected void after() {
        if (mongodExecutable != null) mongodExecutable.stop();
    }

    private IMongodConfig buildMongodConfig() throws IOException {
        return new MongodConfigBuilder()
                .version(version)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();
    }

    public EmbeddedMongoDbRule setPort(Integer port) {
        this.port = port;
        return this;
    }

    public EmbeddedMongoDbRule setVersion(IFeatureAwareVersion version) {
        this.version = version;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public IFeatureAwareVersion getVersion() {
        return version;
    }
}

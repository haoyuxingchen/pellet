package com.clarkparsia.pellet.server;

import com.clarkparsia.pellet.server.protege.ProtegeServerTest;
import com.clarkparsia.pellet.server.protege.model.ProtegeServerState;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;
import org.junit.After;
import org.junit.Before;
import org.protege.owl.server.api.client.Client;

/**
 * @author Edgar Rodriguez-Diaz
 */
public abstract class PelletServerTest extends ProtegeServerTest {

	protected static Injector injector;
	protected static PelletServer pelletServer;

	protected Client mClient;

	public void startPelletServer(String... ontologies) throws Exception {
		pelletServer = new PelletServer(Guice.createInjector(Modules.override(new PelletServerModule())
		                                                            .with(new TestModule(ontologies))));
		pelletServer.start();
	}

	@Before
	public void before() throws Exception {
		super.before();

		mClient = provideClient();
	}

	public void stopPelletServer() {
		pelletServer.stop();
		pelletServer = null;
	}

	public abstract Client provideClient() throws Exception;

	@After
	public void after() {
		stopPelletServer();
		super.after();
	}

}

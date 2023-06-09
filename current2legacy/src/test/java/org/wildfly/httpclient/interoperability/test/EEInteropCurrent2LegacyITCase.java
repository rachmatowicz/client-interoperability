package org.wildfly.httpclient.interoperability.test;

import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.jboss.ejb.client.EJBClient;
import org.jboss.ejb.client.StatelessEJBLocator;
import org.jboss.ejb.client.URIAffinity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URI;

/**
 * A test to exercise javax to jakarta interactions.
 * This test does the following:
 *
 * @author rachmato@redhat.com
 */
@RunWith(BMUnitRunner.class)
@BMUnitConfig(debug = true, verbose = true, bmunitVerbose = true)
public class EEInteropCurrent2LegacyITCase {
    private static final String APP = "";
    private static final String MODULE = "sampleApp-ee8-1.0-SNAPSHOT";
    private static final String BEAN = "StatelessIncrementorBean";

    private final String JBOSS_NODE_NAME = "legacy-server";

    @Test
    @BMScript(value="current-client.btm", dir="target/test-classes/byteman")
    public void testCurrent2LegacyInteroperation() throws Exception {
        System.out.println("EEInteropCurrent2LegacyITCase:testCurrent2LegacyInteroperation (version 2.0.2.Final)");

        final StatelessEJBLocator<Incrementor> statelessEJBLocator = new StatelessEJBLocator<>(Incrementor.class, APP, MODULE, BEAN, "");
        final Incrementor proxy = (Incrementor) EJBClient.createProxy(statelessEJBLocator);
        EJBClient.setStrongAffinity(proxy, URIAffinity.forUri(new URI("http://localhost:8080/wildfly-services")));

        int count = 0;
        Result<Integer> retVal = null;

        // first message, handshake initialization, decide marshallers/unmarshallers
        retVal = proxy.increment();
        Assert.assertEquals("Unexpected node", JBOSS_NODE_NAME, retVal.getNode());

        // second message, handshake completion, agree on marshallers/unmarshallers
        retVal = proxy.increment();
        Assert.assertEquals("Unexpected node", JBOSS_NODE_NAME, retVal.getNode());

        // third message message, stable marshallers/unmarshallers
        retVal = proxy.increment();
        Assert.assertEquals("Unexpected node", JBOSS_NODE_NAME, retVal.getNode());
    }

}

package org.wildfly.httpclient.interoperability.test;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateful;

/**
 * A stateful version of the incrementor bean
 */
@Stateful
@Remote(Incrementor.class)
public class StatefulIncrementorBean extends IncrementorBean {
}

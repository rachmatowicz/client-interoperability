package org.wildfly.httpclient.interoperability.test;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * A stateful version of the incrementor bean
 */
@Stateful
@Remote(Incrementor.class)
public class StatefulIncrementorBean extends IncrementorBean {
}

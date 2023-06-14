package org.wildfly.httpclient.interoperability.test;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * A stateless version of the incrementor bean
 */
@Stateless
@Remote(Incrementor.class)
public class StatelessIncrementorBean extends IncrementorBean {
}

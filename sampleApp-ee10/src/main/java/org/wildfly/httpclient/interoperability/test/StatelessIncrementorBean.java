package org.wildfly.httpclient.interoperability.test;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

/**
 * A stateless version of the incrementor bean
 */
@Stateless
@Remote(Incrementor.class)
public class StatelessIncrementorBean extends IncrementorBean {
}

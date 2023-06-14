package org.wildfly.httpclient.interoperability.test;

import javax.ejb.Remove;
public interface Incrementor {

    Result<Integer> increment();

    @Remove
    default void remove() {
        // do nothing
    }
}

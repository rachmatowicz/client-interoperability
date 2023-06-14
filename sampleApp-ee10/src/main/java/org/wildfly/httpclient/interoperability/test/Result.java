package org.wildfly.httpclient.interoperability.test;

import java.io.Serializable;

/**
 *A wrapper for a return value that includes the node on which the result was generated.
 * @author Paul Ferraro
 */
public class Result<T> implements Serializable {
    final T value;
    final String node;

    public Result(T value) {
        this.value = value;
        this.node = System.getProperty("jboss.node.name");
    }

    public T getValue() {
        return value;
    }

    public String getNode() {
        return node;
    }
}

package hello.proxy.purepoxy.concreteproxy;

import hello.proxy.purepoxy.concreteproxy.code.ConcreateLogic;
import hello.proxy.purepoxy.concreteproxy.code.ConcreteClient;
import hello.proxy.purepoxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreateLogic concreateLogic = new ConcreateLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreateLogic);

        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreateLogic concreateLogic = new ConcreateLogic();
        TimeProxy timeProxy = new TimeProxy(concreateLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}

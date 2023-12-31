package hello.proxy.purepoxy.proxy;

import hello.proxy.purepoxy.proxy.code.CacheProxy;
import hello.proxy.purepoxy.proxy.code.ProxyPatternClient;
import hello.proxy.purepoxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.excute();
        client.excute();
        client.excute();
    }

    @Test
    void cacheProxyTest() {

        RealSubject realSubject = new RealSubject();

        CacheProxy cacheProxy = new CacheProxy(realSubject);

        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.excute();
        client.excute();
        client.excute();
    }

}

package hello.proxy.purepoxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {

        log.info("Call Proxy");

        if (cacheValue == null) {
            cacheValue = target.operation();
        }

        return cacheValue;
    }
}

package hello.proxy.purepoxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreateLogic {

    public String operation() {
        log.info("ConcreteLogic 실행");
        return "data";
    }
}

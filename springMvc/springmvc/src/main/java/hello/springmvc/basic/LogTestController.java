package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){

        //log.trace("trace log=" +"spring"); 연산이 먼저 진행되어 메모리, cpu사용이 발생함.
        log.trace("trace log={}"+"spring");
        log.debug("debug log={}", "spring");

        log.info("info log={}", "spring");
        log.warn("warn log={}", "spring");
        log.error("error log={}", "spring");

        return "ok";
    }
}

package hello.typeconvert.converter;

import hello.typeconvert.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String , IpPort> {

    @Override
    public IpPort convert(String source){
        log.info("convert cource = {}", source);

        //"127.0.0.1:8080 -> ipPort 객체
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.valueOf(split[1]);

        return new IpPort(ip, port);
    }
}

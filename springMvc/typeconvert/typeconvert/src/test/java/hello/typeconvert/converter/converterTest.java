package hello.typeconvert.converter;
import hello.typeconvert.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class converterTest {

    @Test
    void StringToInteger(){
        StringToIntegerConverter con = new StringToIntegerConverter();
        Integer result = con.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString(){
        IntegerToStringConverter con = new IntegerToStringConverter();
        String result = con.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort(){
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.2", 8080);
        String result = converter.convert(ipPort);
        assertThat(result).isEqualTo("127.0.0.2:8080");
    }

    @Test
    void ipPortToString(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.2:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.2",8080));
    }
}

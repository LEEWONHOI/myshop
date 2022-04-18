package leewonhoi.myshop.web.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberFormatterTest {

    NumberFormatter numberFormatter = new NumberFormatter();

    @Test
    public void parse() throws Exception {
        // when
        Number result = numberFormatter.parse("1,000", Locale.KOREA);

        // then
        assertThat(result).isEqualTo(1000L);

    }

    @Test
    public void print() throws Exception {
        // when
        String result = numberFormatter.print(1000, Locale.KOREA);

        // then
        assertThat(result).isEqualTo("1,000");
    }

}
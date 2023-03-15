package ru;

//import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import ru.model.Ticket;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void checkGettingJson() throws IOException {
        List<Ticket> list = JsonReader.getTickets();
        list.forEach(System.out::println);
       assertThat(list).hasSize(2);
    }
}


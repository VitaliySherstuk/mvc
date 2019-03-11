package beans.configuration;

import beans.daos.AuditoriumDAO;
import beans.daos.mocks.DBAuditoriumDAOMock;
import beans.models.Auditorium;
import beans.services.AuditoriumService;
import beans.services.AuditoriumServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;


@Configuration
public class TestAuditoriumConfiguration {

    @Bean
    public Auditorium testHall1() {
        return new Auditorium(1, "Test auditorium", 15, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Bean
    public Auditorium testHall2() {
        return new Auditorium(2, "Test auditorium 2", 8, Collections.singletonList(1));
    }

    @Bean
    public AuditoriumDAO auditoriumDAOMock() {
        return new DBAuditoriumDAOMock(Arrays.asList(testHall1(), testHall2()));
    }

    @Bean
    public AuditoriumService auditoriumServiceImpl() {
        return new AuditoriumServiceImpl(auditoriumDAOMock());
    }
}

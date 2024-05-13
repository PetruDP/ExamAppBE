package com.imeghebe.jwt.backend.schedule;

import com.imeghebe.jwt.backend.facade.MovieFacade;
import com.imeghebe.jwt.backend.feign.ImdbClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MoviesScheduler {

    @Value("${imdb.feign.header1}")
    private String header1;
    @Value("${imdb.feign.header2}")
    private String header2;

    private final Logger LOG = LoggerFactory.getLogger(MoviesScheduler.class);
    private final ImdbClient imdbClient;
    private final MovieFacade movieFacade;

    //    @Scheduled(cron = "0 0 0 1 1 *") // At midnight on January 1st
    @Scheduled(cron = "0 */2 * * * *")
    public void fetchTop100FromImdb() {
        LOG.info("Starting scheduler - 'imdb top 100'");
        long start = System.currentTimeMillis();

        movieFacade.updateTop100(imdbClient.getIMDBTop100(header1, header2));

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        LOG.info("Successfully executed - 'fetch top 100 from imdb' in " + timeElapsed + " ms.");
    }


}

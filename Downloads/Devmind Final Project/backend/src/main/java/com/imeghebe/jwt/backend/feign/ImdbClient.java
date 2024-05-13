package com.imeghebe.jwt.backend.feign;

import com.imeghebe.jwt.backend.dtos.ImdbMovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "imdb-service", url = "${imdb.feign.url}")
public interface ImdbClient {

    @GetMapping()
    List<ImdbMovieDTO> getIMDBTop100(@RequestHeader("X-RapidAPI-Key") String api_key_1,
                                     @RequestHeader("X-RapidAPI-Host") String api_key_2);

}

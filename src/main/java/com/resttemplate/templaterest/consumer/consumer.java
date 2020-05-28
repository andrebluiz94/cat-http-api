package com.resttemplate.templaterest.consumer;

import com.resttemplate.templaterest.model.GitHub;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@RestController
@RequestMapping("/racas")
public class consumer {

    //e7941d37-86e2-4ef2-bdbb-aca6258bdb80

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> lista() {
        RestTemplate template = new RestTemplateBuilder()
                .rootUri("https://api.thecatapi.com/v1")
                .build();

        //cria o header
        HttpHeaders headers = new HttpHeaders();

        String authToken = "e7941d37-86e2-4ef2-bdbb-aca6258bdb80";

        //headers.set("", );

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("x-api-key", authToken);

        ResponseEntity<String> cats = template.exchange(
                "/breeds",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                String.class);


        return ResponseEntity.ok(cats);
    }
}

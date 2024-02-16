package com.rp.zadanie.controller;


import com.rp.zadanie.RepoProvider.Repo;
import com.rp.zadanie.RepoProvider.RepoProvider;
import lombok.Data;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Data
@RestController
public class GithubController {


    private final RepoProvider repoProvider;

    @GetMapping("/repositories/{username}")
    public ResponseEntity<?> getRepositories(@PathVariable String username) {

        List<Repo> repositories = repoProvider.getRepositories(username);
        if(repositories.isEmpty() || repositories == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "User not found"));
        }

            return ResponseEntity.ok(repositories);
    }


}

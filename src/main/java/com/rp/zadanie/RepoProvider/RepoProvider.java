package com.rp.zadanie.RepoProvider;

import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Data
@Service
public class RepoProvider {

    private final RestTemplate restTemplate;

    public List<Repo> getRepositories(String username) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>("parameters", httpHeaders);

        List<Repo> repositories = restTemplate.exchange("https://api.github.com/users/"+username+"/repos",
                HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Repo>>() {
                }).getBody();

        repositories = getBranchesForRepos(repositories, httpEntity);

        return repositories;
    }

    private List<Repo> getBranchesForRepos(List<Repo> repos, HttpEntity<String> httpEntity){
        for (Repo repo: repos){

            List<Branch> branches = restTemplate.exchange("https://api.github.com/repos/"
                            + repo.getOwner().getLogin() +
                            "/"+repo.getName()+"/branches",
                    HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Branch>>() {
                    }).getBody();

            repo.setBranches(branches);

        }
        return repos;
    }


}
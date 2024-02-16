package com.rp.zadanie;

import com.rp.zadanie.RepoProvider.Owner;
import com.rp.zadanie.RepoProvider.Repo;
import com.rp.zadanie.RepoProvider.RepoProvider;
import com.rp.zadanie.controller.GithubController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class GithubControllerTests {

	@Mock
	private RepoProvider repoProvider;

	@InjectMocks
	private GithubController githubController;

	@Test
	public void getRepositoriesReturnsRepositories() {

		when(repoProvider.getRepositories("user")).
				thenReturn(Collections.singletonList(
				new Repo("repo1", new Owner("user"))
		));

		ResponseEntity<?> responseEntity = githubController.getRepositories("user");

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getRepositoriesReturnsNotFound() {

		when(repoProvider.getRepositories("nouser")).thenReturn(Collections.emptyList());

		ResponseEntity<?> responseEntity = githubController.getRepositories("nouser");
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}



}

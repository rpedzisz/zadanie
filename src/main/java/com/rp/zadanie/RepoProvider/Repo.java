package com.rp.zadanie.RepoProvider;

import lombok.Data;

import java.util.List;

@Data
public class Repo {
    private String name;
    private Owner owner;
    private List<Branch> branches;

    public Repo(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }
}

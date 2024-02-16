package com.rp.zadanie.RepoProvider;

import lombok.Data;

@Data
public class Branch {
    private String name;
    private Commit commit;
}

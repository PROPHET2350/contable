package com.contable.account.security.domain;

import com.contable.account.companies.domain.Company;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account_user", schema = "PUBLIC")
public class User {
    @Id
    private String id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "account_users_companies",
            schema = "PUBLIC",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
    private Set<Company> companies = new HashSet<>();

    protected User() {
    }

    public User(String id, String username, String password, Set<Company> companies) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.companies = companies;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company) {
        if (!this.companies.contains(company)) {
            this.companies.add(company);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", companies=" + companies.size() +
                '}';
    }
}

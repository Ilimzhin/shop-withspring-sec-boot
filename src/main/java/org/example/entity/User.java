package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String email;
    private String age;
    private String sex;

    public String getAuthorName() {
        if (author != null) {
            return author.getUsername();
        } else return "<none>";
//        return author != null ? author.getUsername() : "<none>";
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_security_id")
    private UserSecurity author;

}

package org.example.repo;

import org.example.entity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurityRepo extends JpaRepository<UserSecurity, Long> {
    UserSecurity findByUsername(String username);
}

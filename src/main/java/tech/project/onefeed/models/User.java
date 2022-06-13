package tech.project.onefeed.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.project.onefeed.models.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User extends AbstractEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    private String username;
    
    @NotNull
    private String email;

    @NotNull
    private String pwHash;
    
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {}
    
    public User(String username, String email, String Pass) {
	   this.username = username;
       this.email = email;
	   this.pwHash = encoder.encode(Pass);
    }
    
    public String getUsername() {
	   return username;
    }

    
   
// Salting carried out by encoder.matches() before comparison
    public boolean isMatchingPassword(String Pass) {
        return encoder.matches(Pass, pwHash);
    }
}
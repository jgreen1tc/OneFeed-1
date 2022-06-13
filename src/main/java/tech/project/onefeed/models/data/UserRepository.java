package tech.project.onefeed.models.data;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import tech.project.onefeed.models.User;

public interface UserRepository extends CrudRepository<User, UUID> {

    User findByUsername(String username);
 
 }
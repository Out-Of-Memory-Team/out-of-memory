package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}

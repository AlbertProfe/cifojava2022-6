package io.company.repository;

import io.company.model.RareBook;
import org.springframework.data.repository.CrudRepository;

public interface RareBookRepository extends CrudRepository<RareBook, Long> {
}

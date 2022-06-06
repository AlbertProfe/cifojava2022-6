package io.company.repository;

import io.company.model.BookItem;
import org.springframework.data.repository.CrudRepository;

public interface BookItemRepository extends CrudRepository<BookItem, Long> {

}

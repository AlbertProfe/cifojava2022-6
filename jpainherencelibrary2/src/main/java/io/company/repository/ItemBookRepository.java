package io.company.repository;

import io.company.model.ItemBook;
import org.springframework.data.repository.CrudRepository;

public interface ItemBookRepository extends CrudRepository<ItemBook, Long> {

}

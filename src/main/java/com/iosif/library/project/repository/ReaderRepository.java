package com.iosif.library.project.repository;

import com.iosif.library.project.model.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {

}

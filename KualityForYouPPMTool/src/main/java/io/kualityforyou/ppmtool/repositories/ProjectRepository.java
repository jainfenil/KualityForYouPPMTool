package io.kualityforyou.ppmtool.repositories;

import io.kualityforyou.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAll();

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}

package com.aplicatie_donare_de_sange.centru_de_donare.Repository;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.Programare;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramarePaginationRepository extends PagingAndSortingRepository<Programare,Long> {
}

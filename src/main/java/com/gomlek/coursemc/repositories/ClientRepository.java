package com.gomlek.coursemc.repositories;


import com.gomlek.coursemc.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    @Transactional(readOnly = true)
    Client findByEmail(String email);//busca no banco de dados um client passando email como argumento
}

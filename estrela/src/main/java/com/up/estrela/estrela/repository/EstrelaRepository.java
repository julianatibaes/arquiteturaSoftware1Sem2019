package com.up.estrela.estrela.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.up.estrela.estrela.entity.Estrela;

/*
 * A interface central na abstração do repositório Spring Data
 *  é Repository (provavelmente não é uma grande surpresa). 
 *  Leva a classe de domínio para gerenciar, bem como o tipo de 
 *  id da classe de domínio como argumentos de tipo. Essa interface 
 *  age principalmente como uma interface de marcação para capturar os 
 *  tipos com os quais trabalhar e para ajudá-lo a descobrir as 
 *  interfaces que a estendem. O CrudRepository fornece funcionalidade 
 *  CRUD sofisticada para a classe de entidade que está sendo gerenciada.
 *  
 *  https://docs.spring.io/spring-data/jpa/docs/1.4.0.M1/reference/html/repositories.html
 */
public  interface EstrelaRepository extends JpaRepository<Estrela, String>{

}


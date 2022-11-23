package com.example.bank.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.models.UserCastomCard;

/**
 *
 * @author npyatak
 * @since 13.10.2022
 */
public interface CardRepository extends CrudRepository<UserCastomCard, Long>
{
}

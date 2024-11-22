package iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}

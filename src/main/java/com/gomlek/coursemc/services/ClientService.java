package com.gomlek.coursemc.services;

import java.util.List;
import java.util.Optional;

import com.gomlek.coursemc.dto.ClientDTO;
import com.gomlek.coursemc.dto.ClientNewDTO;
import com.gomlek.coursemc.entities.Address;
import com.gomlek.coursemc.entities.City;
import com.gomlek.coursemc.entities.Client;
import com.gomlek.coursemc.entities.enums.ClientType;
import com.gomlek.coursemc.repositories.AddressRepository;
import com.gomlek.coursemc.repositories.CityRepository;
import com.gomlek.coursemc.repositories.ClientRepository;
import com.gomlek.coursemc.services.exceptions.DataIntegrityException;
import com.gomlek.coursemc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client find(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not Found! Id: " + id + ", type: " + Client.class.getName()));
	}
	
	@Transactional
	public Client insert(Client obj){
		obj.setId(null);
		obj = repository.save(obj);
		addressRepository.saveAll(obj.getAddress());
		return obj;
	}

	public Client update(Client obj){
		Client newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

    public void delete(Long id) {
		find(id);
		try{
		repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Its is not possible to exclude a Client with Products ");
		}
    }

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	} 

	public Client fromDTO(ClientDTO objDto){
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}

	public Client fromDTO(ClientNewDTO objDto){
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOuCpnj(), ClientType.toEnum(objDto.getType()));
		City cid = new City(objDto.getCidadeId(), null, null);
		Address end = new Address(null, objDto.getPublicPlace(),objDto.getNumber(), objDto.getComplement(), objDto.getDistrict(), objDto.getCep(), cli, cid);
		cli.getAddress().add(end);
		cli.getPhones().add(objDto.getPhoneOne());
		if(objDto.getPhoneTwo()!= null){
			cli.getPhones().add(objDto.getPhoneTwo());
		}
		if(objDto.getPhoneTree()!= null){
			cli.getPhones().add(objDto.getPhoneTree());
		}

		return cli;
	}

	private void updateData(Client newObj, Client obj){
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}

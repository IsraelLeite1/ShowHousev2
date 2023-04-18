package com.qintess.spring.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Role;
import com.qintess.spring.repositories.ClientRepository;

@Service
public class ClientService implements UserDetailsService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<Client> getClients() {
		return repository.findAll();
	}

	public void saveOrUpdateClient(Client client) {
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		
		
		
		repository.save(client);
	}

	public Client getClient(long id) {
		Optional<Client> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteClient(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client deletedClient = obj.get();
		repository.delete(deletedClient);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Client> clients = repository.findAll();
		Client client = null;
		for (Client c : clients) {
			if(c.getUsername().equals(userName))
				client = c;
		}
		if (client == null) {
			throw new RuntimeException();
		}
		return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(),
				mapRolesToAuthorities(client.getRoles()));
	}
	
	public Client findByUsername(String username) {
		List<Client> clients = repository.findAll();
		Client client = null;
		for (Client c : clients) {
			if(c.getUsername().equals(username))
				client = c;
		}
		if (client == null) {
			throw new RuntimeException();
		}
		return client;
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}

package com.sip.services;

import com.sip.entities.Provider;
import com.sip.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

	@Autowired
    public ProviderService(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders(){
        return (List<Provider>)providerRepository.findAll();
    }

    public Provider persistProvider(Provider provider){
        return this.providerRepository.save(provider);
    }

}

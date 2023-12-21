package com.version1.lapierrenoble.prospect;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProspectService {

    private ProspectRepository prospectRepository;

    public ProspectService(ProspectRepository prospectRepository){
        this.prospectRepository = prospectRepository;
    }

    public List<Prospect> findAll() {
        return prospectRepository.findAll();
    }


    public Optional<Prospect> findById(Integer id) {
        return prospectRepository.findById(id);
    }



    public boolean createProspect(Prospect prospect) {

        Prospect save = prospectRepository.save(prospect);
        return true;
    }
}

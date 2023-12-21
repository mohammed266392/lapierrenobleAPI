package com.version1.lapierrenoble.prospect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @GetMapping("prospects")
    public List<Prospect> retrieveProspects(){
        return prospectService.findAll();
    }


    @PostMapping("prospects")

    public boolean createProspect(@RequestBody Prospect prospect){

        return  prospectService.createProspect(prospect);
    }
}

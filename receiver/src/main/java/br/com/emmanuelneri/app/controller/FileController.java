package br.com.emmanuelneri.app.controller;

import br.com.emmanuelneri.app.DTO.FileDTO;
import br.com.emmanuelneri.app.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.POST)
    public void receive(@RequestBody FileDTO file) {
        fileService.receive(file);
    }

}

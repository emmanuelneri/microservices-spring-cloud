package br.com.emmanuelneri.app.service;

import br.com.emmanuelneri.app.DTO.FileDTO;
import br.com.emmanuelneri.app.component.FileQueue;
import br.com.emmanuelneri.app.model.File;
import br.com.emmanuelneri.app.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileQueue fileQueue;

    public void receive(FileDTO file) {
        final File fileSaved = save(file);
        fileQueue.send(fileSaved);
    }

    private File save(FileDTO file) {
        return fileRepository.save(new File(file.getName(), file.getBody()));
    }

}

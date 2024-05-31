package com.example.practice22.Service;

import com.example.practice22.DTO.ManufactureDTO;
import com.example.practice22.DTO.PhoneDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class FileService {
    @Autowired
    ManufactureService manufactureService;
    @Autowired
    PhoneService phoneService;


    @Async
    @Scheduled(fixedDelay = 1000000)
    public void backupData(){
        System.out.println("backup");
        clear();
        saveDataToFiles();
    }

    public void clear(){
        System.out.println("clear");
        try {
            FileWriter fileWriter = new FileWriter("src/practice22/files/manufactures.txt", false);
            fileWriter.write("");
            fileWriter.close();

            fileWriter = new FileWriter("src/practice22/files/phones.txt", false);
            fileWriter.write("");
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void saveDataToFiles(){
        System.out.println("save");
        try {
            FileWriter fileWriter = new FileWriter("src/practice22/files/manufactures.txt", false);
            List<ManufactureDTO> manufactureList = manufactureService.getAllManufacturesForBackup();
            for(ManufactureDTO manufacture: manufactureList)
                fileWriter.write(manufacture.toString() + "\n");
            fileWriter.close();

            fileWriter = new FileWriter("src/practice22/files/phones.txt", false);
            List<PhoneDTO> phoneList = phoneService.getAllPhones();
            for(PhoneDTO phone: phoneList)
                fileWriter.write(phone.toString() + '\n');
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}

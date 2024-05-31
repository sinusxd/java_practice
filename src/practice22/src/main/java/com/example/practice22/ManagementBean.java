package com.example.practice22;

import com.example.practice22.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Component
@ManagedResource(objectName = "com.example:type=com.example.practice22.ManagementBean", description = "Management Bean")
public class ManagementBean {
    @Autowired
    private FileService fileService;


    public void registerMBean() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.example.practice22:type=ManagementBean");
            mbs.registerMBean(this, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @ManagedOperation(description = "backup")
    public void backup(){
        fileService.backupData();
    }
}

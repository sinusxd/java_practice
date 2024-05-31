package com.example.practice24.Service;

import com.example.practice24.DTO.ManufactureDTO;
import com.example.practice24.Entity.Manufacture;
import com.example.practice24.Repository.ManufactureRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ManufactureServiceTest {

    @Mock
    private ManufactureRepo manufactureRepo;

    @InjectMocks
    private ManufactureService manufactureService;

    private Manufacture manufacture;
    private ManufactureDTO manufactureDTO;

    @BeforeEach
    public void setup() {
        manufacture = new Manufacture("test", "address"); // Здесь нужно правильно инициализировать поля, если они есть
        manufacture.setId(1L);
        manufactureDTO = new ManufactureDTO(manufacture);
    }

    @Test
    public void testAddManufacture() {
        when(manufactureRepo.save(any(Manufacture.class))).thenReturn(manufacture);
        String response = manufactureService.addManufacture(manufactureDTO);
        assertEquals("Мануфактура успешно добавлена!", response);
        verify(manufactureRepo).save(any(Manufacture.class));
    }

    @Test
    public void testGetManufactureFound() throws Exception {
        when(manufactureRepo.findById(1L)).thenReturn(Optional.of(manufacture));
        ManufactureDTO found = manufactureService.getManufacture(1L);
        assertEquals(manufactureDTO, found);
    }

    @Test
    public void testGetManufactureNotFound() {
        when(manufactureRepo.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(Exception.class, () -> {
            manufactureService.getManufacture(1L);
        });
        assertEquals("Мунафактура с id: 1 не найдена!", exception.getMessage());
    }

    @Test
    public void testGetAllManufactures() {
        when(manufactureRepo.findAll()).thenReturn(Arrays.asList(manufacture));
        List<ManufactureDTO> manufactureDTOS = manufactureService.getAllManufactures();
        assertFalse(manufactureDTOS.isEmpty());
        assertEquals(1, manufactureDTOS.size());
        assertEquals(manufactureDTO, manufactureDTOS.get(0));
    }

    @Test
    public void testRemoveManufactureSuccessful() throws Exception {
        when(manufactureRepo.findById(1L)).thenReturn(Optional.of(manufacture));
        doNothing().when(manufactureRepo).deleteById(1L);
        String response = manufactureService.removeManufacture(1L);
        assertEquals("Мануфактура с id: 1 удалена!", response);
    }

    @Test
    public void testRemoveManufactureNotFound() {
        when(manufactureRepo.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(Exception.class, () -> {
            manufactureService.removeManufacture(1L);
        });
        assertEquals("Мануфактура с id: 1 не найдена!", exception.getMessage());
    }
}

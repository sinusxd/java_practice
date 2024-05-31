package com.example.practice24.Service;

import com.example.practice24.DTO.PhoneDTO;
import com.example.practice24.Entity.Manufacture;
import com.example.practice24.Entity.Phone;
import com.example.practice24.Repository.PhoneRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PhoneServiceTest {

    @Mock
    private PhoneRepo phoneRepo;

    @InjectMocks
    private PhoneService phoneService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPhoneTest() {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(1L);
        phoneDTO.setName("Test Phone");
        phoneDTO.setManufactureId(2L);

        Phone phone = new Phone();
        phone.setId(phoneDTO.getId());
        phone.setName(phoneDTO.getName());
        Manufacture manufacture = new Manufacture();
        manufacture.setId(phoneDTO.getManufactureId());
        phone.setManufacture(manufacture);

        when(phoneRepo.save(any(Phone.class))).thenReturn(phone);

        String response = phoneService.addPhone(phoneDTO);
        assertEquals("Телефон успешно добавлен!", response);
        verify(phoneRepo).save(any(Phone.class));
    }

    @Test
    void getPhoneFoundTest() throws Exception {
        Long id = 1L;
        Phone phone = new Phone();
        phone.setId(id);
        when(phoneRepo.findById(id)).thenReturn(Optional.of(phone));

        Phone result = phoneService.getPhone(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void getPhoneNotFoundTest() {
        Long id = 1L;
        when(phoneRepo.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> phoneService.getPhone(id));
        assertEquals("Телефон с id: " + id + " не найден!", exception.getMessage());
    }

    @Test
    void getAllPhonesTest() {
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setName("Test Phone");
        Iterable<Phone> phoneIterable = Arrays.asList(phone);
        when(phoneRepo.findAll()).thenReturn(phoneIterable);

        List<PhoneDTO> phones = phoneService.getAllPhones();
        assertFalse(phones.isEmpty());
        assertEquals(1, phones.size());
        assertEquals("Test Phone", phones.get(0).getName());
    }

    @Test
    void removePhoneSuccessfulTest() throws Exception {
        Long id = 1L;
        Phone phone = new Phone();
        phone.setId(id);
        when(phoneRepo.findById(id)).thenReturn(Optional.of(phone));
        doNothing().when(phoneRepo).deleteById(id);

        String response = phoneService.removePhone(id);
        assertEquals("Телефон с id: " + id + " удалён!", response);
        verify(phoneRepo).deleteById(id);
    }

    @Test
    void removePhoneNotFoundTest() {
        Long id = 1L;
        when(phoneRepo.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> phoneService.removePhone(id));
        assertEquals("Телефон с id: " + id + " не найден!", exception.getMessage());
    }
}

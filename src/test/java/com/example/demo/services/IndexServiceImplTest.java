package com.example.demo.services;

import com.example.demo.repositories.IndexRepository;
import com.example.demo.services.impl.IndexServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IndexServiceImplTest {

    @Mock
    private IndexRepository indexRepository;

    @InjectMocks
    private IndexServiceImpl indexService;

    @Test
    void index_returnsValueFromRepository() {
        // arrange
        when(indexRepository.index()).thenReturn("OK");

        // act
        String result = indexService.index();

        // assert
        assertEquals("OK", result);
        verify(indexRepository, times(1)).index();
        verifyNoMoreInteractions(indexRepository);
    }

    @Test
    void index_propagatesExceptionFromRepository() {
        // arrange
        RuntimeException ex = new RuntimeException("repo failed");
        when(indexRepository.index()).thenThrow(ex);

        // act + assert
        RuntimeException thrown = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> indexService.index()
        );
        assertEquals("repo failed", thrown.getMessage());

        verify(indexRepository, times(1)).index();
        verifyNoMoreInteractions(indexRepository);
    }
}
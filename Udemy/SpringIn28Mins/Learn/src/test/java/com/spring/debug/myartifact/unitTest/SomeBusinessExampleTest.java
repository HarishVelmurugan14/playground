package com.spring.debug.myartifact.unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessExampleTest {
    @Mock //Simplifying code
    private DataService dataService;

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Test
    void checkValidityUsingMockWithInjections() {
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[]{7, 8, 6, 4});
        Assertions.assertEquals(someBusiness.fetchGreatestValue(),8);
    }

    @Test //Complex code
    void checkValidityUsingStub() {
        SomeBusinessImpl someBusiness =new SomeBusinessImpl(new DataServiceStubImpl());
        Assertions.assertEquals(someBusiness.fetchGreatestValue(),4);
    }

    @Test
    void checkValidityUsingMock() {
        DataService dataService = Mockito.mock(DataService.class);
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[]{7, 8, 6, 4});
        SomeBusinessImpl someBusiness =new SomeBusinessImpl(dataService);
        Assertions.assertEquals(someBusiness.fetchGreatestValue(),8);

    }

    class DataServiceStubImpl implements DataService{
        @Override
        public int[] retrieveAllData() {
            return new int[]{1,2,3,4};
        }
    }
}



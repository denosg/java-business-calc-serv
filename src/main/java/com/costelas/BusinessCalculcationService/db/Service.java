package com.costelas.BusinessCalculcationService.db;

import com.costelas.BusinessCalculcationService.db.DataService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Service {
    private DataService dataService;

    public Service(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}

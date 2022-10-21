package com.revature.servlets.ReportServiceTest;

import com.revature.Exceptions.DescriptionCannotBeBlankError;
import com.revature.Exceptions.NonPositiveAmountError;
import com.revature.dao.ReportDAOImpl;
import com.revature.models.Report;
import com.revature.services.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CreateReportTest {
    @Mock
    ReportDAOImpl reportDAO;
    @InjectMocks
    ReportService reportService = new ReportService();

    @Test
    public void amountLessThanZero() {
        Report report = new Report(1, -1.0f, "description");
        assertThrows(NonPositiveAmountError.class, () -> reportService.create(report));
    }

    @Test
    public void amountEqualToZero() {
        Report report = new Report(1, 0.0f, "description");
        assertThrows(NonPositiveAmountError.class, () -> reportService.create(report));
    }

    @Test
    public void descriptionBlank() {
        Report report = new Report(1, 10.0f, "");
        assertThrows(DescriptionCannotBeBlankError.class, () -> reportService.create(report));
    }

    @Test
    public void reportCreated() throws NonPositiveAmountError, DescriptionCannotBeBlankError {
        float amount = 5.0f;
        String description = "description";
        Report report = new Report(1, amount, description);
        Report reportDAOExpected = new Report(1, 1, 5.0f, "description", "Pending", new Date());
        Mockito.when(reportDAO.createReport(report)).thenReturn(reportDAOExpected);
        assertEquals(reportService.create(report), reportDAOExpected);
    }
}
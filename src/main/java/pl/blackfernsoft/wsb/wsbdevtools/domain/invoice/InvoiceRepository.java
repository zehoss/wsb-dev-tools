package pl.blackfernsoft.wsb.wsbdevtools.domain.invoice;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class InvoiceRepository {

    private final Map<Integer, Invoice> invoices = Stream.of(
            Invoice.of(1, "FV-001", LocalDate.now(), Arrays.asList(
                    Invoice.InvoiceItem.of("Rental", 5, BigDecimal.valueOf(200.0), BigDecimal.valueOf(23)),
                    Invoice.InvoiceItem.of("Insurance", 5, BigDecimal.valueOf(50.0), BigDecimal.valueOf(0)),
                    Invoice.InvoiceItem.of("Navigation-gps", 1, BigDecimal.valueOf(100.0), BigDecimal.valueOf(23))
            )),
            Invoice.of(2, "FV-002", LocalDate.now(), Arrays.asList(
                    Invoice.InvoiceItem.of("Rental", 14, BigDecimal.valueOf(200.0), BigDecimal.valueOf(23)),
                    Invoice.InvoiceItem.of("Insurance", 14, BigDecimal.valueOf(50.0), BigDecimal.valueOf(0)),
                    Invoice.InvoiceItem.of("Full assistance", 1, BigDecimal.valueOf(500.0), BigDecimal.valueOf(0))
            )),
            Invoice.of(3, "FV-003", LocalDate.now(), Arrays.asList(
                    Invoice.InvoiceItem.of("Rental", 1, BigDecimal.valueOf(200.0), BigDecimal.valueOf(23)),
                    Invoice.InvoiceItem.of("Insurance", 1, BigDecimal.valueOf(50.0), BigDecimal.valueOf(0))
            ))
    ).collect(Collectors.toMap(Invoice::getId, invoice -> invoice));

    public List<Invoice> findAll() {
        return new ArrayList<>(invoices.values());
    }

    public Invoice findById(Integer invoiceId) {
        return invoices.get(invoiceId);
    }
}

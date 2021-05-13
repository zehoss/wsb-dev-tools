package pl.blackfernsoft.wsb.wsbdevtools.domain.invoice;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Value(staticConstructor = "of")
public class Invoice {

    Integer id;
    String number;
    LocalDate issueDate;
    List<InvoiceItem> items;

    @Value(staticConstructor = "of")
    public static class InvoiceItem {
        String name;
        Integer amount;
        BigDecimal amountNet;
        BigDecimal varPercentage;
    }
}

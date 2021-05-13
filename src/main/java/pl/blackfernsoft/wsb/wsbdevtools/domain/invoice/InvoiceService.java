package pl.blackfernsoft.wsb.wsbdevtools.domain.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository repository;

    public List<Invoice> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    public Invoice inv(Integer invoiceId) {
        return repository.findById(invoiceId);
    }

    public BigDecimal calc(Integer invoiceId) {
        Invoice a = inv(invoiceId);
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice.InvoiceItem b : a.getItems()) {
            sum = sum.add(b.getAmountNet().add(b.getAmountNet().multiply(b.getVarPercentage()).divide(BigDecimal.valueOf(100))));
        }
        return sum;
    }

    public BigDecimal calculateNetOrGross(boolean netOrGros) {
        if (netOrGros) {
            List<Invoice> invoices = repository.findAll();
            BigDecimal sumInvoices = BigDecimal.ZERO;
            for (Invoice invoice : invoices) {
                BigDecimal sumItems = BigDecimal.ZERO;
                for (Invoice.InvoiceItem item : invoice.getItems()) {
                    sumItems = sumItems.add(item.getAmountNet());
                }
                sumInvoices = sumInvoices.add(sumItems);
            }
            return sumInvoices;
        } else {
            List<Invoice> invoices = repository.findAll();
            BigDecimal sumInvoices = BigDecimal.ZERO;
            for (Invoice invoice : invoices) {
                BigDecimal sum = BigDecimal.ZERO;
                for (Invoice.InvoiceItem item : invoice.getItems()) {
                    sum = sum.add(item.getAmountNet().add(item.getAmountNet().multiply(item.getVarPercentage()).divide(BigDecimal.valueOf(100))));
                }
                sumInvoices = sumInvoices.add(sum);
            }
            return sumInvoices;
        }
    }
}

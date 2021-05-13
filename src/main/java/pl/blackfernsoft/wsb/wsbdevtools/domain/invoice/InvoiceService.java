package pl.blackfernsoft.wsb.wsbdevtools.domain.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Disclaimer: This code is just an example of bad practices used as exercise to learn basic clean code rules
 * and refactorization.
 */
@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository repo;

    /**
     * find all invoices
     *
     * @return
     */
    public List<Invoice> findAll() {
        return new ArrayList<>(repo.findAll());
    }

    public Invoice inv(Integer invoiceId) {
        return repo.findById(invoiceId);
    }

    /**
     * This method calculates something.
     */
    public BigDecimal calc(Integer invoiceId) {
        Invoice a = inv(invoiceId);
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice.InvoiceItem b : a.getItems()) {
            sum = sum.add(b.getAmountNet().add(b.getAmountNet().multiply(b.getVarPercentage()).divide(BigDecimal.valueOf(100))));
        }
        return sum;
    }

    /**
     * Calculate sum of all invoices net or gross
     */
    public BigDecimal calculateNetOrGross(boolean netOrGross) {
        if (netOrGross) {
            List<Invoice> invoices = repo.findAll();
            BigDecimal sumB = BigDecimal.ZERO;
            for (Invoice invoice : invoices) {
                BigDecimal sumA = BigDecimal.ZERO;
                for (Invoice.InvoiceItem item : invoice.getItems()) {
                    sumA = sumA.add(item.getAmountNet());
                }
                sumB = sumB.add(sumA);
            }
            return sumB;
        } else {
            List<Invoice> invoices = repo.findAll();
            BigDecimal sumC = BigDecimal.ZERO;
            for (Invoice invoice : invoices) {
                BigDecimal sum = BigDecimal.ZERO;
                for (Invoice.InvoiceItem item : invoice.getItems()) {
                    sum = sum.add(item.getAmountNet().add(item.getAmountNet().multiply(item.getVarPercentage()).divide(BigDecimal.valueOf(100))));
                }
                sumC = sumC.add(sum);
            }
            return sumC;
        }
    }
}

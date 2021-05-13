package pl.blackfernsoft.wsb.wsbdevtools.domain.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @GetMapping
    public List<Invoice> getAll() {
        return service.findAll();
    }

    @GetMapping("/{invoiceId}")
    public Invoice findById(@PathVariable("invoiceId") Integer invoiceId) {
        return service.inv(invoiceId);
    }

    @GetMapping("/{invoiceId}/sum")
    public BigDecimal calculateAmountToPay(@PathVariable("invoiceId") Integer invoiceId) {
        return service.calc(invoiceId);
    }

    @GetMapping("/net")
    public BigDecimal calculateSumInvoicesNet() {
        return service.calculateNetOrGross(true);
    }

    @GetMapping("/gross")
    public BigDecimal calculateSumInvoicesGross() {
        return service.calculateNetOrGross(false);
    }
}

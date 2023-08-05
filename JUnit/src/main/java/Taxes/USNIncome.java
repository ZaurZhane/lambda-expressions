package Taxes;

public class USNIncome extends TaxSystem {

    @Override
    public int calcTaxFor(int debit, int credit) {
        if (debit <= 0) {
            return 0;
        } else {
            return debit * 6 / 100;
        }
    }
}

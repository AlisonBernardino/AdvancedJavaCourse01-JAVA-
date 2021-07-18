package courseActivities;

// "Bank" class
public class l01DataAbstraction {
    private String bankName;
    private String bankLocation;
    private int accountNumber;
    private int accountModel;
    private float accountBalance;
    private float accountTax;
    
    // Bank name - Data presentation
    public String bankNameData(){
        return this.bankName;
    }
    
    // Bank location - Data presentation
    public String bankLocationData(){
        return this.bankLocation;
    }
    
    // Bank account number - Data presentation
    public int accountNumberData(){
        return this.accountNumber;
    }
    
    // Bank account model - Data presentation
    public int accountModelData(){
        return this.accountModel;
    }
    
    // Bank account balance - "Credit added" status message
    public float addFundsToAccountBalance(float addedCredits){
        this.accountBalance += addedCredits;
        return this.accountBalance;
    }
    
    // Bank account tax - "Tax reduction" status message
    public float reduceTaxValues(float taxReduction){
        this.accountTax -= taxReduction;
        return this.accountTax;
    }
    
    public static void main(String[] args){
        l01DataAbstraction bankAccount01 = new l01DataAbstraction();
        
        System.out.println("===== S.B.S. - Smart Bank System v1.0 =====");
        System.out.println("Bank name = " + bankAccount01.bankNameData());
        System.out.println("Bank location = " + bankAccount01.bankLocationData());
        System.out.println("Bank account number = " + bankAccount01.accountNumberData());
        System.out.println("bank account model index = " + bankAccount01.accountModelData());
        System.out.println("Account balance - Before last deposit = " + bankAccount01.accountBalance);
        System.out.println("Account balance - After last deposit = " + bankAccount01.addFundsToAccountBalance(500));
        System.out.println("Account tax - Before last tax reduction = " + bankAccount01.accountTax);
        System.out.println("Account tax - After last tax reduction = " + bankAccount01.reduceTaxValues(1.5f));
    }
}

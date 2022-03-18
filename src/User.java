public class User {
    private double housingCost;
    private double initialPayment;
    private double monthlyIncome;
    private int amountOfFamilyMembers;
    private int amountOfChildren;
    private boolean isChildrenUnder18Years;


    private static final int MIN_MORTGAGE = 300_000;
    private static final int MAX_MORTGAGE = 60_000_000;

    User(){}

    boolean setMortgageAmount(double mortgageAmount) {
        if(mortgageAmount<MIN_MORTGAGE || mortgageAmount>MAX_MORTGAGE){
            System.out.println("Ипотечный кредит не может быть ниже 300_000 руб. и выше 60_000_000 руб.");
            return false;
        }
        else {
            this.housingCost = mortgageAmount;
            return true;
        }
    }

    boolean setInitialPayment(double initialPayment) {
        if(initialPayment < 0.2 * housingCost || initialPayment > 0.9 * housingCost){
            try{
                throw new IllegalArgumentException("Illegal value of initial payment");
            }
            catch (IllegalArgumentException e){
                System.out.println("Первоначальный взнос не может быть меньше 20% и более 90% от ипотечного кредита");
                return false;
            }
        }
        else{
            this.initialPayment = initialPayment;
            return true;
        }
    }

    boolean setAmountOfFamilyMembers(int amountOfFamilyMembers){
        if(amountOfFamilyMembers<0){
            try{
                throw new IllegalArgumentException("Illegal value of amountOfFamilyMembers");
            }
            catch (IllegalArgumentException e){
                System.out.println("Количество членов семьи, включая вас, не можеть быть меньше нуля.");
                return false;
            }
        }
        else{
            this.amountOfFamilyMembers = amountOfFamilyMembers;
            return true;
        }
    }

    boolean setAmountOfChildren(int amountOfChildren){
        if(amountOfChildren<0 || amountOfChildren>amountOfFamilyMembers){
            try{
                throw new IllegalArgumentException("Illegal value of amountOfChildren");
            }
            catch (IllegalArgumentException e){
                System.out.println("Количество детей не можеть быть меньше нуля или больше количества членов сеьми в целом.");
                    return false;
            }
        }
        else{
            this.amountOfChildren = amountOfChildren;
            return true;
        }
    }

    boolean setMonthlyIncome(double monthlyIncome) {
        if(monthlyIncome < 0){
            try{
                throw new IllegalArgumentException("Illegal value of monthlyIncome");
            }
            catch (IllegalArgumentException e){
                System.out.println("Ежемесячный доход не может быть отрицательным.");
                return false;
            }
        }
        else{
            this.monthlyIncome = monthlyIncome;
            return true;
        }
    }

    void setChildrenUnder18Years(boolean isChildrenUnder18Years) {
        this.isChildrenUnder18Years = isChildrenUnder18Years;
    }

    public double getHousingCost() {
        return housingCost;
    }

    public double getInitialPayment() {
        return initialPayment;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public int getAmountOfFamilyMembers() {
        return amountOfFamilyMembers;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public boolean isChildrenUnder18Years() {
        return isChildrenUnder18Years;
    }
}

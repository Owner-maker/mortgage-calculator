public class Mortgage {
    private User user;
    private double monthlyPaymentOfUser;
    private int yearsOfPaymentsOfUser=0;
    private int interestRate;
    private double mortgage;
    private boolean mortgagePermit;

    static final int[] YEARS_MORTGAGE = new int[]{2,3,4,5,6,7,10,15,20,25,30};
    private static final int AVERAGE_COST_OF_LIVING_ADULT = 9000;
    private static final int AVERAGE_COST_OF_LIVING_CHILD = 7000;

    public Mortgage(User user) {
        this.user = user;
    }

    public void setAttribs(){
        this.mortgage=user.getHousingCost()-user.getInitialPayment();
        if(!user.isChildrenUnder18Years())this.interestRate=12;
        else this.interestRate=9;

        int amountOfAdultsOfUser = user.getAmountOfFamilyMembers()-user.getAmountOfChildren();
        double maxMonthlyPayment = user.getMonthlyIncome() - (amountOfAdultsOfUser*AVERAGE_COST_OF_LIVING_ADULT + user.getAmountOfChildren()*AVERAGE_COST_OF_LIVING_CHILD);


        double interestRatePerMonth = (double)this.interestRate/1200;
        for (int year:YEARS_MORTGAGE){
            int months = year*12;
            double payment = this.mortgage * interestRatePerMonth * Math.pow(1 + interestRatePerMonth,months) / ( Math.pow(1 + interestRatePerMonth,months) -1 );
            if(payment < maxMonthlyPayment){
                this.yearsOfPaymentsOfUser=year;
                this.monthlyPaymentOfUser=payment;
                if(this.yearsOfPaymentsOfUser==0)this.mortgagePermit=false;
                else this.mortgagePermit=true;
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        if(!this.mortgagePermit)sb.append("Вам отклонен ипотечный кредит по причине недостаточного ежемесячного дохода.");
        else {
            sb.append("Вам может быть одобрен ипотечный кредит по следующим условиям:\n");
            sb.append("Сумма кредита:" + this.mortgage)
                    .append("\nСумма первоначалього взноса: " + this.user.getInitialPayment())
                    .append("\nЕжемеясчный платеж: " + (int)this.monthlyPaymentOfUser)
                    .append("\nКоличество лет: " + this.yearsOfPaymentsOfUser)
                    .append("\nПроцентная ставка в год: " + this.interestRate);
        }
        return String.valueOf(sb);
    }
}
